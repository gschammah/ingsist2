/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 14 - Persistencia simple (servidor)
 *  
 */


package server.entidades.articulos;

import java.io.Serializable;

import server.VO.articulos.ArticuloVO;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
 
import javax.persistence.Transient;

@Entity
@Table(name="Articulos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("GRAL")

public class Articulo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long referencia;
	private String linea;
	private String descripcion;
	private double precioLista;
	private double precioOferta;
	private String color;
	private String seccion;
	private int stock;
	  
	public Articulo(long ref, String desc, String linea, double pL, double pO, String color, String sec, int stock) {
		this.referencia = ref;
		this.descripcion = desc;
		this.precioLista = pL;
		this.precioOferta = pO;
		this.color = color;
		this.seccion = sec;
		this.stock = stock;
	}
	
	public Articulo(){
		
	}
	
	@Id
	public long getReferencia() {
		return referencia;
	}

	public void setReferencia(long referencia) {
		this.referencia = referencia;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioLista() {
		return precioLista;
	}

	public void setPrecioLista(double precioLista) {
		this.precioLista = precioLista;
	}

	public double getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(double precioOferta) {
		this.precioOferta = precioOferta;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	 
	@Transient
	public ArticuloVO getVO(){
		return null;
	}

	public void setVO(ArticuloVO vo){			
	}

}
