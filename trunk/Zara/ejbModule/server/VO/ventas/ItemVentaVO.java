package server.VO.ventas;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.Articulo;

public class ItemVentaVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private VentaVO venta;
	private ArticuloVO articulo;
	private int cantidad;
	private float precio;
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public VentaVO getVenta() {
		return venta;
	}
	
	public void setVenta(VentaVO venta) {
		this.venta = venta;
	}
		
	public ArticuloVO getArticulo() {
		return articulo;
	}
	
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
