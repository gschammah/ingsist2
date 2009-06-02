package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.PALC;
import framework.vista.Vista;

public class VistaPALC extends Vista {
		
	private static VistaPALC instance;
	private PALC vistaGrafica;

	public VistaPALC(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new PALC(this);
		
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
	
	public static VistaPALC getInstance(ZaraModel modelo){
		
		if (instance == null)
		{
			instance = new VistaPALC(modelo);
		}
		
		return instance;
	}
	
}
