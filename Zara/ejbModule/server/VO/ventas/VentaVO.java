/*
 * Ingenierķa en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.VO.ventas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import server.VO.clientes.ClienteVO;
import server.entidades.clientes.Cliente;

public class VentaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Date fecha;
	private char tipoFactura;
	private Collection<ItemVentaVO> items = new ArrayList<ItemVentaVO>();
	private float subTotal;
	private float iva;
	private float total;
	private boolean hayStock = true;
	private ClienteVO cliente;

	public boolean isHayStock() {
		return hayStock;
	}

	public void setHayStock(boolean hayStock) {
		this.hayStock = hayStock;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public char getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(char tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Collection<ItemVentaVO> getItems() {
		return items;
	}

	public void setItems(Collection<ItemVentaVO> items) {
		this.items = items;
	}

	public void addItem(ItemVentaVO vo) {
		items.add(vo);
	}

	public ClienteVO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

}
