package server.entidades.articulos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
import server.VO.articulos.ArticuloVO;

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
		ArtRopaVO vo = new ArtRopaVO();
		vo.setColor(this.getColor());
		vo.setDescripcion(this.getDescripcion());
		vo.setLinea(this.getLinea());
		vo.setNuevo(this.isNuevo());		
		vo.setPrecioLista(this.getPrecioLista());
		vo.setPrecioOferta(this.getPrecioOferta());
		vo.setReferencia(this.getReferencia());
		vo.setSeccion(this.getSeccion());
		vo.setStock(this.getStock());
		vo.setOrigen(this.getOrigen());
		vo.setTalle(this.getTalle());
		return vo;		
	}

	public void setVO(ArticuloVO vo){
		super.setVO(vo);		
		this.setTalle(((ArtRopaVO) vo).getTalle());
		this.setOrigen(((ArtRopaVO) vo).getOrigen());		
	}

}
