package cliente.vistas.gui.renderers;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableCellRenderer;

import server.VO.articulos.ArticuloVO;

public class VentasTableRenderer extends DefaultTableCellRenderer {
		
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
	      JCheckBox checkbox = new JCheckBox();
	      	    	      	     
	      if (inArray(ref))
	      {  	         
	         comp.setBackground(Color.RED);
	         checkbox.setBackground(Color.RED);
	      }
	      else
	      {	    	 
	    	  comp.setBackground(Color.WHITE);
	    	  checkbox.setBackground(Color.WHITE);
	      }	      
	      table.repaint();
	      if (column == 4)
	      {
	    	  checkbox.setHorizontalAlignment(SwingConstants.CENTER);
	    	  return checkbox; 
	      }	      
	      else if (column == 6)
	      {
	    	  JButton boton = new JButton();
	    	  boton.setText("X");
	    	  boton.setHorizontalAlignment(SwingConstants.CENTER);
	    	  boton.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent e) {
					System.out.println("asas");					
				}});
	    	  return boton;
	      }
	      return this;
	   }

}	
