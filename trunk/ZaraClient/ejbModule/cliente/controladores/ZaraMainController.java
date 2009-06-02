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
		VistaOfAD vista = new VistaOfAD((ZaraModel) this.getModelo());
		new OfADController(this.getModelo(), vista);		
	}

	public void mostrarVentas() {
		new VistaVentaArticulos((ZaraModel) this.getModelo());
	}

	public void mostrarPALC() {
		new VistaPALC((ZaraModel) this.getModelo());
	}

	public void mostrarEnvT() {
		VistaRecEnvT vista = new VistaRecEnvT((ZaraModel) this.getModelo());
		new EnvTController(this.getModelo(), vista);
	}
	
	public void salirSistema(){
		System.exit(0);
	}

}
