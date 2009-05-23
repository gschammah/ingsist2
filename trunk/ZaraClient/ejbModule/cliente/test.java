package cliente;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import server.beans.AdministradorArticulos;


public class test {

	 private Hashtable<String, String> contextProperties;
     private InitialContext initialContext;

	public static void main(String[] args) {
				
		 new test();
	}
	
	public test(){
		AdministradorArticulos admArt;
		contextProperties = new Hashtable<String, String>();
        contextProperties.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        contextProperties.put(InitialContext.PROVIDER_URL, "jnp://127.0.0.1:1099");
        String naming = "ZaraEAR/AdministradorArticulosBean/remote";
        try {
                initialContext = new InitialContext(contextProperties);
                admArt = (AdministradorArticulos) initialContext.lookup(naming);
                admArt.test();

        } catch (NamingException e) {
                e.printStackTrace();
        }

	}

}
