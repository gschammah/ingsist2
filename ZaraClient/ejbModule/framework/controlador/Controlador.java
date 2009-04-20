/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package framework.controlador;

import framework.vista.*;
import framework.modeloCliente.*;


public abstract class Controlador {
	Vista vista;
	ProxyModelo modelo;
	
	protected Controlador(ProxyModelo mod, Vista vis) {
		vista = vis;
		modelo = mod;
		vista.addControlador(this);
	}

	public ProxyModelo getModelo() {
		return modelo;
	}
	
	public Vista getVista() {
		return vista;
	}
	
}
