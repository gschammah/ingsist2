/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */

package framework.vista;

import framework.controlador.*;
import framework.modeloCliente.*;

public abstract class Vista {
	ProxyModelo modelo;
	Controlador controlador;
	
	public Vista(ProxyModelo mod) {
		modelo = mod;
		mod.setVista(this);
	} 
	
	public void addControlador(Controlador cp){
		controlador = cp;
	}
	
	public ProxyModelo getModelo() {
		return modelo;
	}
	
	public Controlador getControlador() {
		return controlador;
	}

	public abstract void actualizar(); 
	
}
