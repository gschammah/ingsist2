package server.entidades.OfAD;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import server.entidades.articulos.Articulo;


@Entity
@Table(name="OfAD")

public class OfAD implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private String id;
	private Date fecha;
	private Collection<Articulo> articulos;

	public OfAD(){
		
	}
	
	
	@Id
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

	public Collection<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(Collection<Articulo> articulos) {
		this.articulos = articulos;
	}
	
}
