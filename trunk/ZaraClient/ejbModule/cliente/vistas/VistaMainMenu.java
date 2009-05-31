package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.MainMenu;
import framework.vista.Vista;

public class VistaMainMenu extends Vista {
	MainMenu vistaGrafica;
	
	public VistaMainMenu(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new MainMenu(this);
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public void actualizar() {
		// TODO Auto-generated method stub		
	}

}
