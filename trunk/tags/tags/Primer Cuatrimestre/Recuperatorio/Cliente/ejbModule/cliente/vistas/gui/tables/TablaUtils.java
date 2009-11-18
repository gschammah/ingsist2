package cliente.vistas.gui.tables;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaUtils {

	public static void borrarTabla(JTable tabla) {
		while (((DefaultTableModel) tabla.getModel()).getRowCount() > 0) {
			((DefaultTableModel) tabla.getModel()).removeRow(0);
		}
	}
}
