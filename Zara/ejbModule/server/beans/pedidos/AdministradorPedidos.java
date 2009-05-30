package server.beans.pedidos;

import javax.ejb.Remote;

import server.VO.EnvT.EnvTVO;

@Remote
public interface AdministradorPedidos {

	public void nuevoEnvT(EnvTVO envtVO);
	
}
