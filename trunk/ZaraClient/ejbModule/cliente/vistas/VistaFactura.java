package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.Factura;
import cliente.vistas.gui.OfAD;
import framework.vista.Vista;

public class VistaFactura extends Vista {
	
	private Factura vistaGrafica;

	public VistaFactura(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new Factura(this);
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public void actualizar() {
		// TODO Auto-generated method stub		
	}

}
