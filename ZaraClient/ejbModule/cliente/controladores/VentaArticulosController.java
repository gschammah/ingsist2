/*
 * Ingenierķa en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.controladores;

import java.util.Calendar;
import java.util.Vector;

import server.VO.articulos.ArticuloVO;
import server.VO.clientes.ClienteVO;
import server.VO.ventas.ItemVentaVO;
import server.VO.ventas.VentaVO;
import cliente.constantes.ZaraConstants;
import cliente.modelo.DatosT;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaFactura;
import cliente.vistas.VistaUtils;
import cliente.vistas.VistaVentaArticulos;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class VentaArticulosController extends Controlador {
	
	private VistaVentaArticulos vista;
	private ZaraModel modelo;

	public VentaArticulosController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		this.modelo = (ZaraModel) mod;
		this.vista = (VistaVentaArticulos) vis;
	}

	public ArticuloVO getArticulo(long ref) {
		return modelo.getFachada().buscarArticuloVO(ref);
	}

	public void cerrar() {
		vista.cerrar();
	}

	public void agregarArticulo(long ref) {
		ArticuloVO art = getArticulo(ref);
		if (art == null) {
			VistaUtils.showErrorPopup(vista.getVistaGrafica(), "El articulo no existe");
		} else {
			vista.agregarArticulo(art);
		}
	}
	
	public void nuevaVenta(Vector<Vector<Object>> datos, DatosT datosT, ClienteVO cliente) {

		VentaVO venta = new VentaVO();

		venta.setFecha(Calendar.getInstance().getTime());
		venta.setTipoFactura(vista.getTipoFactura());

		for (Vector<Object> fila : datos) {
			ItemVentaVO itemVenta = new ItemVentaVO();
			ArticuloVO art = getArticulo(Long.parseLong(fila.get(0).toString()));

			itemVenta.setArticulo(art);
			
			double d = Double.parseDouble(fila.get(3).toString());
			if (vista.getTipoFactura() == 'A'){
				d = d/1.21;
			};
			
			itemVenta.setPrecio(Float.parseFloat(Double.toString(d)));
			itemVenta.setCantidad(Integer.parseInt(fila.get(5).toString()));

			venta.addItem(itemVenta);
		}
		
		venta.setSubTotal(datosT.getSubTotal());
		venta.setIva(datosT.getIva());
		venta.setTotal(datosT.getTotal());
		
		venta.setCliente(cliente);

		VentaVO result = (modelo.getFachada().nuevaVenta(venta));
				
		if (result.isHayStock()){
			nuevaFactura(result);
			vista.toggleError(null);
		}
		else
		{
			vista.toggleError(result.getItems());
		}
		
			
		
		
		
		
		

	}
	public void nuevaFactura(VentaVO ventaVO){
		
				
		VistaFactura vista = VistaFactura.getInstance(modelo);
		new FacturaController(this.getModelo(), vista);
		
		((FacturaController) vista.getControlador()).setData(ventaVO);
		
	}

	public void togglePrecio(long ref, String tipo, int fila) {					
		if (tipo == ZaraConstants.PRECIO_OFERTA) {
			
			float precioOferta = getArticulo(ref).getPrecioOferta();
			
			if (precioOferta != 0)
			{
				vista.togglePrecio(fila, precioOferta);
			}
			
		} else if (tipo == ZaraConstants.PRECIO_LISTA) {
			
			vista.togglePrecio(fila, getArticulo(ref).getPrecioLista());
			
		}		
	}

	public void borrarArticulo(long ref, int row) {
		vista.borrarArticulo(row);
	}
	
	public void showNumericoPopup() {
		VistaUtils.showNumericoPopup(vista.getVistaGrafica());		
	}
	
	public ClienteVO getCliente(String cuit){
		return modelo.getFachada().buscarCliente(cuit);
	}
	

}
