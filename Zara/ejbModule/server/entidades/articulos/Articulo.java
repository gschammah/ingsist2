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
	private float precioLista;
	private float precioOferta;
	private String color;
	private String seccion;
	private int stock;
	private boolean nuevo = false;
	private int puntoReposicion;
	  	
	
	public Articulo(long ref, String desc, String linea, float pL, float pO, String color, String sec, int stock) {
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

	public float getPrecioLista() {
		return precioLista;
	}

	public void setPrecioLista(float precioLista) {
		this.precioLista = precioLista;
	}

	public float getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(float precioOferta) {
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
	
	public int getPuntoReposicion() {
		return puntoReposicion;
	}

	public void setPuntoReposicion(int puntoReposicion) {
		this.puntoReposicion = puntoReposicion;
	}

	
		 
	@Transient
	public ArticuloVO getVO(){
		ArticuloVO vo = new ArticuloVO();
		vo.setColor(this.getColor());
		vo.setDescripcion(this.getDescripcion());
		vo.setLinea(this.getLinea());
		vo.setNuevo(this.isNuevo());		
		vo.setPrecioLista(this.getPrecioLista());
		vo.setPrecioOferta(this.getPrecioOferta());
		vo.setReferencia(this.getReferencia());
		vo.setSeccion(this.getSeccion());
		vo.setStock(this.getStock());
		vo.setPuntoReposicion(this.getPuntoReposicion());
		return vo;
	}

	public void setVO(ArticuloVO vo){
		this.setColor(vo.getColor());
		this.setDescripcion(vo.getDescripcion());
		this.setLinea(vo.getLinea());
		this.setPrecioLista(vo.getPrecioLista());
		this.setPrecioOferta(vo.getPrecioOferta());
		this.setReferencia(vo.getReferencia());
		this.setSeccion(vo.getSeccion());
		this.setNuevo(vo.isNuevo());
		this.setPuntoReposicion(vo.getPuntoReposicion());
	}

	@Transient
	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

}
