package cliente.modelo;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import server.beans.articulos.AdministradorArticulos;
import server.beans.fachada.Fachada;

import framework.modeloCliente.ProxyModelo;

public class ZaraModel extends ProxyModelo{

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
