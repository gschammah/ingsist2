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

import javax.ejb.Remote;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
import server.VO.articulos.ArticuloVO;
import server.VO.ventas.VentaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface Fachada.
 */
@Remote
public interface Fachada {

	/* (non-Javadoc)
	 * @see server.beans.articulos.AdministradorArticulos#nuevoOfad(server.VO.OfAD.OfADVO, boolean)
	 */
	public OfADVO nuevoOfad(OfADVO ofadVO, boolean save);
	
	/* (non-Javadoc)
	 * @see server.beans.articulos.AdministradorArticulos#checkExistingOfad(java.lang.String)
	 */
	public Date checkExistingOfad(String hash);
				
	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#nuevoEnvT(server.VO.EnvT.EnvTVO, boolean)
	 */
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save);
	
	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#checkPedidoExistente(java.lang.String)
	 */
	public Date checkPedidoExistente(String hash);
	
	/* (non-Javadoc)
	 * @see server.beans.articulos.AdministradorArticulos#buscarArticuloVO(long)
	 */
	public ArticuloVO buscarArticuloVO(long ref);
	
	/* (non-Javadoc)
	 * @see server.beans.ventas.AdministradorVentas#nuevaVenta(server.VO.ventas.VentaVO)
	 */
	public VentaVO nuevaVenta(VentaVO vo);
	
	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#getPALC()
	 */
	public Collection<PalcPropuestoVO> getPALC();
	
	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#getPALC(long)
	 */
	public PalcPropuestoVO getPALC(long ref);
	
	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#registraPALC(server.VO.PALC.PALCVO)
	 */
	public int registraPALC(PALCVO palc);
}
