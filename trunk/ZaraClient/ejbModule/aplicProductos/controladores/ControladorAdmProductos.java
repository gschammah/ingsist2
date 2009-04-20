/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */

package aplicProductos.controladores;

import framework.controlador.*;
import aplicProductos.modelos.*;
import aplicProductos.vistas.*;
 
public class ControladorAdmProductos extends Controlador {
	
	public ControladorAdmProductos  (ProxyModeloAdmProductos map, VistaAdmProductos vp) {
		super(map, vp);
	}

	public void doActualizarStock(String it, int st) {
		((ProxyModeloAdmProductos)(this.getModelo())).setStock(it, st);
	}

	public void doNuevoProductoSeleccionado(String prod) {
		((ProxyModeloAdmProductos)(this.getModelo())).setProductoVisible(prod);
		((VistaAdmProductos)(this.getVista())).setDetalles(false);
		((VistaAdmProductos)(this.getVista())).actualizar();
	}

	public void doMostrarDetallesProducto(String prod) {
		((VistaAdmProductos)(this.getVista())).setDetalles(true);
		((VistaAdmProductos)(this.getVista())).actualizar();
	}
	

}
