/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.vistas;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Collection;

import javax.swing.table.DefaultTableModel;

import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;
import cliente.modelo.ZaraModel;
import cliente.vistas.gui.VentaArticulos;
import cliente.vistas.gui.tables.VentasCantidadTableRenderer;
import framework.vista.Vista;

public class VistaVentaArticulos extends Vista {

	private static VistaVentaArticulos instance;
	private VentaArticulos vistaGrafica;

	public VistaVentaArticulos(ZaraModel modelo) {
		super(modelo);
		vistaGrafica = new VentaArticulos(this);

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

		((DefaultTableModel) vistaGrafica.getTablaArticulos().getModel()).addRow(datosArticulo);
	}
	

	public void toggleError(Collection<ItemVentaVO> articulos) {
		if (articulos == null) {
			((VentasCantidadTableRenderer) vistaGrafica.getTablaArticulos()
					.getDefaultRenderer(Integer.class)).getArticulos().clear();									
		} else {
			((VentasCantidadTableRenderer) vistaGrafica.getTablaArticulos()
					.getDefaultRenderer(Integer.class)).setArticulos(articulos);
		}
	}

	public void cerrar() {
		vistaGrafica.dispose();
	}

	public void togglePrecio(int fila, float precioLista) {
		vistaGrafica.getTablaArticulos().getModel().setValueAt(precioLista,
				fila, 3);
	}

	public void borrarArticulo(int row) {
		((DefaultTableModel) vistaGrafica.getTablaArticulos().getModel())
				.removeRow(row);

	}
	
	public char getTipoFactura(){
		
		return vistaGrafica.getTipoFactura().charAt(0);
	}

	public VentaArticulos getVistaGrafica() {
		return vistaGrafica;
	}

	public void setVistaGrafica(VentaArticulos vistaGrafica) {
		this.vistaGrafica = vistaGrafica;
	}
	
	

}