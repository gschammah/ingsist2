/*
 * Ingenier�a en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.beans.ventas;

import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.VO.ventas.VentaVO;
import server.beans.articulos.AdministradorArticulos;
import server.entidades.articulos.Articulo;
import server.entidades.ventas.ItemVenta;
import server.entidades.ventas.Venta;

// TODO: Auto-generated Javadoc
/**
 * Bean que Administrada las Ventas.
 */
@Stateful
public class AdministradorVentasBean implements AdministradorVentas {

	/** EntityManager */
	@PersistenceContext
	private EntityManager em;

	/** Bean Administrador Articulos. */
	@EJB(name = "ZaraEAR/AdministradorArticulosBean/local")
	AdministradorArticulos admArticulos;
	
	/**
	 * Recibe la lista de art�culos facturados y calcula la cantidad
	 * total pedida del mismo art�culo
	 * 
	 * @param itemVenta L�nea de la factura
	 * @param items Todas las l�neas de la factura.
	 * 
	 * @return Cantidad total 
	 */
	private int mergeArticulos(ItemVenta itemVenta, Collection<ItemVenta> items) {
		
		int result = 0;
		
		for (int i = 0; i < items.size(); i++) {
			ItemVenta item = ((ArrayList<ItemVenta>) items).get(i);
			if (item.getArticulo().getReferencia() == itemVenta.getArticulo().getReferencia()) {
				result += item.getCantidad();
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see server.beans.ventas.AdministradorVentas#nuevaVenta(server.VO.ventas.VentaVO)
	 */
	public VentaVO nuevaVenta(VentaVO vo) {
		
		Collection<ItemVenta> result = new ArrayList<ItemVenta>();		
		
		Venta venta = new Venta();
		venta.setVO(vo);
		
		Collection<ItemVenta> items = venta.getItems();

		for (ItemVenta item : items) {									

			Articulo art = admArticulos.buscarArticulo(item.getArticulo().getReferencia());
			
			if (art.getStock() < mergeArticulos(item, items)) {
				ItemVenta i = new ItemVenta();
				i.setArticulo(art);
				result.add(i);
			}
			else {
				art.setStock(art.getStock() - item.getCantidad());
				item.setArticulo(art);
			}
		}
		

		if (result.size() != 0) {
			// no hay stock
			venta.setHayStock(false);
			venta.setItems(result);
		} else {
			// hay stock
			for (ItemVenta item : items) {
				em.merge(item.getArticulo());
			}
			em.persist(venta);
			venta.setHayStock(true);			
		}
		return venta.getVO();
	}

}