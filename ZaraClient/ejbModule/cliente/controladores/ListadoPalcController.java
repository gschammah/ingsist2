package cliente.controladores;

import server.VO.PALC.PALCVO;
import cliente.vistas.VistaListadoPALC;
import cliente.vistas.VistaRecEnvT;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class ListadoPalcController extends Controlador {
		
	public ListadoPalcController(ProxyModelo modelo, VistaListadoPALC vista,
			PALCVO palc) {
		super(modelo, vista);
		
		cargarDatos(palc);
	}

	private void cargarDatos(PALCVO palc) {
		((VistaListadoPALC)this.getVista()).cargarDatos(palc);		
	}

	public void cerrar(){
		((VistaListadoPALC)this.getVista()).cerrar();
	}

}
