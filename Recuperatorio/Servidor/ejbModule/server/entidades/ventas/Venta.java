/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.entidades.ventas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import server.VO.ventas.ItemVentaVO;
import server.VO.ventas.VentaVO;
import server.entidades.clientes.Cliente;

@Entity
public class Venta implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Date fecha;
	private char tipoFactura;
	private Collection<ItemVenta> items = new ArrayList<ItemVenta>();	
	private float subTotal;
	private float iva;
	private float total;
	private boolean hayStock = true;
	private Cliente cliente;

	@Transient
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

	@Id
	@GeneratedValue
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

	@OneToMany(mappedBy = "venta", fetch = FetchType.EAGER, cascade=(CascadeType.ALL))
	public Collection<ItemVenta> getItems() {
		return items;
	}

	public void setItems(Collection<ItemVenta> items) {
		this.items = items;
	}

	public void setVO(VentaVO vo) {
		Cliente cliente = new Cliente();
		cliente.setVO(vo.getCliente());
		
		this.fecha = vo.getFecha();
		this.id = vo.getId();
		this.total = vo.getTotal();
		this.subTotal = vo.getSubTotal();
		this.iva = vo.getIva();
		this.hayStock = vo.isHayStock();		
		this.cliente = cliente;
		this.tipoFactura = vo.getTipoFactura();
		this.items = voToVenta(vo.getItems());
	}

	@Transient
	public VentaVO getVO() {
		VentaVO vo = new VentaVO();
		vo.setFecha(this.fecha);
		vo.setIva(this.iva);
		vo.setSubTotal(this.subTotal);
		vo.setTotal(this.total);
		vo.setId(this.id);
		vo.setTipoFactura(this.tipoFactura);
		vo.setCliente(this.cliente.getVO());
		vo.setItems(this.ventaToVO());
		vo.setHayStock(this.hayStock);
		return vo;
	}

	private Collection<ItemVentaVO> ventaToVO() {
		ArrayList<ItemVentaVO> result = new ArrayList<ItemVentaVO>();

		for (ItemVenta itemVenta : this.items) {
			result.add(itemVenta.getVO());
		}

		return result;
	}

	private Collection<ItemVenta> voToVenta(Collection<ItemVentaVO> vo) {
		ArrayList<ItemVenta> result = new ArrayList<ItemVenta>();

		for (ItemVentaVO itemVentaVO : vo) {
			ItemVenta item = new ItemVenta();
			item.setVO(itemVentaVO);
			item.setVenta(this);
			result.add(item);
		}

		return result;
	}

	@OneToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
