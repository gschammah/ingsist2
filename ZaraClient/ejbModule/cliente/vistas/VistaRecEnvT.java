package cliente.vistas;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.OfAD;
import cliente.vistas.gui.RecEnvT;
import framework.vista.Vista;

public class VistaRecEnvT extends Vista {
	
	private RecEnvT vistaGrafica;

	public VistaRecEnvT(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new RecEnvT(this);
		
		this.centrarVista(vistaGrafica);
		
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	public void actualizar() {
		// TODO Auto-generated method stub		
	}

}
