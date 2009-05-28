package server.entidades.articulos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;

@Entity
@DiscriminatorValue("ROPA")

public class ArtRopa extends Articulo {

	private static final long serialVersionUID = 1L;
	
	private String talle;
	private String origen;
	
	public ArtRopa(){
		
	}
	public ArtRopa(long ref, String desc, String linea, double pL, double pO, 
			 String color, String sec, int stock, String talle, String origen) { 			 

		super(ref, desc, linea, pL, pO, color, sec, stock);
		this.talle = talle;
		this.origen = origen;
		
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
	
	@Transient
	public ArtRopaVO getVO(){
		ArtRopaVO vo = new ArtRopaVO( this.getReferencia(),
										this.getLinea(),
										this.getDescripcion(),
										this.getPrecioLista(),
										this.getPrecioOferta(),
										this.getColor(),
										this.getSeccion(),
										this.getStock(),
										this.getTalle(),
										this.getOrigen());
		return vo;
	}

	public void setVO(ArtRopaVO vo){
		this.setColor(vo.getColor());
		this.setDescripcion(vo.getDescripcion());
		this.setLinea(vo.getLinea());
		this.setPrecioLista(vo.getPrecioLista());
		this.setPrecioOferta(vo.getPrecioOferta());
		this.setReferencia(vo.getReferencia());
		this.setSeccion(vo.getSeccion());
		this.setTalle(vo.getTalle());
		this.setOrigen(vo.getOrigen());		
	}

}
