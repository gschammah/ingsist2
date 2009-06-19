package server.entidades.PALC;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import server.VO.PALC.ItemPALCVO;
import server.entidades.articulos.Articulo;

@Entity
public class ItemPALC implements Serializable{

private static final long serialVersionUID = 1L;
	
	private int id;
	private Articulo articulo = new Articulo();
	private int cantidadSolicitada;	
	private PALC palc;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToOne
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
	
	@ManyToOne
	public PALC getPalc() {
		return palc;
	}
	
	public void setPalc(PALC palc) {
		this.palc = palc;
	}
	
	@Transient
	public ItemPALCVO getVO(){
		ItemPALCVO vo = new ItemPALCVO();
		vo.setArticulo(this.articulo.getVO());
		vo.setCantidadSolicitada(this.cantidadSolicitada);
		vo.setId(this.id);
		
		return vo;
	} 
	

	public void setVO(ItemPALCVO vo) {		
		this.articulo.setVO(vo.getArticulo());
		this.cantidadSolicitada = vo.getCantidadSolicitada();
		this.id = vo.getId();		
	}

}
