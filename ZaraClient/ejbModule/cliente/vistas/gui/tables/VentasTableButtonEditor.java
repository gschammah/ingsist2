package cliente.vistas.gui.tables;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class VentasTableButtonEditor extends DefaultCellEditor {	  
	
	private static final long serialVersionUID = 1L;
	protected JButton button;
	  
	  private boolean   isPushed;
	 
	  public VentasTableButtonEditor(JCheckBox checkBox) {
	    super(checkBox);
	    button = new JButton();
	    button.setOpaque(true);
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {	    	  
	        fireEditingStopped();
	      }
	    });
	  }
	 
	  @Override
	public Component getTableCellEditorComponent(JTable table, Object value,
	                   boolean isSelected, int row, int column) {
	    if (isSelected) {
	      button.setForeground(table.getSelectionForeground());
	      button.setBackground(table.getSelectionBackground());
	    } else{
	      button.setForeground(table.getForeground());
	      button.setBackground(table.getBackground());
	    }	    
	    button.setText( "X");
	    isPushed = true;
	    return button;
	  }
	 
	  @Override
	public Object getCellEditorValue() {
	    if (isPushed)  {
	    }
	    isPushed = false;
	    return "X" ;
	  }
	   
	  @Override
	public boolean stopCellEditing() {
	    isPushed = false;
	    return super.stopCellEditing();
	  }
	 
	  @Override
	protected void fireEditingStopped() {
	    super.fireEditingStopped();
	  }
	}