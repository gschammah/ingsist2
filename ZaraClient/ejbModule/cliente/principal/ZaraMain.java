package cliente.principal;

import cliente.controladores.ZaraMainController;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaMainMenu;

public class ZaraMain {

	public static void main(String[] args) {		
		new ZaraMain();
	}
	
	public ZaraMain(){
		ZaraModel modelo = new ZaraModel();		
		VistaMainMenu mainMenu = new VistaMainMenu(modelo);
		new ZaraMainController(modelo, mainMenu);
	}
	

}
