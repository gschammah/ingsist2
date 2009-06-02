package server.beans.ventas;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.Articulo;

@Stateful 
public class AdministradorVentasBean implements AdministradorVentas {
	
	@PersistenceContext
	private EntityManager em;

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
