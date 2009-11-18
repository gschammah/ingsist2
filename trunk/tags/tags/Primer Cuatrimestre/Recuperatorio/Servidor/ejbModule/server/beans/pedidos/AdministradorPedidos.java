/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.beans.pedidos;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Remote;
import server.VO.EnvT.EnvTVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;

// TODO: Auto-generated Javadoc
/**
 * Interface Administrador Pedidos.
 */
@Remote
public interface AdministradorPedidos {

	/**
	 * Recibe un objeto del tipo EnvtVO. Si save es false, recibe un 
	 * envt incompleto, donde solo contiene cantidades y número de referencia
	 * de cada artículo. Devuelve un objeto EnvtVO completo, con los detalles de
	 * los artículos. Si save es true, recibe un objeto completo EnvtVO y lo
	 * persiste. Devuelve el objeto persistido.
	 * 
	 * @param envtVO Objeto EnvtVO completo o incompleto
	 * @param save Flag para determinar si se persiste o no el objeto.
	 * 
	 * @return the env tvo
	 */
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save);
	
	/**
	 * Recibe el hash md5 de los datos de un envt previamente persistido
	 * y devuelve la fecha de cuando se persistió, o null si nunca fue 
	 * persistido. Si el parametro hash es nulo, devuelve la fecha de la última
	 * persistencia de un ENVT.
	 * 
	 * @param hash Hash MD5 del Envt
	 * 
	 * @return Fecha de la última persistencia
	 */
	public Date checkPedidoExistente(String hash);
	
	/**
	 * Devuelve una lista de artículos propuestos para generar el PALC
	 * con los detalles de PdP, últimas ventas, stock actual, art. pendientes
	 * de envío y artículos disponibles en OfAD. 
	 * 
	 * @return Lista de artículos propuestos.
	 */
	public Collection<PalcPropuestoVO> getPALC();
	
	/**
	 * Devuelve los detalles de PdP, últimas ventas, stock actual y art. 
	 * pendientes de envío de un artículo particular. 
	 * 
	 * @param ref Referencia del artículo
	 * 
	 * @return Palc Propuesto con detalles
	 */
	public PalcPropuestoVO getPALC(long ref);
	
	/**
	 * Persiste un Palc
	 * 
	 * @param palc PALC a persistir
	 * 
	 * @return Devuelve 0 si dio error, o el id del nuevo palc si se
	 * persiste correctamente.
	 */
	public int registraPALC(PALCVO palc);
				
}
