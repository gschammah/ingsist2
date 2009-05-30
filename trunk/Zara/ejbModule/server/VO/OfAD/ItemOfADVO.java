package server.VO.OfAD;

import java.io.Serializable;

import server.VO.articulos.ArticuloVO;


public class ItemOfADVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private ArticuloVO articulo;
	private double precioLista;
	private double precioOferta;
	private OfADVO ofad;
	
	public ItemOfADVO(){
		
	}	
		
	public ArticuloVO getArticulo() {
		return articulo;
	}
	
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OfADVO getOfad() {
		return ofad;
	}

	public void setOfad(OfADVO ofad) {
		this.ofad = ofad;
	}
	
}
