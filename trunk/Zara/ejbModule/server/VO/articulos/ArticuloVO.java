package server.VO.articulos;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class ArticuloVO implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private long referencia;
	private String linea;
	private String descripcion;
	private double precioLista;
	private double precioOferta;
	private String color;
	private String seccion;
	private int stock;
	private boolean nuevo = false;
	private int puntoReposicion;
	
	public ArticuloVO(long referencia, String linea, String descripcion, double precioLista, double precioOferta, String color, String seccion, int stock) {
		this.referencia = referencia;
		this.linea = linea;
		this.descripcion = descripcion;
		this.precioLista = precioLista;
		this.precioOferta = precioOferta;
		this.color = color;
		this.seccion = seccion;
		this.stock = stock;
	}

	public ArticuloVO() {
	}

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

	public boolean isNuevo() {
		return nuevo;
	}

	public void setNuevo(boolean nuevo) {
		this.nuevo = nuevo;
	}

	public int getPuntoReposicion() {
		return puntoReposicion;
	}

	public void setPuntoReposicion(int puntoReposicion) {
		this.puntoReposicion = puntoReposicion;
	}
 			
}
