package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.OfAD;
import cliente.vistas.gui.VentaArticulos;
import framework.vista.Vista;

public class VistaVentaArticulos extends Vista {
	
	private VentaArticulos vistaGrafica;

	public VistaVentaArticulos(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new VentaArticulos(this);
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public void actualizar() {
		// TODO Auto-generated method stub		
	}

}
