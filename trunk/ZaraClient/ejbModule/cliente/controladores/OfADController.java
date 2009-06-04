package cliente.controladores;

import java.util.Date;

import server.VO.OfAD.OfADVO;

import cliente.XML.ParseXML;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaOfAD;
import cliente.vistas.VistaRecEnvT;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class OfADController extends Controlador {

	public OfADController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}

	public Date checkOfAD(String hash) {
		return ((ZaraModel) this.getModelo()).getFachada().checkExistingOfad(
				hash);
	}

	public void cargarOfAD(boolean save) {

		OfADVO ofadVO = ParseXML.parseOfAD("/UADE/workspace/ZaraClient/ejbModule/cliente/XML/xmls/OFAD.xml");
		

		if (save) {

			Date fechaOfad = checkOfAD(ofadVO.getXmlHash());

			if (fechaOfad == null || (fechaOfad != null && ((VistaOfAD) this.getVista()).showPopup(fechaOfad) == 0)) {
				ofadVO = ((ZaraModel) this.getModelo()).getFachada().nuevoOfad(ofadVO, save);
			} else if (fechaOfad != null) {
				System.err.println("Carga OfAD cancelada");
			}
		}
		else
		{
			ofadVO = ((ZaraModel) this.getModelo()).getFachada().nuevoOfad(ofadVO, save);
			ofadVO.setFecha(checkOfAD(null));
		}
		
		// Cargo los datos
		((VistaOfAD)this.getVista()).cargarDatos(ofadVO);
	}

	public void cerrar() {
		((VistaOfAD) this.getVista()).cerrar();
	}

}
