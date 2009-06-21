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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import server.VO.ventas.ItemVentaVO;
import server.entidades.articulos.Articulo;

@Entity
public class ItemVenta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Venta venta;
	private Articulo articulo;
	private int cantidad;
	private float precio;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	public Venta getVenta() {
		return venta;
	}
	
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	@OneToOne
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setVO(ItemVentaVO vo) {
		this.articulo = new Articulo();
		this.articulo.setVO(vo.getArticulo());
		this.cantidad = vo.getCantidad();
		this.id = vo.getId();
		this.precio = vo.getPrecio();
	}

	@Transient
	public ItemVentaVO getVO() {
		ItemVentaVO vo = new ItemVentaVO();
		vo.setArticulo(this.articulo.getVO());
		vo.setCantidad(this.cantidad);
		vo.setPrecio(this.precio);
		vo.setId(this.id);		
		return vo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
