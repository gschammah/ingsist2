/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package framework.modeloCliente;

import framework.vista.*;
import java.util.Vector;


public abstract class ProxyModelo {
	protected Vista vista = null;
	
	public void setVista(Vista v) {
		vista = v;
	}
	
	
}
