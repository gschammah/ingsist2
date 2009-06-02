package server.beans.fachada;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.beans.articulos.AdministradorArticulos;
import server.beans.fachada.Fachada;
import server.beans.pedidos.AdministradorPedidos;
import server.entidades.articulos.Articulo;

@Stateful
public class FachadaBean implements Fachada {

	@EJB(name="ZaraEAR/AdministradorArticulosBean/local") 
    AdministradorArticulos admArticulos;
	
	@EJB(name="ZaraEAR/AdministradorPedidosBean/local") 
    AdministradorPedidos admPedidos;
	
	
	//Articulos
	 
	
	public OfADVO nuevoOfad(OfADVO ofadVO) {
		return admArticulos.nuevoOfad(ofadVO);
	}
	
	public Date checkExistingOfad(String hash){
		return admArticulos.checkExistingOfad(hash);
	}
	
	public Articulo buscarArticulo(long ref){
		return admArticulos.buscarArticulo(ref);
	}
	
	//Pedidos
	
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save) {
		return admPedidos.nuevoEnvT(envtVO, save);
	}

	public Date checkExistingEnvT(String hash) {
		return admPedidos.checkExistingEnvT(hash);
	}
	
}
