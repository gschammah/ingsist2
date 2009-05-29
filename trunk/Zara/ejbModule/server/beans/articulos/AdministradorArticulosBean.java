package server.beans.articulos;


import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
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
	
	public void test(OfADVO ofadVO) {
		OfAD ofad = new OfAD();
		ofad.setVO(ofadVO);
		em.persist(ofad);		
	}

}	
	
