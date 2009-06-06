package cliente.controladores;

import java.util.Date;

import server.VO.EnvT.EnvTVO;
import cliente.XML.ParseXML;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaRecEnvT;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class EnvTController extends Controlador {

	public EnvTController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}
	
	public Date checkEnvT(String hash){		
		return ((ZaraModel)this.getModelo()).getFachada().checkPedidoExistente(hash);			
	}
	
	public void cargarEnvT(boolean save){
		
		EnvTVO envt = ParseXML.parseEnvT("/UADE/workspace/ZaraClient/ejbModule/cliente/XML/xmls/EnvT.xml");				
		
		if (save) {
			Date fechaEnvT = checkEnvT(envt.getXmlHash());
			
			if (fechaEnvT == null || (fechaEnvT != null && ((VistaRecEnvT)this.getVista()).showPopup(fechaEnvT) == 0)) {
				// Persisto el cambio de stock
				envt = ((ZaraModel)this.getModelo()).getFachada().nuevoEnvT(envt, save);
			}
			else if (fechaEnvT != null){			
				System.err.println("Carga EnvT cancelada");
			}									
		}
		else 
		{
			// Pido un envtVO con la descripcion de los articulos y eventualmente los persisto
			envt = ((ZaraModel)this.getModelo()).getFachada().nuevoEnvT(envt, save);
		}
						
		// Cargo los datos
		((VistaRecEnvT)this.getVista()).cargarDatos(envt);
		
	}
	
	public void cerrar(){
		((VistaRecEnvT)this.getVista()).cerrar();
	}

}
