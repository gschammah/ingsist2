package cliente.controladores;

import cliente.vistas.VistaRecEnvT;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class ListadoPalcController extends Controlador {

	public ListadoPalcController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}
		
	public void cerrar(){
		((VistaRecEnvT)this.getVista()).cerrar();
	}

}
