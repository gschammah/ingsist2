package server.beans.articulos;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;

import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.OfAD.ItemOfAD;
import server.entidades.OfAD.OfAD;
import server.entidades.articulos.*;


/**
 * Bean Stateful que administra articulos
 *
 */
@Stateful
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	@PersistenceContext
	private EntityManager em;		
	
	public OfADVO nuevoOfad(OfADVO ofadVO) {
		OfAD ofad = new OfAD();
		ofad.setVO(ofadVO);
		
		Collection<ItemOfAD> items = ofad.getArticulos();
		
		for (ItemOfAD itemOfAD : items) {
			//me fijo si existe
			Articulo art = buscarArticulo(itemOfAD.getArticulo());
			//si existe actualizo los precios 
			if (art != null)
			{
				art.setVO(itemOfAD.getArticulo().getVO());
				itemOfAD.setArticulo(art);			
			}
			else
			{
				itemOfAD.getArticulo().setNuevo(true);
			}
		}
		//actualizo la lista de articulos con los precios cambiados
		ofad.setArticulos(items);
		
		em.persist(ofad);
		return ofad.getVO();
	}
	
	public Date checkExistingOfad(String hash){
		Query q = em.createQuery("SELECT o FROM OfAD o where o.xmlHash = ? ORDER BY o.fecha DESC");
		q.setParameter(1, hash);
				
		List ofad = q.getResultList();
		
		if (ofad.size() > 0)
		{
			return ((OfAD) ofad.get(0)).getFecha();
		}
		else
		{
			return null;
		}										
	}
	
	public Articulo buscarArticulo(Articulo art){		
		Articulo result = em.find(Articulo.class, art.getReferencia());
		return result;
	}


}	
	
