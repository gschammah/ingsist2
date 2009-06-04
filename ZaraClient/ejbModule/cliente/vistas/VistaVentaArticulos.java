package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.util.Collection;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import server.VO.articulos.ArticuloVO;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.VentaArticulos;
import cliente.vistas.gui.renderers.VentasTableRenderer;
import framework.vista.Vista;

public class VistaVentaArticulos extends Vista {

	private static VistaVentaArticulos instance;
	private VentaArticulos vistaGrafica;

	public VistaVentaArticulos(ZaraModel modelo) {
		super(modelo);
		vistaGrafica = new VentaArticulos(this);
		
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

	public static VistaVentaArticulos getInstance(ZaraModel modelo) {

		if (instance == null) {
			instance = new VistaVentaArticulos(modelo);
		}

		return instance;
	}

	public void agregarArticulo(ArticuloVO articulo) {

		vistaGrafica.getTxtDetalles().setText(articulo.toString());
		
		Object[] datosArticulo = new Object[] { articulo.getReferencia(),
				articulo.getLinea(), articulo.getDescripcion(),
				articulo.getPrecioLista(), null, 1 };

		((DefaultTableModel) vistaGrafica.getTablaArticulos().getModel())
				.addRow(datosArticulo);
	}
	
	public void showErrorPopup(String mensaje) {
		JOptionPane.showMessageDialog(vistaGrafica, mensaje, "Error de conexión",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void toggleError(Collection<ArticuloVO> articulos){
		((VentasTableRenderer)vistaGrafica.getTablaArticulos().getDefaultRenderer(Object.class)).setArticulos(articulos);
	}

	public void cerrar() {
		vistaGrafica.dispose();		
	}
}