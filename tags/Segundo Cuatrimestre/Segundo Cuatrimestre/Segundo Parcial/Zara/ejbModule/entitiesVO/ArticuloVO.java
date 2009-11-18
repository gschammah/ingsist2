package entitiesVO;

import java.io.Serializable;

public class ArticuloVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Referencia;
	private int stockReposicion;
	private int stock;
	private int stockPendiente;
	private double precioLista;
	private double precioOferta;
	private String descripcion;
	private String color;
	private String linea;
	private String seccion;
	private boolean disponible;

	
	public ArticuloVO(){
		
	}

	public int getReferencia() {
		return Referencia;
	}

	public void setReferencia(int referencia) {
		this.Referencia = referencia;
	}

	public int getStockReposicion() {
		return stockReposicion;
	}

	public void setStockReposicion(int stock) {
		this.stockReposicion = stock;
	}

	public double getPrecioLista() {
		return precioLista;
	}

	public void setPrecioLista(double unitario) {
		precioLista = unitario;
	}

	public double getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(double oferta) {
		precioOferta = oferta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockPendiente() {
		return stockPendiente;
	}

	public void setStockPendiente(int stockPendiente) {
		this.stockPendiente = stockPendiente;
	}
	
	
}
