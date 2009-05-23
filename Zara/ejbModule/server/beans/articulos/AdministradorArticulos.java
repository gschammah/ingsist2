package server.beans.articulos;

import javax.ejb.Remote;

import server.VO.articulos.ArticuloVO;

@Remote
public interface AdministradorArticulos {

	public void test(ArticuloVO art);

}
