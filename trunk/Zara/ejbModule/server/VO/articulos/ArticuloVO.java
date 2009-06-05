package server.VO.articulos;

import java.io.Serializable;


public class ArticuloVO implements Serializable {
		
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
	
	public ArticuloVO(long referencia, String linea, String descripcion, float precioLista, float precioOferta, String color, String seccion, int stock) {
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
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		result.append("<b>Descripción:</b> " + descripcion + "<br>");
		result.append("<b>Línea:</b> " + linea + "<br>");
		result.append("<b>Color:</b> " + color + "<br>");
		
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj){
		return true;
	}
 			
}
