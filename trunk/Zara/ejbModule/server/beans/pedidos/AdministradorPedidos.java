package server.beans.pedidos;

import java.util.Date;

import javax.ejb.Remote;
import javax.persistence.NoResultException;

import server.VO.EnvT.EnvTVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.Articulo;

@Remote
public interface AdministradorPedidos {

	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save);
	
	public Date checkExistingEnvT(String hash);
				
}
