/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.controladores;

import java.io.File;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.JFileChooser;

import server.VO.OfAD.OfADVO;
import cliente.modelo.ZaraModel;
import cliente.tools.ParseXML;
import cliente.vistas.VistaOfAD;
import cliente.vistas.VistaUtils;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class OfADController extends Controlador {

	private OfADVO ofadVO = null;
	private VistaOfAD vista;
	private ZaraModel modelo;

	public OfADController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		this.vista = (VistaOfAD) vis;
		this.modelo = (ZaraModel) mod;
		cargarOfAD(false);
	}

	public Date checkOfAD(String hash) {
		return modelo.getFachada().checkExistingOfad(hash);
	}

	public void cargarOfAD(boolean save) {

		if (save) {

			Date fechaOfad = checkOfAD(ofadVO.getXmlHash());

			if (fechaOfad == null || (fechaOfad != null && vista.showPopup(fechaOfad) == 0)) {
				ofadVO = modelo.getFachada().nuevoOfad(ofadVO, save);
											
				// Cargo los datos
				vista.cargarDatos(ofadVO);
				vista.disableButton();
				
				Logger.getLogger("ofad").info("Ofad cargado satisfactoriamente. Se cargaron " + ofadVO.getArticulos().size() + " artículos.");
				
			} 
		} 
		else {

			JFileChooser fc = new JFileChooser();			
			fc.showOpenDialog(vista.getVistaGrafica());			
			File selFile = fc.getSelectedFile();
			
			ofadVO = null;

			if (selFile != null) {

				String filename = selFile.getAbsolutePath();
				try {
					ofadVO = ParseXML.parseOfAD(filename);
					ofadVO = modelo.getFachada().nuevoOfad(ofadVO, save);
					
					// Cargo los datos
					vista.cargarDatos(ofadVO);
					
				} 				
				catch (Exception e) {
					e.printStackTrace();
					Logger.getLogger("ofad").warning("El XML no es un OFAD válido.");
					VistaUtils.showErrorPopup(vista.getVistaGrafica(), "El XML no es un OFAD válido.");
				}
												
			}
		}
		
	}

	public void cerrar() {
		vista.cerrar();
	}

}
