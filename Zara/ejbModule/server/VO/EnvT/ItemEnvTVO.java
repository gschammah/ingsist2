package server.VO.EnvT;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import server.entidades.articulos.Articulo;


public class ItemEnvTVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Articulo articulo;
	private int cantidad;
	private EnvTVO envt;
	
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
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public EnvTVO getEnvt() {
		return envt;
	}
	
	public void setEnvt(EnvTVO envt) {
		this.envt = envt;
	}
	
}
