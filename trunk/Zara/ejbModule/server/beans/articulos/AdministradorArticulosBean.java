package server.beans.articulos;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.NoResultException;

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
	
	public void nuevoOfad(OfADVO ofadVO) {
		OfAD ofad = new OfAD();
		ofad.setVO(ofadVO);
		em.persist(ofad);		
	}
	
	public Date checkExistingOfad(String hash){
		Query q = em.createQuery("SELECT o FROM OfAD o where o.xmlHash = ?");
		q.setParameter(1, hash);
		
		try {
			OfAD ofad = (OfAD) q.getSingleResult();
			return ofad.getFecha();
		}
		catch (NoResultException e) {
			return null;
		}
								
	}


}	
	
