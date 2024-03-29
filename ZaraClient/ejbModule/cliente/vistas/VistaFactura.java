/*
 * Ingenierķa en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import server.VO.ventas.ItemVentaVO;
import server.VO.ventas.VentaVO;
import cliente.modelo.DatosF;
import cliente.modelo.DatosT;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.Factura;
import framework.vista.Vista;

public class VistaFactura extends Vista {
	
	private Factura vistaGrafica;
	private static VistaFactura instance = null;

	public VistaFactura(ZaraModel modelo){
		super(modelo);
		vistaGrafica = new Factura(this);
		
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
	
	public static VistaFactura getInstance(ZaraModel modelo){
		
		if (instance == null)
		{
			instance = new VistaFactura(modelo);
		}
		
		return instance;
	}
	
	public void agregarInfo(VentaVO venta) {
		
	    Collection<ItemVentaVO> rows = venta.getItems();
	    
	    
		Iterator<ItemVentaVO> i = rows.iterator();
		
		while (i.hasNext()){
			
			ItemVentaVO aux = i.next();
         
			float f = aux.getCantidad()*aux.getPrecio();
			Object[] dat = {
					aux.getArticulo().getReferencia(),
					aux.getCantidad(),
					aux.getArticulo().getDescripcion(),
					aux.getPrecio(),
					f
					};
            
            ((DefaultTableModel) vistaGrafica.getTabla().getModel())
			.addRow(dat);
	
            
		}
		
		DatosT datosT = new DatosT(venta.getSubTotal(), venta.getIva(), venta.getTotal());				
		
		DatosF datosF = new DatosF(
				venta.getCliente().getNombre(), 
				DateFormat.getInstance().format(venta.getFecha()), 
				venta.getTipoFactura(), 
				venta.getId(), 
				venta.getCliente().getCuit(), 
				venta.getCliente().getRazonSocial(),
				venta.getCliente().getDireccion());
		
		vistaGrafica.setDatosT(datosT);
		vistaGrafica.setDatosF(datosF);
		
	}
		
	public void cerrar() {
		vistaGrafica.dispose();
	}
}
