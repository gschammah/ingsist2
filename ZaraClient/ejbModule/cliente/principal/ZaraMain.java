package cliente.principal;

import javax.naming.NamingException;

import cliente.controladores.ZaraMainController;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaMainMenu;

public class ZaraMain {

	public static void main(String[] args) {		
		new ZaraMain();
	}
	
	public ZaraMain(){
		ZaraModel modelo;
		
		try {
			modelo = new ZaraModel();
		} catch (NamingException e) {
			e.printStackTrace();
			modelo = null;
		}		
		VistaMainMenu mainMenu = new VistaMainMenu(modelo);
		new ZaraMainController(modelo, mainMenu);
	}
	

}
