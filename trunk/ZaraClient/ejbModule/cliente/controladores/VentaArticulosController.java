package cliente.controladores;

import server.VO.articulos.ArticuloVO;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaVentaArticulos;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class VentaArticulosController extends Controlador {

	public VentaArticulosController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}
	
	public ArticuloVO getArticulo(long ref){
		return ((ZaraModel)this.getModelo()).getFachada().buscarArticuloVO(ref);				
	}
	
	
	public void cerrar(){
		((VistaVentaArticulos)this.getVista()).cerrar();
	}

	public void agregarArticulo(long ref) {		
		ArticuloVO art = getArticulo(ref);
		if (art == null)
		{
			((VistaVentaArticulos)this.getVista()).showErrorPopup("El articulo no existe");
		}
		else
		{
			((VistaVentaArticulos)this.getVista()).agregarArticulo(art);
		}
	}

}
