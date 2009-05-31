package server.beans.pedidos;

import java.util.Collection;

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
	
	  
    @EJB(name="ZaraEAR/AdministradorArticulosBean/local") 
    AdministradorArticulos admArt;

	
	public void nuevoEnvT(EnvTVO envtVO) {
		
		EnvT envt = new EnvT();
		envt.setVO(envtVO);
		
		Collection<ItemEnvT> articulos = envt.getArticulos();
				
		
		for (ItemEnvT item : articulos) {
						
			//Articulo art = this.findByRef(item.getArticulo().getReferencia());		
			Articulo art = admArt.buscarArticulo(item.getArticulo().getReferencia());			
			
			if (art == null)
			{
				//TODO Articulo no existe
			}
			else
			{				
				item.setArticulo(art);
			}			
		}
		envt.setArticulos(articulos);
		em.persist(envt);
		
	}
			
}
