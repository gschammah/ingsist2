package cliente.controladores;

import java.util.Date;

import server.VO.OfAD.OfADVO;

import cliente.XML.ParseXML;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaOfAD;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class OfADController extends Controlador {

	public OfADController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}
	
	public Date checkOfAD(String hash){		
		return ((ZaraModel)this.getModelo()).getAdmArt().checkExistingOfad(hash);			
	}
	
	public void cargarOfAD(){
		Date fechaOfad = checkOfAD("d1b4d1179b233256d37e420d255278");
		if (fechaOfad == null || (fechaOfad != null && ((VistaOfAD)this.getVista()).showPopup(fechaOfad) == 0)) {
			OfADVO ofadVO = ParseXML.parseOfAD("/UADE/workspace/ZaraClient/ejbModule/cliente/XML/xmls/OFAD.xml");
			((VistaOfAD)this.getVista()).cargarDatos(((ZaraModel)this.getModelo()).getAdmArt().nuevoOfad(ofadVO));			
		}
		else if (fechaOfad != null){			
			System.err.println("Carga OfAD cancelada");
		}
	}
	
	public void cerrar(){
		((VistaOfAD)this.getVista()).getVistaGrafica().dispose();
	}

}
