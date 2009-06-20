package server.beans.fachada;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
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
	
	public Collection<PalcPropuestoVO> getPALC() {
		return admPedidos.getPALC();
	}
	
	public PalcPropuestoVO getPALC(long ref) {
		return admPedidos.getPALC(ref);
	}
	
	public int registraPALC(PALCVO palc){
		return admPedidos.registraPALC(palc);
	}
	
	//Ventas
	
	public VentaVO nuevaVenta(VentaVO vo) {
		return admVentas.nuevaVenta(vo);
	}
	
}
