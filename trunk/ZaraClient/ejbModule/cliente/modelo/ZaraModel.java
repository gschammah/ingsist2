package cliente.modelo;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cliente.XML.ParseXML;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.beans.articulos.AdministradorArticulos;

import framework.modeloCliente.ProxyModelo;

public class ZaraModel extends ProxyModelo{

	protected Hashtable<String, String> contextProperties;
	protected InitialContext initialContext;	
	private AdministradorArticulos admArt; 
	
	public ZaraModel(){	
				
		contextProperties = new Hashtable<String, String>();
		contextProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		contextProperties.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
		String naming = "ZaraEAR/AdministradorArticulosBean/remote";
		
		try {
			initialContext = new InitialContext(contextProperties);
			admArt = (AdministradorArticulos) initialContext.lookup(naming);
			//OfADVO ofadVO = ParseXML.parseOfAD("/UADE/workspace/ZaraClient/ejbModule/cliente/XML/xmls/OFAD.xml");					
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	public AdministradorArticulos getAdmArt() {
		return admArt;
	}

	public void setAdmArt(AdministradorArticulos admArt) {
		this.admArt = admArt;
	}
	
}
