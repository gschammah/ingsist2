package server.entidades.PALC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import server.VO.PALC.PALCVO;

@Entity
public class PALC implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;	
	private Collection<ItemPALC> articulos = new ArrayList<ItemPALC>();
	private String estado;
	
	@Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@OneToMany(mappedBy="palc")
	public Collection<ItemPALC> getArticulos() {
		return articulos;
	}
	
	public void setArticulos(Collection<ItemPALC> articulos) {
		this.articulos = articulos;
	}
	
	@Transient
	public PALCVO getVO(){
		return null;
	}
	
	public void setVO(){
			
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
