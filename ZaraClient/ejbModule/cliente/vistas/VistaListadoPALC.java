package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.ListadoPALC;
import framework.vista.Vista;

public class VistaListadoPALC extends Vista {
	
	private static VistaListadoPALC instance;
	private ListadoPALC vistaGrafica;

	public VistaListadoPALC(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new ListadoPALC(this);
		
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
	
	public static VistaListadoPALC getInstance(ZaraModel modelo){
		
		if (instance == null)
		{
			instance = new VistaListadoPALC(modelo);
		}
		
		return instance;
	}
		
}
