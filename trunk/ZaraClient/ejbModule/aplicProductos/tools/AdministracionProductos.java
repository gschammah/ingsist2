/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */

package aplicProductos.tools;

import aplicProductos.controladores.*;
import aplicProductos.modelos.*;
import aplicProductos.vistas.*;
 
public class AdministracionProductos {
 
	ProxyModeloAdmProductos map = new ProxyModeloAdmProductos();
	VistaAdmProductos vp1 = new VistaAdmProductos(map);
	ControladorAdmProductos cp1 = new ControladorAdmProductos(map, vp1);
	
	public static void main (String args[]) {
		AdministracionProductos ap = new AdministracionProductos();
	} 
	 
}
