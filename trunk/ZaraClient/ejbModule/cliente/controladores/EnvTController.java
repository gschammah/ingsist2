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
	private VistaRecEnvT vista;
	private ZaraModel modelo;

	public EnvTController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		this.vista = (VistaRecEnvT) vis;
		this.modelo = (ZaraModel) mod;
		cargarEnvT(false);
	}
	
	public Date checkEnvT(String hash){		
		return modelo.getFachada().checkPedidoExistente(hash);			
	}
	
	public void cargarEnvT(boolean save){
							
		if (save) {
			Date fechaEnvT = checkEnvT(envt.getXmlHash());
			
			if (fechaEnvT == null || (fechaEnvT != null && (vista.showPopup(fechaEnvT) == 0))) {
				// Persisto el cambio de stock
				envt = modelo.getFachada().nuevoEnvT(envt, save);
				
				// Cargo los datos
				vista.cargarDatos(envt);
				vista.disableButton();
			}												
		}
		else 
		{
			JFileChooser fc = new JFileChooser();			
			fc.showOpenDialog(vista.getVistaGrafica());			
			File selFile = fc.getSelectedFile();
			
			envt = null;
			
			if (selFile != null) {

				String filename = selFile.getAbsolutePath();
				try {
					envt = ParseXML.parseEnvT(filename);
					
					// Pido un envtVO con la descripcion de los articulos y eventualmente los persisto
					envt = modelo.getFachada().nuevoEnvT(envt, save);
					
					// Cargo los datos
					vista.cargarDatos(envt);
					
				} catch (Exception e) {					
					//TODO log error
					VistaUtils.showErrorPopup(vista.getVistaGrafica(), "El XML no es un EnvT v�lido.");
				}
												
			}
						
		}
								
		
	}
	
	public void cerrar(){
		vista.cerrar();
	}

}
