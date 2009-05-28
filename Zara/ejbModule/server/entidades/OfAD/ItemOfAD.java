package server.entidades.OfAD;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.entidades.articulos.Articulo;

@Entity
public class ItemOfAD implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Articulo articulo;
	private double precioLista;
	private double precioOferta;
	private OfAD ofad;
	
	public ItemOfAD(){
		
	}	
	
	@OneToOne
	public Articulo getArticulo() {
		return articulo;
	}
	
	public void setArticulo(Articulo articulo) {
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
            vo.setArticulo(this.getArticulo());
            vo.setPrecioLista(this.getPrecioLista());
            vo.setPrecioOferta(this.getPrecioOferta());            
            return vo;
    }
	
	public void setVO(ItemOfADVO vo){
		this.id = vo.getId();
		this.articulo = vo.getArticulo();
		this.precioLista = vo.getPrecioLista();
		this.precioOferta = vo.getPrecioOferta();
	}
    
	
}
