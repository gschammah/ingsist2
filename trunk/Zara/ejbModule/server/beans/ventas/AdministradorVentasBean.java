package server.beans.ventas;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.VO.articulos.ArticuloVO;
import server.VO.ventas.ItemVentaVO;
import server.VO.ventas.VentaVO;
import server.beans.articulos.AdministradorArticulos;
import server.beans.fachada.Fachada;
import server.entidades.articulos.Articulo;
import server.entidades.ventas.ItemVenta;
import server.entidades.ventas.Venta;

@Stateful
public class AdministradorVentasBean implements AdministradorVentas {

	@PersistenceContext
	private EntityManager em;

	@EJB(name = "ZaraEAR/AdministradorArticulosBean/local")
	AdministradorArticulos admArticulos;

	public Collection<ArticuloVO> nuevaVenta(VentaVO vo) {

		Collection<ArticuloVO> result = new ArrayList<ArticuloVO>();		
		
		Venta venta = new Venta();
		venta.setVO(vo);

		for (ItemVenta item : venta.getItems()) {									

			Articulo art = item.getArticulo();
			
			if (art.getStock() < item.getCantidad()) {				
				result.add(art.getVO());
			}
			else {
				art.setStock(art.getStock() - item.getCantidad());				
			}
		}

		if (result.size() != 0) {
			return result;
		} else {						
			//em.persist(venta);
			return null;
		}
	}

}
