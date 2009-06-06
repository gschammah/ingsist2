package server.beans.fachada;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.VO.PALC.PALCVO;
import server.VO.articulos.ArticuloVO;
import server.VO.ventas.VentaVO;
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
	 
	
	public OfADVO nuevoOfad(OfADVO ofadVO, boolean save) {
		return admArticulos.nuevoOfad(ofadVO, save);
	}
	
	public Date checkExistingOfad(String hash){
		return admArticulos.checkExistingOfad(hash);
	}
	
	public Articulo buscarArticulo(long ref){
		return admArticulos.buscarArticulo(ref);
	}
	
	public ArticuloVO buscarArticuloVO(long ref) {
		return admArticulos.buscarArticuloVO(ref);
	}
	
	//Pedidos
	
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save) {
		return admPedidos.nuevoEnvT(envtVO, save);
	}

	public Date checkPedidoExistente(String hash) {
		return admPedidos.checkPedidoExistente(hash);
	}
	
	public PALCVO getPALC(){
		return admPedidos.getPALC();
	}
	
	public void registraPALC(PALCVO palc){
		admPedidos.registraPALC(palc);
	}
	
	//Ventas
	
	public Collection<ArticuloVO> nuevaVenta(VentaVO vo) {
		return admVentas.nuevaVenta(vo);
	}
	
}
