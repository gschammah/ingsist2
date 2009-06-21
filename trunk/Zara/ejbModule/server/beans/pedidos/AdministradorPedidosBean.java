/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.beans.pedidos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import server.VO.EnvT.EnvTVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
import server.VO.articulos.ArticuloVO;
import server.beans.articulos.AdministradorArticulos;
import server.entidades.EnvT.EnvT;
import server.entidades.EnvT.ItemEnvT;
import server.entidades.PALC.PALC;
import server.entidades.articulos.Articulo;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministradorPedidosBean.
 */
@Stateful
public class AdministradorPedidosBean implements AdministradorPedidos {

	/** Entity Manager */
	@PersistenceContext
	private EntityManager em;

	/** Administrador Articulos Bean. */
	@EJB(name = "ZaraEAR/AdministradorArticulosBean/local")
	AdministradorArticulos admArticulos;

	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#nuevoEnvT(server.VO.EnvT.EnvTVO, boolean)
	 */
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save) {

		EnvT envt = new EnvT();
		envt.setVO(envtVO);

		Collection<ItemEnvT> articulos = envt.getArticulos();

		/*
		 * Si save es false, solo quiero que me devuelva un EnvTVO con la lista
		 * de articulos completa
		 */

		for (ItemEnvT item : articulos) {

			Articulo art = admArticulos.buscarArticulo(item.getArticulo().getReferencia());

			if (art != null) {
							
				item.setArticulo(art);

				if (save) {
					item.getArticulo().setStock(
							item.getArticulo().getStock()
									+ item.getCantidadRecibida());
					em.merge(item.getArticulo());
					em.persist(item);
				}
			}
			
		}
		envt.setArticulos(articulos);

		// Si save es true, persisto

		if (save) {
			em.persist(envt);
		}

		return envt.getVO();

	}

	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#checkPedidoExistente(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Date checkPedidoExistente(String hash) {
		Query q = em
				.createQuery("SELECT e FROM EnvT e where e.xmlHash = ? ORDER BY e.fecha DESC");
		q.setParameter(1, hash);

		List envt = q.getResultList();

		if (envt.size() > 0) {
			return ((EnvT) envt.get(0)).getFecha();
		} else {
			return null;
		}
	}

	/**
	 * Devuelve una lista de artículos que se encuentran bajo punto de pedido.
	 * 
	 * @return Lista de artículos bajo PdP
	 */
	@SuppressWarnings("unchecked")
	private Collection<Articulo> getPdP() {

		Query q = em.createQuery("SELECT art FROM Articulo art " +
								 "WHERE art.stock < art.puntoReposicion");

		return q.getResultList();
	}

	/**
	 * Devuelve una lista de artículos disponible en la última OfAD ingresada.
	 * 
	 * @return Lista de Artículos
	 */
	@SuppressWarnings("unchecked")
	private Collection<Articulo> getUltimoOfad() {

		Query q = em.createQuery("SELECT art FROM OfAD o " +
								 "INNER JOIN o.articulos item " +
								 "INNER JOIN item.articulo art " +
								 "WHERE o.id = (SELECT max(o.id) from OfAD o)");

		return q.getResultList();
	}

	/**
	 * Devuelve la cantidad Vendida entre las fechas recibidas de un artículo
	 * en particular.
	 * 
	 * @param referencia Referencia del Artículo
	 * @param fechaDesde Fecha de inicio
	 * @param fechaHasta Fecha final
	 * 
	 * @return Entero con la cantidad vendida del artículo
	 */
	private int getCantVendida(long referencia, Date fechaDesde, Date fechaHasta) {

		Query q = em.createQuery("SELECT SUM(item.cantidad) FROM Venta v " +
								 "INNER JOIN v.items item " + 
								 "INNER JOIN item.articulo art " +
								 "WHERE v.fecha BETWEEN :desde AND :hasta " +
								 "AND art.referencia = :referencia ");

		q.setParameter("desde", fechaDesde);
		q.setParameter("hasta", fechaHasta);
		q.setParameter("referencia", referencia);

		try {
			return new Integer(q.getSingleResult().toString());
		}
		catch (NullPointerException e) {
			return 0;
		}

	}

	/**
	 * Devuelve una lista de artículos con vendidos entre las fechas ingresadas 
	 * 
	 * @param fechaDesde Fecha inicial
	 * @param fechaHasta Fecha final
	 * 
	 * @return Lista de artículos vendidos.
	 */
	@SuppressWarnings("unchecked")
	private Collection<Articulo> getArtVendidos(Date fechaDesde, Date fechaHasta) {

		Query q = em.createQuery("SELECT art FROM Venta v " +
								 "INNER JOIN v.items item " + 
								 "INNER JOIN item.articulo art " +
								 "WHERE v.fecha BETWEEN ? AND ?");

		q.setParameter(1, fechaDesde);
		q.setParameter(2, fechaHasta);

		return q.getResultList();
	}
	
	/**
	 * Calcula los artículos pendientes de envío.
	 * 
	 * @return Devuelve una lista de artículos pendientes.
	 */
	@SuppressWarnings("unchecked")
	private Collection<Articulo> getArtPendientes() {

		Query q = em.createQuery("SELECT i.articulo FROM ItemEnvT i " +								 								
								 "WHERE i.id IN (" +
								 	"SELECT MAX(j.id) FROM ItemEnvT j " +
								 	"INNER JOIN j.articulo art " +
								 	"GROUP BY art.referencia)" +
								 "AND i.cantidadPendiente <> 0");

		
		return q.getResultList();
	}
		
	/**
	 * Calcula la cantidad pendiente de envío de un artículo particular.
	 * 
	 * @param ref Referencia del artículo
	 * 
	 * @return Cantidad pendiente
	 */
	private int getArtPendientes(long ref) {

		Query q = em.createQuery("SELECT i.cantidadPendiente FROM ItemEnvT i " +
								 "WHERE i.id = (" +
								 	"SELECT MAX(j.id) FROM ItemEnvT j " +
								 	"WHERE j.articulo.referencia = :ref)");
		q.setParameter("ref", ref);
		
		try {
			return new Integer(q.getSingleResult().toString());
		}
		catch (NullPointerException e) {
			return 0;
		}
	}


	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#getPALC(long)
	 */
	public PalcPropuestoVO getPALC(long ref) {
		
		ArticuloVO art = admArticulos.buscarArticuloVO(ref);
		
		if (art == null) return null;
		
		PalcPropuestoVO palc = new PalcPropuestoVO();
		
		// Calculo fechas
		Calendar semanaPasada = Calendar.getInstance();
		semanaPasada.add(Calendar.DATE, -7);
		
		palc.setArticulo(art);
		palc.setVentas(getCantVendida(art.getReferencia(), semanaPasada
				.getTime(), Calendar.getInstance().getTime()));
		palc.setPendientes(getArtPendientes(art.getReferencia()));
		
		return palc;
	}

	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#getPALC()
	 */
	public Collection<PalcPropuestoVO> getPALC() {

		Collection<PalcPropuestoVO> palc = new ArrayList<PalcPropuestoVO>();

		// Uso hashset para remover duplicados
		HashSet<Articulo> articulos = new HashSet<Articulo>();

		// Calculo fechas
		Calendar semanaPasada = Calendar.getInstance();
		semanaPasada.add(Calendar.DATE, -7);

		
		articulos.addAll(getUltimoOfad()); 
		articulos.addAll(getPdP());		
		articulos.addAll(getArtVendidos(semanaPasada.getTime(),	Calendar.getInstance().getTime()));		
		articulos.addAll(getArtPendientes());

		for (Articulo articulo : articulos) {
			PalcPropuestoVO p = new PalcPropuestoVO();
			p.setArticulo(articulo.getVO());

			p.setPendientes(getArtPendientes(p.getArticulo().getReferencia()));
			p.setVentas(getCantVendida(articulo.getReferencia(), semanaPasada
						.getTime(), Calendar.getInstance().getTime()));
			palc.add(p);
		}
		return palc;
	}

	/* (non-Javadoc)
	 * @see server.beans.pedidos.AdministradorPedidos#registraPALC(server.VO.PALC.PALCVO)
	 */
	public int registraPALC(PALCVO palc) {
		
		PALC p = new PALC();
		p.setVO(palc);
		
		try {
			em.persist(p);
			return p.getId();
		}
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
