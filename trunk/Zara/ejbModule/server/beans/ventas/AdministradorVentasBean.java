/*
 * Ingeniería en sistemas 2
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
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import server.VO.clientes.ClienteVO;
import server.VO.ventas.VentaVO;
import server.beans.articulos.AdministradorArticulos;
import server.entidades.articulos.Articulo;
import server.entidades.clientes.Cliente;
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
	 * Recibe la lista de artículos facturados y calcula la cantidad
	 * total pedida del mismo artículo
	 * 
	 * @param itemVenta Línea de la factura
	 * @param items Todas las líneas de la factura.
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
	
	public ClienteVO buscarCliente(String cuit){		
		Cliente result = em.find(Cliente.class, cuit);
		if (result == null) {
			return null;
		}
		return result.getVO();
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
			
			if (buscarCliente(venta.getCliente().getCuit()) != null) {
				em.merge(venta.getCliente());
			}
			else {
				em.persist(venta.getCliente());
			}
			em.persist(venta);			
			venta.setHayStock(true);			
		}
		return venta.getVO();
	}	
	
	@Init
	public void init(){		
		if (this.buscarCliente("0") == null) {
			Cliente cliente = new Cliente();
			cliente.setCuit("0");
			cliente.setDireccion("ND");
			cliente.setNombre("Cliente Anónimo");
			cliente.setRazonSocial("ND");
			em.persist(cliente);
		}
	}

}
