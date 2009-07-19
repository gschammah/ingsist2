/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.VO.PALC;

import java.io.Serializable;

import server.VO.articulos.ArticuloVO;


public class ItemPALCVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private ArticuloVO articulo;
	private int cantidadSolicitada;	
	private PALCVO palc;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
		
	public ArticuloVO getArticulo() {
		return articulo;
	}
	
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}
	
	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
		
	public PALCVO getPalc() {
		return palc;
	}
	
	public void setPalc(PALCVO palc) {
		this.palc = palc;
	}	
}
