package cliente;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import cliente.vistas.MainMenu;

import com.thoughtworks.xstream.XStream;

import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArticuloVO;
import server.beans.articulos.*;



public class test {

	 private Hashtable<String, String> contextProperties;
     private InitialContext initialContext;

	public static void main(String[] args) {
				
		 new test();
	}
	
	public test(){
		/*AdministradorArticulos admArt;
		contextProperties = new Hashtable<String, String>();
        contextProperties.put(InitialContext.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        contextProperties.put(InitialContext.PROVIDER_URL, "jnp://127.0.0.1:1099");
        String naming = "ZaraEAR/AdministradorArticulosBean/remote";
        try {
                initialContext = new InitialContext(contextProperties);
                admArt = (AdministradorArticulos) initialContext.lookup(naming);
                
                
                XStream xstream = new XStream();
                xstream.alias("ArtHogarVO", ArticuloVO.class);
                
            	//ArtHogarVO saco = (ArtHogarVO)xstream.fromXML();
                                                
                //admArt.test(art);

        } catch (NamingException e) {
                e.printStackTrace();
        }*/
		
		MainMenu main = new MainMenu();
		main.setVisible(true);
	}

}
