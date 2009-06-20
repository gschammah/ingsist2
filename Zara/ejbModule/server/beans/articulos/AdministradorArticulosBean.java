package server.beans.articulos;


import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.OfAD.ItemOfAD;
import server.entidades.OfAD.OfAD;
import server.entidades.articulos.Articulo;


/**
 * Bean Stateful que administra articulos
 *
 */
@Stateful
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	@PersistenceContext
	private EntityManager em;
		
	
	public OfADVO nuevoOfad(OfADVO ofadVO, boolean save) {
		OfAD ofad = new OfAD();
		ofad.setVO(ofadVO);
		
		Collection<ItemOfAD> items = ofad.getArticulos();
		
		for (ItemOfAD itemOfAD : items) {
			//me fijo si existe
			Articulo art = buscarArticulo(itemOfAD.getArticulo().getReferencia());
			//si existe actualizo los precios 
			if (art != null)
			{
				art.setVO(itemOfAD.getArticulo().getVO());
				art.setNuevo(false);				
				itemOfAD.setArticulo(art);			
			}
			else
			{
				if (!save)
				{
					itemOfAD.getArticulo().setNuevo(true);
				}
				else
				{
					itemOfAD.getArticulo().setNuevo(false);
				}
			}
		}
		//actualizo la lista de articulos con los precios cambiados
		ofad.setArticulos(items);
		
		if (save)
		{
			ofad.setFecha(Calendar.getInstance().getTime());
			em.persist(ofad);
		}
		else {
			ofad.setFecha(checkExistingOfad(null));
		}
		
		return ofad.getVO();
	}
	
	public Date checkExistingOfad(String hash){
		String query;
		Query q;
		
		// Si no le mando un hash, entonces me trae la fecha de la ultima actualizacion
		if (hash == null)
		{
			query = "SELECT o FROM OfAD o ORDER BY o.fecha DESC";
			q = em.createQuery(query);
		}
		else
		{
			query = "SELECT o FROM OfAD o where o.xmlHash = ? ORDER BY o.fecha DESC";
			q = em.createQuery(query);
			q.setParameter(1, hash);
		}
							
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
	
	public Articulo buscarArticulo(long ref){		
		Articulo result = em.find(Articulo.class, ref);
		return result;
	}
	
	public ArticuloVO buscarArticuloVO(long ref) {
		Articulo result = em.find(Articulo.class, ref);
		if (result == null)
		{
			return null;
		}
		else
		{
			return result.getVO();
		}
	}


}	
	
