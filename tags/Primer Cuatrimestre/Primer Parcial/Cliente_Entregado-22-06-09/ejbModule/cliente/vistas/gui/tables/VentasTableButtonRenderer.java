package cliente.vistas.gui.tables;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class VentasTableButtonRenderer extends JButton implements TableCellRenderer {

	private static final long serialVersionUID = 1L;

	public VentasTableButtonRenderer() {
		setOpaque(true);
	}

	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {		
		setText("X");
		return this;
	}
}
