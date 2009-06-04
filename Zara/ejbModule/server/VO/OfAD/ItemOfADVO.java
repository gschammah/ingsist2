package server.VO.OfAD;

import java.io.Serializable;

import server.VO.articulos.ArticuloVO;


public class ItemOfADVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private ArticuloVO articulo;
	private float precioLista;
	private float precioOferta;
	private OfADVO ofad;
	
	public ItemOfADVO(){
		
	}	
		
	public ArticuloVO getArticulo() {
		return articulo;
	}
	
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
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
