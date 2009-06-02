package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.ListadoPALC;
import framework.vista.Vista;

public class VistaListadoPALC extends Vista {
	
	private ListadoPALC vistaGrafica;

	public VistaListadoPALC(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new ListadoPALC(this);
		
		this.centrarVista(vistaGrafica);
		
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
		
}
