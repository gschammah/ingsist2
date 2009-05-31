package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.ListadoPALC;
import cliente.vistas.gui.OfAD;
import framework.vista.Vista;

public class VistaListadoPALC extends Vista {
	
	private ListadoPALC vistaGrafica;

	public VistaListadoPALC(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new ListadoPALC(this);
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public void actualizar() {
		// TODO Auto-generated method stub		
	}

}
