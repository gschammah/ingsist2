package server.beans.articulos;


import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.*;


/**
 * Bean Stateful que administra articulos
 *
 */
@Stateful
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	@PersistenceContext
	private EntityManager em;		
	
	public void test(ArticuloVO art) {
		Articulo arti = new Articulo();
		arti.setVO(art);
		em.persist(arti);		
	}

}	
	
