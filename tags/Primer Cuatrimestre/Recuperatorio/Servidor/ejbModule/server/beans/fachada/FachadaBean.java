/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.beans.fachada;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Init;
import javax.ejb.Stateful;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
import server.VO.articulos.ArticuloVO;
import server.VO.clientes.ClienteVO;
import server.VO.ventas.VentaVO;
import server.beans.articulos.AdministradorArticulos;
import server.beans.pedidos.AdministradorPedidos;
import server.beans.ventas.AdministradorVentas;
import server.entidades.articulos.Articulo;
import server.entidades.clientes.Cliente;

// TODO: Auto-generated Javadoc
/**
 * The Class FachadaBean.
 */
@Stateful
public class FachadaBean implements Fachada {

	/** Administrador Articulos Bean. */
	@EJB(name="ZaraEAR/AdministradorArticulosBean/local") 
    AdministradorArticulos admArticulos;
	
	/** Administrador Pedidos Bean. */
	@EJB(name="ZaraEAR/AdministradorPedidosBean/local") 
    AdministradorPedidos admPedidos;
	
	/** Administrador Ventas Bean. */
	@EJB(name="ZaraEAR/AdministradorVentasBean/local") 
    AdministradorVentas admVentas;
	
	
	//Articulos
	 
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#nuevoOfad(server.VO.OfAD.OfADVO, boolean)
	 */
	public OfADVO nuevoOfad(OfADVO ofadVO, boolean save) {
		return admArticulos.nuevoOfad(ofadVO, save);
	}
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#checkExistingOfad(java.lang.String)
	 */
	public Date checkExistingOfad(String hash){
		return admArticulos.checkExistingOfad(hash);
	}
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#buscarArticulo(long)
	 */
	public Articulo buscarArticulo(long ref){
		return admArticulos.buscarArticulo(ref);
	}
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#buscarArticuloVO(long)
	 */
	public ArticuloVO buscarArticuloVO(long ref) {
		return admArticulos.buscarArticuloVO(ref);
	}
	
	//Pedidos
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#nuevoEnvT(server.VO.EnvT.EnvTVO, boolean)
	 */
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save) {
		return admPedidos.nuevoEnvT(envtVO, save);
	}

	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#checkPedidoExistente(java.lang.String)
	 */
	public Date checkPedidoExistente(String hash) {
		return admPedidos.checkPedidoExistente(hash);
	}
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#getPALC()
	 */
	public Collection<PalcPropuestoVO> getPALC() {
		return admPedidos.getPALC();
	}
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#getPALC(long)
	 */
	public PalcPropuestoVO getPALC(long ref) {
		return admPedidos.getPALC(ref);
	}
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#registraPALC(server.VO.PALC.PALCVO)
	 */
	public int registraPALC(PALCVO palc){
		return admPedidos.registraPALC(palc);
	}
	
	//Ventas
	
	/* (non-Javadoc)
	 * @see server.beans.fachada.Fachada#nuevaVenta(server.VO.ventas.VentaVO)
	 */
	public VentaVO nuevaVenta(VentaVO vo) {
		return admVentas.nuevaVenta(vo);
	}
	
	public ClienteVO buscarCliente(String cuit){
		return admVentas.buscarCliente(cuit);
	}
		

}
