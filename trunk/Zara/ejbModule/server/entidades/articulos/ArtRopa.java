package server.entidades.articulos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROPA")

public class ArtRopa extends Articulo {

	private static final long serialVersionUID = 1L;
	
	private String talle;
	private String origen;
	
	public ArtRopa(){
		
	}
	
	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

}
