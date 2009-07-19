/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.entidades.OfAD;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import server.VO.OfAD.ItemOfADVO;
import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
import server.entidades.articulos.ArtHogar;
import server.entidades.articulos.ArtRopa;
import server.entidades.articulos.Articulo;

@Entity
public class ItemOfAD implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Articulo articulo;
	private float precioLista;
	private float precioOferta;
	private OfAD ofad;
	
	public ItemOfAD() {
		
	}
		
	@OneToOne(cascade=(CascadeType.ALL))
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne	
	public OfAD getOfad() {
		return ofad;
	}

	public void setOfad(OfAD ofad) {
		this.ofad = ofad;
	}
	
	@Transient
    public ItemOfADVO getVO(){
            ItemOfADVO vo = new ItemOfADVO();
            vo.setId(this.getId());
            vo.setArticulo(this.getArticulo().getVO());
            vo.setPrecioLista(this.getPrecioLista());
            vo.setPrecioOferta(this.getPrecioOferta());            
            return vo;
    }
	
	public void setVO(ItemOfADVO vo){		
	
		if (vo.getArticulo() instanceof ArtHogarVO) {
			this.articulo = new ArtHogar();			
		}
		else if (vo.getArticulo() instanceof ArtRopaVO) {
			this.articulo = new ArtRopa();			
		} 
		
		this.id = vo.getId();
		this.articulo.setVO(vo.getArticulo());
		
		this.precioLista = vo.getPrecioLista();
		this.precioOferta = vo.getPrecioOferta();
	}
    
	
}
