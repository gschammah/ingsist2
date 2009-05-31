package cliente.vistas;

import java.awt.Window;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.OfAD;
import cliente.vistas.gui.PALC;
import framework.vista.Vista;

public class VistaPALC extends Vista {
		
	private PALC vistaGrafica;

	public VistaPALC(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new PALC(this);
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public void actualizar() {
		// TODO Auto-generated method stub		
	}

}
