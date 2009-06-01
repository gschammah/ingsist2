/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */

package framework.vista;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import cliente.vistas.gui.MainMenu;
import framework.controlador.*;
import framework.modeloCliente.*;

public abstract class Vista {	
	ProxyModelo modelo;
	Controlador controlador;
	
	public Vista(ProxyModelo mod) {
		modelo = mod;
		mod.setVista(this);
	} 
	
	public void centrarVista(JFrame vistaGrafica){
		//Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize(); 
		
		//Calculate the frame location
		int x = (screenSize.width - vistaGrafica.getWidth()) / 2;
		int y = (screenSize.height - vistaGrafica.getHeight()) / 2;

		//Set the new frame location
		vistaGrafica.setLocation(x, y); 
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
