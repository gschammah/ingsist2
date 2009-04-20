/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (servidor)
 *  
 */


package ar.edu.uade.ingsoft.entidades;

import java.io.Serializable;

import ar.edu.uade.ingsoft.utils.ProductoVO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
import javax.persistence.Transient;

@Entity  
@Table(name="PROD")
public class Producto implements Serializable{
	private int productoId;
	private String nombre;
	private String marca;
	private String detalles;
	private int stock;
	private int precio;
	  
	public Producto(int id, String n, String m, String d, int st, int pr) {
		productoId = id;
		nombre = n;
		marca = m;
		detalles = d;
		stock = st;
		precio = pr;
	}

	public Producto() {
	}
	 
	@Id 
	@Column(name="ID")
	public int getProductoId(){
		return productoId;
	}
	
	public void setProductoId(int id){
		productoId = id;
	}
	@Column(name="DETS")
	public String getDetalles() {
		return detalles;
	} 
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	} 
	@Column(name="MARCA")
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Column(name="NOMB")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name="PRIC")
	public int getPrecio() {
		return precio;
	} 
	public void setPrecio(int precio) {
		this.precio = precio;
	} 
	@Column(name="STOCK")
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	 
	@Transient
	public ProductoVO getVO(){
		ProductoVO vo = new ProductoVO(productoId,nombre,detalles,stock);
		return vo;
	}

	public void setVO(ProductoVO vo){
		this.setDetalles(vo.getDetalles());
		this.setNombre(vo.getNombre());
		this.setStock(vo.getStock());
	}

}
