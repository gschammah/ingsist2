package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.Factura;
import framework.vista.Vista;

public class VistaFactura extends Vista {
	
	private Factura vistaGrafica;
	private static VistaFactura instance = null;

	public VistaFactura(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new Factura(this);
		
		this.centrarVista(vistaGrafica);
		
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public static VistaFactura getInstance(ZaraModel modelo){
		
		if (instance == null)
		{
			instance = new VistaFactura(modelo);
		}
		
		return instance;
	}
		
}
