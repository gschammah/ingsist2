package server.entidades.EnvT;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
import server.entidades.articulos.ArtHogar;
import server.entidades.articulos.ArtRopa;
import server.entidades.articulos.Articulo;

@Entity
public class ItemEnvT implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Articulo articulo;
	private int cantidad;
	private EnvT envt;
	
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

	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@ManyToOne
	public EnvT getEnvt() {
		return envt;
	}
	
	public void setEnvt(EnvT envt) {
		this.envt = envt;
	}
	
	@Transient
    public ItemEnvTVO getVO(){
            ItemEnvTVO vo = new ItemEnvTVO();
            vo.setId(this.getId());
            vo.setCantidad(this.getCantidad());
            vo.setArticulo(this.articulo.getVO());
            return vo;
    }
	
	public void setVO(ItemEnvTVO vo){						
		this.id = vo.getId();		
		this.cantidad = vo.getCantidad();
		this.articulo = new Articulo();
		this.articulo.setReferencia(vo.getArticulo().getReferencia());
	}
	
}
