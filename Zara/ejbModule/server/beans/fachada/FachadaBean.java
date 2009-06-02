package server.beans.fachada;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
import server.beans.articulos.AdministradorArticulos;
import server.beans.pedidos.AdministradorPedidos;
import server.beans.ventas.AdministradorVentas;
import server.entidades.articulos.Articulo;

@Stateful
public class FachadaBean implements Fachada {

	@EJB(name="ZaraEAR/AdministradorArticulosBean/local") 
    AdministradorArticulos admArticulos;
	
	@EJB(name="ZaraEAR/AdministradorPedidosBean/local") 
    AdministradorPedidos admPedidos;
	
	@EJB(name="ZaraEAR/AdministradorVentasBean/local") 
    AdministradorVentas admVentas;
	
	
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
	
	//Ventas

	public ArticuloVO buscarArticuloVO(long ref) {
		return admVentas.buscarArticuloVO(ref);
	}
	
}
