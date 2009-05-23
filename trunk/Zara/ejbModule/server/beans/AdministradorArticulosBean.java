package server.beans;


import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.entidades.articulos.*;


/**
 * Bean Stateful que administra articulos
 *
 */
@Stateful
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	@PersistenceContext
	private EntityManager em;		
	
	public void test() {	 
		Articulo art = new Articulo(7377674, "Vestido corto", "Basic", 119.0, 12.4, "Negro", "Mujer", 39);		
		em.persist(art);
		
	}

}	
	
