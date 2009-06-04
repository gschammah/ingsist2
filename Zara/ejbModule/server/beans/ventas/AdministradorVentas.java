package server.beans.ventas;

import java.util.Collection;

import javax.ejb.Remote;

import server.VO.articulos.ArticuloVO;
import server.VO.ventas.VentaVO;

@Remote
public interface AdministradorVentas {
	
	public Collection<ArticuloVO> nuevaVenta(VentaVO vo);
	
}
