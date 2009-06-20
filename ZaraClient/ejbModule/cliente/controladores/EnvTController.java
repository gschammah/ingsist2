package cliente.controladores;

import java.io.File;
import java.util.Date;

import javax.swing.JFileChooser;

import server.VO.EnvT.EnvTVO;
import cliente.XML.ParseXML;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaOfAD;
import cliente.vistas.VistaRecEnvT;
import cliente.vistas.VistaUtils;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class EnvTController extends Controlador {
	
	private EnvTVO envt = null;

	public EnvTController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		cargarEnvT(false);
	}
	
	public Date checkEnvT(String hash){		
		return ((ZaraModel)this.getModelo()).getFachada().checkPedidoExistente(hash);			
	}
	
	public void cargarEnvT(boolean save){
							
		if (save) {
			Date fechaEnvT = checkEnvT(envt.getXmlHash());
			
			if (fechaEnvT == null || (fechaEnvT != null && ((VistaRecEnvT)this.getVista()).showPopup(fechaEnvT) == 0)) {
				// Persisto el cambio de stock
				envt = ((ZaraModel)this.getModelo()).getFachada().nuevoEnvT(envt, save);
				
				// Cargo los datos
				((VistaRecEnvT)this.getVista()).cargarDatos(envt);
				((VistaRecEnvT) this.getVista()).disableButton();
			}												
		}
		else 
		{
			JFileChooser fc = new JFileChooser();			
			fc.showOpenDialog(((VistaRecEnvT) this.getVista()).getVistaGrafica());			
			File selFile = fc.getSelectedFile();
			
			envt = null;
			
			if (selFile != null) {

				String filename = selFile.getAbsolutePath();
				try {
					envt = ParseXML.parseEnvT(filename);
					
					// Pido un envtVO con la descripcion de los articulos y eventualmente los persisto
					envt = ((ZaraModel)this.getModelo()).getFachada().nuevoEnvT(envt, save);
					
					// Cargo los datos
					((VistaRecEnvT)this.getVista()).cargarDatos(envt);
					
				} catch (Exception e) {					
					//TODO log error
					VistaUtils.showErrorPopup(((VistaRecEnvT) this.getVista()).getVistaGrafica(), "El XML no es un EnvT válido.");
				}
												
			}
						
		}
								
		
	}
	
	public void cerrar(){
		((VistaRecEnvT)this.getVista()).cerrar();
	}

}
