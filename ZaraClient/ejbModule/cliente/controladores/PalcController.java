package cliente.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaListadoPALC;
import cliente.vistas.VistaPALC;
import cliente.vistas.VistaUtils;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class PalcController extends Controlador {

	public PalcController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		cargaPALC();
	}
	
	public Date checkPALC(String hash){		
		return ((ZaraModel)this.getModelo()).getFachada().checkPedidoExistente(hash);			
	}
		
	public void cargaPALC(){
		Collection<PalcPropuestoVO> palc = ((ZaraModel)this.getModelo()).getFachada().getPALC();
		((VistaPALC)this.getVista()).cargarDatos(palc);
	}
	
	public void registraPALC(){
		
		Collection<ItemPALCVO> articulos = ((VistaPALC)this.getVista()).getArticulosElegidos();
		PALCVO palc = new PALCVO();
		palc.setArticulos(articulos);
		palc.setEstado("Emitido");
		palc.setFecha(Calendar.getInstance().getTime());
		
		if (((ZaraModel)this.getModelo()).getFachada().registraPALC(palc)) {
			VistaListadoPALC vista = VistaListadoPALC.getInstance((ZaraModel) this.getModelo());
			new ListadoPalcController(this.getModelo(), vista, palc);
		}
		else
		{
			VistaUtils.showErrorPopup(((VistaPALC)this.getVista()).getVistaGrafica(), "Se ha producido un error");
		}
		
		
	}
	
	public void cerrar(){		
		((VistaPALC)this.getVista()).cerrar();
	}

	public void agregaArticulo(Long ref) {				
		PalcPropuestoVO palc = ((ZaraModel)this.getModelo()).getFachada().getPALC(ref);
		((VistaPALC)this.getVista()).cargarDatos(palc);
	}

	public void showNumericoPopup() {
		VistaUtils.showErrorPopup(((VistaPALC)this.getVista()).getVistaGrafica(), "El nro de referencia debe ser numérico");		
	}
	
	public void showExistentePopup() {
		VistaUtils.showErrorPopup(((VistaPALC)this.getVista()).getVistaGrafica(), "El artículo ingresado ya figura en el PALC sugerido");		
	}
		

}
