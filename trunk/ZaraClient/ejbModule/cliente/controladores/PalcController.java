package cliente.controladores;

import java.util.Date;

import server.VO.EnvT.EnvTVO;
import cliente.XML.ParseXML;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaRecEnvT;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class PalcController extends Controlador {

	public PalcController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}
	
	public Date checkPALC(String hash){		
		return ((ZaraModel)this.getModelo()).getFachada().checkPedidoExistente(hash);			
	}
	
	public void generaPALC(){
	
	}
	
	public void registraPALC(){
		
	}
	
	public void cerrar(){
		((VistaRecEnvT)this.getVista()).cerrar();
	}

}
