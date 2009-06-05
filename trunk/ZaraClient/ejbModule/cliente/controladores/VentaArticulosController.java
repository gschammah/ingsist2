package cliente.controladores;

import java.util.Calendar;
import java.util.Collection;
import java.util.Vector;

import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;
import server.VO.ventas.VentaVO;
import cliente.constantes.ZaraConstants;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaVentaArticulos;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class VentaArticulosController extends Controlador {

	public VentaArticulosController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}

	public ArticuloVO getArticulo(long ref) {
		return ((ZaraModel) this.getModelo()).getFachada()
				.buscarArticuloVO(ref);
	}

	public void cerrar() {
		((VistaVentaArticulos) this.getVista()).cerrar();
	}

	public void agregarArticulo(long ref) {
		ArticuloVO art = getArticulo(ref);
		if (art == null) {
			((VistaVentaArticulos) this.getVista())
					.showErrorPopup("El articulo no existe");
		} else {
			((VistaVentaArticulos) this.getVista()).agregarArticulo(art);
		}
	}

	public void nuevaVenta(Vector<Vector<Object>> datos) {

		VentaVO venta = new VentaVO();

		venta.setFecha(Calendar.getInstance().getTime());
		venta.setTipoFactura('A');

		for (Vector<Object> fila : datos) {
			ItemVentaVO itemVenta = new ItemVentaVO();
			ArticuloVO art = getArticulo(Long.parseLong(fila.get(0).toString()));

			itemVenta.setArticulo(art);
			itemVenta.setPrecio(Float.parseFloat(fila.get(3).toString()));
			itemVenta.setCantidad(Integer.parseInt(fila.get(5).toString()));

			venta.addItem(itemVenta);
		}

		Collection<ArticuloVO> result = ((ZaraModel) this.getModelo())
				.getFachada().nuevaVenta(venta);

		if (result != null) {
			((VistaVentaArticulos) this.getVista()).toggleError(result);
		}

	}

	public void togglePrecio(long ref, String tipo, int fila) {					
		if (tipo == ZaraConstants.PRECIO_OFERTA) {
			
			float precioOferta = getArticulo(ref).getPrecioOferta();
			
			if (precioOferta != 0)
			{
				((VistaVentaArticulos)this.getVista()).togglePrecio(fila, precioOferta);
			}
			
		} else if (tipo == ZaraConstants.PRECIO_LISTA) {
			
			((VistaVentaArticulos)this.getVista()).togglePrecio(fila, getArticulo(ref).getPrecioLista());
			
		}		
	}

	public void borrarArticulo(long ref, int row) {
		((VistaVentaArticulos)this.getVista()).borrarArticulo(row);
	}

}
