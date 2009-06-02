package server.beans.pedidos;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.beans.articulos.AdministradorArticulos;
import server.beans.articulos.AdministradorArticulosBean;
import server.beans.pedidos.AdministradorPedidos;
import server.entidades.EnvT.EnvT;
import server.entidades.EnvT.ItemEnvT;
import server.entidades.OfAD.ItemOfAD;
import server.entidades.OfAD.OfAD;
import server.entidades.articulos.Articulo;

@Stateful
public class AdministradorPedidosBean implements AdministradorPedidos {

	@PersistenceContext
	private EntityManager em;

	@EJB(name = "ZaraEAR/AdministradorArticulosBean/local")
	AdministradorArticulos admArt;

	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save) {

		EnvT envt = new EnvT();
		envt.setVO(envtVO);

		Collection<ItemEnvT> articulos = envt.getArticulos();
		
		/*
		 * Si save es false, solo quiero que me devuelva un EnvTVO con la
		 * lista de articulos completa
		 */ 
				
			for (ItemEnvT item : articulos) {

				Articulo art = admArt.buscarArticulo(item.getArticulo().getReferencia());

				if (art == null) {
					// TODO Articulo no existe
				} else {
					
					item.setArticulo(art);
					
					if (save)
					{
						item.getArticulo().setStock(item.getArticulo().getStock() + item.getCantidadRecibida());
						em.merge(item.getArticulo());
					}					
				}
			}
			envt.setArticulos(articulos);
		 
		// Si save es true, persisto
			
		if (save) {			
			em.persist(envt);
		}

		
		return envt.getVO();

	}

	public Date checkExistingEnvT(String hash) {
		Query q = em
				.createQuery("SELECT e FROM EnvT e where e.xmlHash = ? ORDER BY e.fecha DESC");
		q.setParameter(1, hash);

		List envt = q.getResultList();

		if (envt.size() > 0) {
			return ((EnvT) envt.get(0)).getFecha();
		} else {
			return null;
		}
	}

}
