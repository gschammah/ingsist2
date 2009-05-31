package cliente;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cliente.XML.ParseXML;
import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.beans.articulos.AdministradorArticulos;
import server.beans.pedidos.AdministradorPedidos;

public class testEnvT {

	private Hashtable<String, String> contextProperties;
	private InitialContext initialContext;

	public static void main(String[] args) {

		new testEnvT();
	}

	public testEnvT() {

		AdministradorPedidos admPedidos;
		contextProperties = new Hashtable<String, String>();
		contextProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		contextProperties.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
		String naming = "ZaraEAR/AdministradorPedidosBean/remote";
		
		try {
			initialContext = new InitialContext(contextProperties);
			admPedidos = (AdministradorPedidos) initialContext.lookup(naming);
			EnvTVO envtVO = ParseXML.parseEnvT("/UADE/workspace/ZaraClient/ejbModule/cliente/XML/xmls/EnvT.xml");
			admPedidos.nuevoEnvT(envtVO);

		} catch (NamingException e) {
			e.printStackTrace();
		}

		// MainMenu main = new MainMenu();
		// main.setVisible(true);

	}

}
