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
import server.entidades.articulos.Articulo;

@Remote
public interface Fachada {

	public OfADVO nuevoOfad(OfADVO ofadVO, boolean save);
	
	public Date checkExistingOfad(String hash);
	
	public Articulo buscarArticulo(long ref);
		
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save);
	
	public Date checkPedidoExistente(String hash);
	
	public ArticuloVO buscarArticuloVO(long ref);
	
	public VentaVO nuevaVenta(VentaVO vo);
	
	public Collection<PalcPropuestoVO> getPALC();
	
	public PalcPropuestoVO getPALC(long ref);
	
	public int registraPALC(PALCVO palc);
}
