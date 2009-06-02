package server.beans.ventas;

import javax.ejb.Remote;

import server.VO.articulos.ArticuloVO;

@Remote
public interface AdministradorVentas {

	public ArticuloVO buscarArticuloVO(long ref);
	
}
