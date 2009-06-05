package cliente.vistas.gui.tables;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import server.VO.articulos.ArticuloVO;

public class VentasCantidadTableRenderer extends DefaultTableCellRenderer {
		
	private static final long serialVersionUID = 1L;
	private Collection<ArticuloVO> articulos = new ArrayList<ArticuloVO>();

	public Collection<ArticuloVO> getArticulos() {
		return articulos;
	}

	public void setArticulos(Collection<ArticuloVO> articulos) {
		this.articulos = articulos;
	}
	
	private boolean inArray(long ref){
		for (ArticuloVO art : articulos) {
			if (art.getReferencia() == ref)
			{
				return true;
			}
		}
		return false;
	}

	public Component getTableCellRendererComponent(JTable table,
	      Object value,
	      boolean isSelected,
	      boolean hasFocus,
	      int row,
	      int column)
	   {
	      Component comp = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
	      
	      Long ref = Long.parseLong(table.getValueAt(row, 0).toString());	      	    
	      	    	      	     
	      if (inArray(ref))
	      {  	         
	         comp.setBackground(Color.RED);	         	         
	      }
	      else
	      {	    	 
	    	 comp.setBackground(Color.WHITE);	    	 
	      }	      
	      
	      table.repaint();      
	            
	      return this;
	   }

}	
