package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.PALC;
import framework.vista.Vista;

public class VistaPALC extends Vista {
		
	private static VistaPALC instance;
	private PALC vistaGrafica;

	public VistaPALC(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new PALC(this);
		
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
