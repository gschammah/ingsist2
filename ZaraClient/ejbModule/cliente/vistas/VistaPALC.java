package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.VO.PALC.ItemPALCVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.PALC.PalcPropuestoVO;
import cliente.controladores.PalcController;
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

	public void cerrar() {		
		vistaGrafica.dispose();
	}
	
	public void borrarTabla(JTable tabla) {
		while (((DefaultTableModel) tabla.getModel()).getRowCount() > 0) {
			((DefaultTableModel) tabla.getModel()).removeRow(0);
		}
	}

	public void cargarDatos(Collection<PalcPropuestoVO> palc) {
		JTable tablaArt = vistaGrafica.getArticulos();
		borrarTabla(tablaArt);
		
		for (PalcPropuestoVO item: palc) {
			
			ArticuloVO art = item.getArticulo();
			
			((DefaultTableModel) tablaArt.getModel()).addRow(new Object[] {
					art.getReferencia(), art.getDescripcion(),
					item.getVentas(), item.getPendientes(), art.getStock(), art.getPuntoReposicion(), true, 0 });
		}
		
	}
	
	public void cargarDatos(PalcPropuestoVO palc) {
		JTable tablaArt = vistaGrafica.getArticulos();
		boolean flag = true;
		
			ArticuloVO art = palc.getArticulo();
			
			for (int i = 0; i < ((DefaultTableModel) tablaArt.getModel()).getRowCount(); i++) {
				if ( new Long (((DefaultTableModel) tablaArt.getModel()).getValueAt(i, 0).toString()) == art.getReferencia()){
					flag = false;
				}
			}
			
			if (flag)
			{
				((DefaultTableModel) tablaArt.getModel()).addRow(new Object[] {
						art.getReferencia(), art.getDescripcion(),
						palc.getVentas(), palc.getPendientes(), art.getStock(), art.getPuntoReposicion(), true, 0 });
			} else {
				((PalcController)this.getControlador()).showExistentePopup();
			}
	}

	public PALC getVistaGrafica() {
		return vistaGrafica;
	}

	public void setVistaGrafica(PALC vistaGrafica) {
		this.vistaGrafica = vistaGrafica;
	}
				
	
}
