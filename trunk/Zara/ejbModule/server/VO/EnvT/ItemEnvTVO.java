package server.VO.EnvT;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.Articulo;


public class ItemEnvTVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private ArticuloVO articulo;
	private int cantidadRecibida;
	private int cantidadPendiente;
	private EnvTVO envt;
	
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
	
	public int getCantidadRecibida() {
		return cantidadRecibida;
	}
	
	public void setCantidadRecibida(int cantidad) {
		this.cantidadRecibida = cantidad;
	}
	
	public int getCantidadPendiente() {
		return cantidadPendiente;
	}
	
	public void setCantidadPendiente(int cantidad) {
		this.cantidadPendiente = cantidad;
	}
	
	public EnvTVO getEnvt() {
		return envt;
	}
	
	public void setEnvt(EnvTVO envt) {
		this.envt = envt;
	}
	
}
