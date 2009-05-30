package server.beans.pedidos;

import java.util.Collection;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.beans.pedidos.AdministradorPedidos;
import server.entidades.OfAD.ItemOfAD;
import server.entidades.OfAD.OfAD;
import server.entidades.articulos.Articulo;

@Stateful
public class AdministradorPedidosBean implements AdministradorPedidos {
	
	@PersistenceContext
	private EntityManager em;		
	
	public void nuevoEnvT(EnvTVO envtVO) {
		
	}
	
	
}
