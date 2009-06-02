package cliente.vistas;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;

import cliente.controladores.OfADController;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.OfAD;
import framework.controlador.Controlador;
import framework.vista.Vista;

public class VistaOfAD extends Vista {
	private OfAD vistaGrafica;

	public VistaOfAD(ZaraModel modelo) {
		super(modelo);
		vistaGrafica = new OfAD(this);
		this.centrarVista(vistaGrafica);
	}

	@Override
	public void addControlador(Controlador cp) {
		super.addControlador(cp);
		((OfADController) this.getControlador()).cargarOfAD();
	}
	
	public void borrarTabla(JTable tabla){
		while (((DefaultTableModel) tabla.getModel()).getRowCount() > 0) {
			((DefaultTableModel) tabla.getModel()).removeRow(0);
		}
	}

	public void showOfAD() {
		vistaGrafica.pack();
		vistaGrafica.setVisible(true);
	}

	public void cargarDatos(OfADVO ofad) {
		
		Collection<ItemOfADVO> items = ofad.getArticulos();
		
		JTable artDisponibles = vistaGrafica.getTablaArtDisponibles();
		JTable artNuevos = vistaGrafica.getTablaArtNuevos();
		
		borrarTabla(artDisponibles);
		borrarTabla(artNuevos);

		for (ItemOfADVO item : items) {

			ArticuloVO art = item.getArticulo();

			if (art.isNuevo()) {
				((DefaultTableModel) artNuevos.getModel()).addRow(new Object[] {
						art.getReferencia(), art.getDescripcion(),
						art.getPrecioLista(), art.getPrecioOferta() });

			} else {
				((DefaultTableModel) artDisponibles.getModel()).addRow(new Object[] { 
						art.getReferencia(), art.getDescripcion(), 
						art.getPrecioLista(), art.getPrecioOferta() });
			}
		}
		vistaGrafica.setVisible(true);
	}

	public int showPopup(Date fecha) {
		return JOptionPane.showConfirmDialog(vistaGrafica,
				"Es posible que se haya cargado un OfAD el d�a "
						+ DateFormat.getDateInstance().format(fecha)
						+ " a las "
						+ DateFormat.getTimeInstance().format(fecha)
						+ ". Desea cargarlo de todos modos?", "Confirmaci�n",
				JOptionPane.YES_NO_OPTION);
	}


	public OfAD getVistaGrafica() {
		return vistaGrafica;
	}

}
