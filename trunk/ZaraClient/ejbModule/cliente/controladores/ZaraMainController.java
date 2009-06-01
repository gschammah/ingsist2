package cliente.controladores;


import java.util.Date;

import server.VO.OfAD.OfADVO;
import cliente.XML.ParseXML;
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
		OfADController ofad = new OfADController((ZaraModel) this.getModelo(), vista);		
	}

	public void mostrarVentas() {
		new VistaVentaArticulos((ZaraModel) this.getModelo());
	}

	public void mostrarPALC() {
		new VistaPALC((ZaraModel) this.getModelo());
	}

	public void mostrarEnvT() {
		new VistaRecEnvT((ZaraModel) this.getModelo());
	}
	
	public void salirSistema(){
		System.exit(0);
	}

}
