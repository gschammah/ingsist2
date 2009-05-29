package cliente;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cliente.XML.ParseXML;
import server.VO.OfAD.OfADVO;
import server.beans.articulos.AdministradorArticulos;

public class test {

	private Hashtable<String, String> contextProperties;
	private InitialContext initialContext;

	public static void main(String[] args) {

		new test();
	}

	public test() {

		AdministradorArticulos admArt;
		contextProperties = new Hashtable<String, String>();
		contextProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		contextProperties.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
		String naming = "ZaraEAR/AdministradorArticulosBean/remote";
		
		try {
			initialContext = new InitialContext(contextProperties);
			admArt = (AdministradorArticulos) initialContext.lookup(naming);
			OfADVO ofadVO = ParseXML.parseOfAD("/UADE/workspace/ZaraClient/ejbModule/cliente/XML/OFAD.xml");
			admArt.test(ofadVO);

		} catch (NamingException e) {
			e.printStackTrace();
		}

		// MainMenu main = new MainMenu();
		// main.setVisible(true);

	}

}
