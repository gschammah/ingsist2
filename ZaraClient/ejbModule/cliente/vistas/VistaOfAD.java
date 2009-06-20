package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.OfAD;
import cliente.vistas.gui.tables.TablaUtils;
import framework.vista.Vista;

public class VistaOfAD extends Vista {
	private static VistaOfAD instance;
	private OfAD vistaGrafica;	

	public VistaOfAD(ZaraModel modelo) {
		super(modelo);		
		vistaGrafica = new OfAD(this);		

		vistaGrafica.addWindowListener(new WindowListener() {
			public void windowClosed(WindowEvent e) {
				instance = null;
				
			}

			public void windowActivated(WindowEvent e) {
			}

			public void windowClosing(WindowEvent e) {
			}

			public void windowDeactivated(WindowEvent e) {
			}

			public void windowDeiconified(WindowEvent e) {
			}

			public void windowIconified(WindowEvent e) {
			}

			public void windowOpened(WindowEvent e) {
			}
		});

		this.centrarVista(vistaGrafica);
	}


	public void showOfAD() {
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}

	public void cargarDatos(OfADVO ofad) {

		Collection<ItemOfADVO> items = ofad.getArticulos();

		JTable artDisponibles = vistaGrafica.getTablaArtDisponibles();
		JTable artNuevos = vistaGrafica.getTablaArtNuevos();

		TablaUtils.borrarTabla(artDisponibles);
		TablaUtils.borrarTabla(artNuevos);

		for (ItemOfADVO item : items) {

			ArticuloVO art = item.getArticulo();

			if (art.isNuevo()) {
				((DefaultTableModel) artNuevos.getModel()).addRow(new Object[] {
						art.getReferencia(), art.getDescripcion(),
						art.getPrecioLista(), art.getPrecioOferta() });

			} else {
				((DefaultTableModel) artDisponibles.getModel())
						.addRow(new Object[] { art.getReferencia(),
								art.getDescripcion(), art.getPrecioLista(),
								art.getPrecioOferta() });
			}
		}

		Date fecha = ofad.getFecha();
		if (fecha != null) {
			vistaGrafica.getTxtActualizacion().setText(
					DateFormat.getDateInstance().format(fecha) + " "
							+ DateFormat.getTimeInstance().format(fecha));
		}
		vistaGrafica.setVisible(true);
	}

	public int showPopup(Date fecha) {
		return JOptionPane.showConfirmDialog(vistaGrafica,
				"Es posible que se haya cargado un OfAD el día "
						+ DateFormat.getDateInstance().format(fecha)
						+ " a las "
						+ DateFormat.getTimeInstance().format(fecha)
						+ ". Desea cargarlo de todos modos?", "Confirmación",
				JOptionPane.YES_NO_OPTION);
	}

	public static VistaOfAD getInstance(ZaraModel modelo) {

		if (instance == null) {
			instance = new VistaOfAD(modelo);
		}

		return instance;
	}

	public void cerrar() {
		vistaGrafica.dispose();
	}


	public OfAD getVistaGrafica() {
		return vistaGrafica;
	}


	public void disableButton() {	
		vistaGrafica.getBtn_registrarOfAD().setEnabled(false);
	}

}
