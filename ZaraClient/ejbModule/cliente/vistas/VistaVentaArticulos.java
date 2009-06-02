package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.VentaArticulos;
import framework.vista.Vista;

public class VistaVentaArticulos extends Vista {
	
	private static VistaVentaArticulos instance;
	private VentaArticulos vistaGrafica;

	public VistaVentaArticulos(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new VentaArticulos(this);
		
		this.centrarVista(vistaGrafica);
		
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public static VistaVentaArticulos getInstance(ZaraModel modelo){
		
		if (instance == null)
		{
			instance = new VistaVentaArticulos(modelo);
		}
		
		return instance;
	}

}
