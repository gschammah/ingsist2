package server.VO.PALC;

import java.io.Serializable;

import server.entidades.PALC.PALC;
import server.entidades.articulos.Articulo;

public class ItemPALCVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Articulo articulo;
	private int cantidadSolicitada;	
	private PALC palc;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
		
	public PALC getPalc() {
		return palc;
	}
	
	public void setPalc(PALC palc) {
		this.palc = palc;
	}	
}
