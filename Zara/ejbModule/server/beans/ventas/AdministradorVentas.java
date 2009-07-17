/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.beans.ventas;

import javax.ejb.Remote;

import server.VO.clientes.ClienteVO;
import server.VO.ventas.VentaVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdministradorVentas.
 */
@Remote
public interface AdministradorVentas {
	
	/**
	 * Persiste una venta con sus detalles
	 * 
	 * @param Objeto del tipo VentaVO
	 * 
	 * @return Objeto persistido con su ID
	 */
	public VentaVO nuevaVenta(VentaVO vo);

	public ClienteVO buscarCliente(String cuit);
	
}
