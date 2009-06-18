package cliente.vistas.gui.tables;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;

public class VentasCantidadTableRenderer extends DefaultTableCellRenderer {
		
	private static final long serialVersionUID = 1L;
	private Collection<ItemVentaVO> articulos = new ArrayList<ItemVentaVO>();

	public Collection<ItemVentaVO> getArticulos() {
		return articulos;
	}

	public void setArticulos(Collection<ItemVentaVO> articulos) {
		this.articulos = articulos;
	}
	
	private boolean inArray(long ref){
		for (ItemVentaVO item : articulos) {
			if (item.getArticulo().getReferencia() == ref)
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
