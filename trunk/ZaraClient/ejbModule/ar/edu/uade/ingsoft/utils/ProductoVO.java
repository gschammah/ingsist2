/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (cliente)
 *  
 */
package ar.edu.uade.ingsoft.utils;

import java.io.Serializable;

public class ProductoVO implements Serializable {
	private int productoId;
	private String nombre;
	private String detalles;
	private int stock;
	
	public ProductoVO(int pid, String n, String d, int st) {
		productoId = pid;
		nombre = n;
		detalles = d;
		stock = st;
	}

	public ProductoVO() {
	}

	public int getProductoId(){
		return productoId;
	}
	public String getDetalles() {
		return detalles;
	}
	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
