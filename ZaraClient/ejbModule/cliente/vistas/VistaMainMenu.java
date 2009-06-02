package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.MainMenu;
import framework.vista.Vista;

public class VistaMainMenu extends Vista {	
	
	private MainMenu vistaGrafica;

	public VistaMainMenu(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new MainMenu(this);
		
		this.centrarVista(vistaGrafica);
		
		vistaGrafica.pack();				
		vistaGrafica.setVisible(true);
	}
	

}
