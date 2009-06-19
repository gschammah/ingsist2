package cliente.controladores;


import cliente.modelo.ZaraModel;
import cliente.vistas.VistaOfAD;
import cliente.vistas.VistaPALC;
import cliente.vistas.VistaRecEnvT;
import cliente.vistas.VistaVentaArticulos;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class ZaraMainController extends Controlador{

	public ZaraMainController(ProxyModelo mod, Vista vis) {
		super(mod, vis);		
	}
	
	public void mostrarOfAD(){
		VistaOfAD vista = VistaOfAD.getInstance((ZaraModel) this.getModelo());
		new OfADController(this.getModelo(), vista);		
	}

	public void mostrarVentas() {
		VistaVentaArticulos vista = VistaVentaArticulos.getInstance((ZaraModel) this.getModelo());
		new VentaArticulosController(this.getModelo(), vista);
	}

	public void mostrarPALC() {
		VistaPALC vista = VistaPALC.getInstance((ZaraModel) this.getModelo());
		new PalcController(this.getModelo(), vista);		
	}

	public void mostrarEnvT() {
		VistaRecEnvT vista = VistaRecEnvT.getInstance((ZaraModel) this.getModelo());
		new EnvTController(this.getModelo(), vista);
	}
	
	public void salirSistema(){
		System.exit(0);
	}

}
