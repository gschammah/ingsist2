package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.articulos.ArticuloVO;
import cliente.controladores.EnvTController;
import cliente.controladores.OfADController;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.RecEnvT;
import framework.controlador.Controlador;
import framework.vista.Vista;

public class VistaRecEnvT extends Vista {
	
	private static VistaRecEnvT instance;
	private RecEnvT vistaGrafica;

	public VistaRecEnvT(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new RecEnvT(this);
		
		this.centrarVista(vistaGrafica);
		
		vistaGrafica.addWindowListener(new WindowListener(){						
			public void windowClosed(WindowEvent e) { instance = null;}			
			public void windowActivated(WindowEvent e) {}
			public void windowClosing(WindowEvent e) {}
			public void windowDeactivated(WindowEvent e) {}
			public void windowDeiconified(WindowEvent e) {}
			public void windowIconified(WindowEvent e) {}
			public void windowOpened(WindowEvent e) {}										
		});
		
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}
	
	@Override
	public void addControlador(Controlador cp) {
		super.addControlador(cp);
		((EnvTController) this.getControlador()).cargarEnvT(false);
	}
	
	public void borrarTabla(JTable tabla){
		while (((DefaultTableModel) tabla.getModel()).getRowCount() > 0) {
			((DefaultTableModel) tabla.getModel()).removeRow(0);
		}
	}

	public void cargarDatos(EnvTVO envt) {
		
		Collection<ItemEnvTVO> items = envt.getArticulos();
		
		JTable artRecibidos = vistaGrafica.getTablaArtRecibidos();
		JTable artPendientes = vistaGrafica.getTablaArtPendientes();
		
		borrarTabla(artRecibidos);
		borrarTabla(artPendientes);
		
		Date fecha = envt.getFecha();
		
		vistaGrafica.getTxt_hora().setText(
				DateFormat.getDateInstance().format(fecha) + " " + DateFormat.getTimeInstance().format(fecha) 
		);

		for (ItemEnvTVO item : items) {

			ArticuloVO art = item.getArticulo();
			
			if (item.getCantidadPendiente() == 0 ) {
				((DefaultTableModel) artRecibidos.getModel()).addRow(new Object[] {
						art.getReferencia(), art.getDescripcion(),
						item.getCantidadRecibida(), art.getStock() });

			} else {
				((DefaultTableModel) artPendientes.getModel()).addRow(new Object[] { 
						art.getReferencia(), art.getDescripcion(), 
						item.getCantidadRecibida(), item.getCantidadPendiente(), art.getStock() });
			}
		}		
	
	}
	
	public int showPopup(Date fecha) {
		return JOptionPane.showConfirmDialog(vistaGrafica,
				"Es posible que se haya cargado un EnvT el día "
						+ DateFormat.getDateInstance().format(fecha)
						+ " a las "
						+ DateFormat.getTimeInstance().format(fecha)
						+ ". Desea cargarlo de todos modos?", "Confirmación",
				JOptionPane.YES_NO_OPTION);
	}
	
	public static VistaRecEnvT getInstance(ZaraModel modelo){
		
		if (instance == null)
		{
			instance = new VistaRecEnvT(modelo);
		}
		
		return instance;
	}

	public void cerrar() {
		vistaGrafica.dispose();
	}


}
