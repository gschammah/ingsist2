package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.MainMenu;
import cliente.vistas.gui.OfAD;
import framework.vista.Vista;

public class VistaOfAD extends Vista {	
	private OfAD vistaGrafica;

	public VistaOfAD(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new OfAD(this);
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public void actualizar() {
		// TODO Auto-generated method stub		
	}

}
