/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */

package ar.edu.uade.ingsoft.ejemploejb;

import java.util.Vector;

import javax.ejb.Remote;

import ar.edu.uade.ingsoft.utils.ProductoVO;

@Remote
public interface AdministradorProductos {

	public void setStock(ProductoVO p);
	public Vector getListaProductos();

}
