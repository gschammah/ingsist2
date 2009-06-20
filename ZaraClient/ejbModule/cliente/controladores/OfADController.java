package cliente.controladores;

import java.io.File;
import java.util.Date;

import javax.swing.JFileChooser;

import server.VO.OfAD.OfADVO;
import cliente.XML.ParseXML;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaOfAD;
import cliente.vistas.VistaUtils;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class OfADController extends Controlador {

	private OfADVO ofadVO = null;

	public OfADController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		cargarOfAD(false);
	}

	public Date checkOfAD(String hash) {
		return ((ZaraModel) this.getModelo()).getFachada().checkExistingOfad(hash);
	}

	public void cargarOfAD(boolean save) {

		if (save) {

			Date fechaOfad = checkOfAD(ofadVO.getXmlHash());

			if (fechaOfad == null || (fechaOfad != null && ((VistaOfAD) this.getVista()).showPopup(fechaOfad) == 0)) {
				ofadVO = ((ZaraModel) this.getModelo()).getFachada().nuevoOfad(ofadVO, save);
				
				// Cargo los datos
				((VistaOfAD) this.getVista()).cargarDatos(ofadVO);
				((VistaOfAD) this.getVista()).disableButton();
				
			} 
		} 
		else {

			JFileChooser fc = new JFileChooser();			
			fc.showOpenDialog(((VistaOfAD) this.getVista()).getVistaGrafica());			
			File selFile = fc.getSelectedFile();
			
			ofadVO = null;

			if (selFile != null) {

				String filename = selFile.getAbsolutePath();
				try {
					ofadVO = ParseXML.parseOfAD(filename);
					ofadVO = ((ZaraModel) this.getModelo()).getFachada().nuevoOfad(ofadVO, save);
					
					// Cargo los datos
					((VistaOfAD) this.getVista()).cargarDatos(ofadVO);
					
				} catch (Exception e) {					
					//TODO log error
					VistaUtils.showErrorPopup(((VistaOfAD) this.getVista()).getVistaGrafica(), "El XML no es un OFAD válido.");
				}
												
			}
		}
		
	}

	public void cerrar() {
		((VistaOfAD) this.getVista()).cerrar();
	}

}
