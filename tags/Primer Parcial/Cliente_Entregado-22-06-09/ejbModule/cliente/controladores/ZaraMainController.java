/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.controladores;


import cliente.modelo.ZaraModel;
import cliente.vistas.VistaOfAD;
import cliente.vistas.VistaPALC;
import cliente.vistas.VistaRecEnvT;
import cliente.vistas.VistaVentaArticulos;
import framework.controlador.Controlador;
import framework.vista.Vista;

public class ZaraMainController extends Controlador{
	
	private ZaraModel modelo;	

	public ZaraMainController(ZaraModel mod, Vista vis) {
		super(mod, vis);
		this.modelo = mod;
	}
	
	public void mostrarOfAD(){
		VistaOfAD vista = VistaOfAD.getInstance(modelo);
		new OfADController(modelo, vista);		
	}

	public void mostrarVentas() {
		VistaVentaArticulos vista = VistaVentaArticulos.getInstance(modelo);
		new VentaArticulosController(modelo, vista);
	}

	public void mostrarPALC() {
		VistaPALC vista = VistaPALC.getInstance(modelo);
		new PalcController(modelo, vista);		
	}

	public void mostrarEnvT() {
		VistaRecEnvT vista = VistaRecEnvT.getInstance(modelo);
		new EnvTController(modelo, vista);
	}
	
	public void salirSistema(){
		System.exit(0);
	}

}
