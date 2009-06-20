package cliente.controladores;

import server.VO.PALC.PALCVO;
import cliente.vistas.VistaListadoPALC;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;

public class ListadoPalcController extends Controlador {
	
	private VistaListadoPALC vista;
		
	public ListadoPalcController(ProxyModelo modelo, VistaListadoPALC vista,
			PALCVO palc) {
		super(modelo, vista);
		this.vista = vista;
		cargarDatos(palc);
	}

	private void cargarDatos(PALCVO palc) {
		vista.cargarDatos(palc);		
	}

	public void cerrar(){
		vista.cerrar();
	}

}
