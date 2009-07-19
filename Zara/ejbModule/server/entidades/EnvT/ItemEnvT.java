/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.entidades.EnvT;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import server.VO.EnvT.ItemEnvTVO;
import server.entidades.articulos.Articulo;

@Entity
public class ItemEnvT implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Articulo articulo;
	private int cantidadRecibida;
	private int cantidadPendiente;
	private EnvT envt;
	
	@Id
	@GeneratedValue
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

	public int getCantidadRecibida() {
		return cantidadRecibida;
	}
	
	public void setCantidadRecibida(int cantidad) {
		this.cantidadRecibida = cantidad;
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
            vo.setCantidadRecibida(this.getCantidadRecibida());
            vo.setCantidadPendiente(this.getCantidadPendiente());
            vo.setArticulo(this.articulo.getVO());
            return vo;
    }
	
	public void setVO(ItemEnvTVO vo){						
		this.id = vo.getId();		
		this.cantidadRecibida = vo.getCantidadRecibida();
		this.cantidadPendiente = vo.getCantidadPendiente();
		this.articulo = new Articulo();
		this.articulo.setReferencia(vo.getArticulo().getReferencia());
	}

	public int getCantidadPendiente() {
		return cantidadPendiente;
	}

	public void setCantidadPendiente(int cantidadPendiente) {
		this.cantidadPendiente = cantidadPendiente;
	}
	
}
