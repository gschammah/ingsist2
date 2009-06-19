package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PALCVO;
import server.VO.articulos.ArticuloVO;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.ListadoPALC;
import cliente.vistas.gui.tables.TablaUtils;
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
		

	public void cargarDatos(PALCVO palc) {
		
		JTable tablaArt = vistaGrafica.getTablaArt();
		
		TablaUtils.borrarTabla(tablaArt);
		
		for (ItemPALCVO item : palc.getArticulos()) {
			
			ArticuloVO art = item.getArticulo();
			
			((DefaultTableModel) tablaArt.getModel()).addRow(new Object[] {
					art.getReferencia(), art.getDescripcion(),
					item.getCantidadSolicitada()});
		}
		
		
	}

	public void cerrar() {
		vistaGrafica.dispose();
	}
		
}
