package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.Factura;
import framework.vista.Vista;

public class VistaFactura extends Vista {
	
	private Factura vistaGrafica;
	private static VistaFactura instance = null;

	public VistaFactura(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new Factura(this);
		
		vistaGrafica.addWindowListener(new WindowListener(){						
			public void windowClosed(WindowEvent e) { instance = null;}			
			public void windowActivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowOpened(WindowEvent e) {}										
		});
		
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
