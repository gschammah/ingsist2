package cliente.controladores;

import java.util.Calendar;
import java.util.Vector;

import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;
import server.VO.ventas.VentaVO;
import cliente.constantes.ZaraConstants;
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
	
	public void nuevaVenta(Vector<Vector<Object>> datos, Object[] datosT) {

		VentaVO venta = new VentaVO();

		venta.setFecha(Calendar.getInstance().getTime());
		venta.setTipoFactura(vista.getTipoFactura());

		for (Vector<Object> fila : datos) {
			ItemVentaVO itemVenta = new ItemVentaVO();
			ArticuloVO art = getArticulo(Long.parseLong(fila.get(0).toString()));

			itemVenta.setArticulo(art);
			itemVenta.setPrecio(Float.parseFloat(fila.get(3).toString()));
			itemVenta.setCantidad(Integer.parseInt(fila.get(5).toString()));

			venta.addItem(itemVenta);
		}
		
		venta.setSubTotal(Float.parseFloat(datosT[0].toString()));
		venta.setIva(Float.parseFloat(datosT[1].toString()));
		venta.setTotal(Float.parseFloat(datosT[2].toString()));

		VentaVO result = (modelo.getFachada().nuevaVenta(venta));
				
		if (result.isHayStock()){
			nuevaFactura(result);
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
	
	

}
