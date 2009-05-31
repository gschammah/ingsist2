package server.beans.pedidos;

import javax.ejb.Remote;
import javax.persistence.NoResultException;

import server.VO.EnvT.EnvTVO;
import server.entidades.articulos.Articulo;

@Remote
public interface AdministradorPedidos {

	public void nuevoEnvT(EnvTVO envtVO);
			
}
