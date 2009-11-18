/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PalcPropuestoVO;
import server.VO.articulos.ArticuloVO;
import cliente.controladores.PalcController;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.PALC;
import cliente.vistas.gui.tables.TablaUtils;
import framework.vista.Vista;

public class VistaPALC extends Vista {
		
	private static VistaPALC instance;
	private PALC vistaGrafica;
	private HashMap<Long, ArticuloVO> articulosDisponibles = new HashMap<Long, ArticuloVO>();

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
	

	public void cargarDatos(Collection<PalcPropuestoVO> palc) {
		JTable tablaArt = vistaGrafica.getArticulos();
		
		TablaUtils.borrarTabla(tablaArt);
		
		articulosDisponibles.clear();		
		
		for (PalcPropuestoVO item: palc) {
			
			ArticuloVO art = item.getArticulo();
			
			articulosDisponibles.put(art.getReferencia(), art);
			
			((DefaultTableModel) tablaArt.getModel()).addRow(new Object[] {
					art.getReferencia(), art.getDescripcion(),
					item.getVentas(), item.getPendientes(), art.getStock(), art.getPuntoReposicion(), true, 100 });
		}
		
	}
	
	public void cargarDatos(PalcPropuestoVO palc) {
		
		JTable tablaArt = vistaGrafica.getArticulos();
		boolean flag = true;
							
			ArticuloVO art = palc.getArticulo();
			
			articulosDisponibles.put(art.getReferencia(), art);
			
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

	public Collection<ItemPALCVO> getArticulosElegidos() {
		
		JTable tablaArt = vistaGrafica.getArticulos();
		ArrayList<ItemPALCVO> result = new ArrayList<ItemPALCVO>();
		
		for (int i = 0; i < ((DefaultTableModel) tablaArt.getModel()).getRowCount(); i++) {
			if ((Boolean) ((DefaultTableModel) tablaArt.getModel()).getValueAt(i, 6)){
				
				ItemPALCVO item = new ItemPALCVO();
				
				long ref = (Long) ((DefaultTableModel) tablaArt.getModel()).getValueAt(i, 0);
				int cant = (Integer) ((DefaultTableModel) tablaArt.getModel()).getValueAt(i, 7);
				
				item.setArticulo(articulosDisponibles.get(ref));
				item.setCantidadSolicitada(cant);
												
				result.add(item);
			}
		}		
		return result;
	}
			
	
}
