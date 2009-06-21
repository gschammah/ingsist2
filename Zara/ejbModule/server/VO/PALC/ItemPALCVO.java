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
import server.entidades.PALC.PALC;

public class ItemPALCVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private ArticuloVO articulo;
	private int cantidadSolicitada;	
	private PALC palc;
		
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
		
	public PALC getPalc() {
		return palc;
	}
	
	public void setPalc(PALC palc) {
		this.palc = palc;
	}	
}
