package cliente.controladores;

import cliente.vistas.VistaRecEnvT;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class FacturaController extends Controlador {

	public FacturaController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}
		
	public void cerrar(){
		((VistaRecEnvT)this.getVista()).cerrar();
	}

}
