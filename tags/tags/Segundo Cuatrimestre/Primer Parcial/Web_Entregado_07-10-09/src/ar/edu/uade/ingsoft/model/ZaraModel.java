/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package ar.edu.uade.ingsoft.model;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import server.beans.fachada.Fachada;


public class ZaraModel {

	protected Hashtable<String, String> contextProperties;
	protected InitialContext initialContext;	
	private Fachada fachada; 
	
	public ZaraModel() throws NamingException{	
				
		contextProperties = new Hashtable<String, String>();
		contextProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		contextProperties.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
		String naming = "ZaraEAR/FachadaBean/remote";
		
			initialContext = new InitialContext(contextProperties);
			fachada = (Fachada) initialContext.lookup(naming);							
		
	}
	
	public Fachada getFachada() {
		return fachada;
	}
	
}
