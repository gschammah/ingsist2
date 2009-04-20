/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (servidor)
 *  
 */

package ar.edu.uade.ingsoft.ejemploejb;

import java.util.Vector;
import ar.edu.uade.ingsoft.utils.ProductoVO;

import javax.ejb.Remote;

@Remote
public interface AdministradorProductos {

	public void setStock(ProductoVO p);
	public Vector getListaProductos();

}
