package server.VO.OfAD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class OfADVO{
		
	private static final long serialVersionUID = 1L;
	private String id;
	private Date fecha;
	private Collection<ItemOfADVO> articulos = new ArrayList<ItemOfADVO>();

	public OfADVO(){
		
	}	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
	public Collection<ItemOfADVO> getArticulos() {
		return articulos;
	}

	public void setArticulos(Collection<ItemOfADVO> articulos) {
		this.articulos = articulos;
	}
	
}
