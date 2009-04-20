/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package aplicProductos.vistas;

import framework.vista.*;
import aplicProductos.vistas.guis.*;
import aplicProductos.modelos.*;

public class VistaAdmProductos extends Vista {
		DetalleProductos vistaGrafica;
		 
		public VistaAdmProductos(ProxyModeloAdmProductos map) {
			super(map);
			vistaGrafica = new DetalleProductos(this);
	 		vistaGrafica.pack();
			vistaGrafica.setVisible(true);
		}
		
		public void actualizar() {
			vistaGrafica.actualizar();
		}

		public void setDetalles(boolean flag) {
			vistaGrafica.setDetalles(flag);
		}
}
