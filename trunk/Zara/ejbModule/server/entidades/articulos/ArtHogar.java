package server.entidades.articulos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArticuloVO;

@Entity
@DiscriminatorValue("HOGAR")

public class ArtHogar extends Articulo {
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String composicion;
	private String medidas;
	private String categoria;
	
	public ArtHogar() {
		
	}
	
	public ArtHogar(int ref, String desc, String linea, double pL, double pO, 
							 String color, String sec, int stock, String nom, 
							 String comp, String med, String cat) {
		
		super(ref, desc, linea, pL, pO, color, sec, stock);
		this.nombre = nom;
		this.composicion = comp;
		this.medidas = med;
		this.categoria = cat;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;		
	}
	public String getComposicion() {
		return composicion;
	}
	public void setComposicion(String composicion) {
		this.composicion = composicion;
	}
	public String getMedidas() {
		return medidas;
	}
	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	@Transient
	public ArtHogarVO getVO(){
		ArtHogarVO vo = new ArtHogarVO( this.getReferencia(),
										this.getLinea(),
										this.getDescripcion(),
										this.getPrecioLista(),
										this.getPrecioOferta(),
										this.getColor(),
										this.getSeccion(),
										this.getStock(),
										this.getNombre(),
										this.getComposicion(),
										this.getMedidas(),
										this.getCategoria());
		return vo;
	}

	public void setVO(ArtHogarVO vo){
		this.setColor(vo.getColor());
		this.setDescripcion(vo.getDescripcion());
		this.setLinea(vo.getLinea());
		this.setPrecioLista(vo.getPrecioLista());
		this.setPrecioOferta(vo.getPrecioOferta());
		this.setReferencia(vo.getReferencia());
		this.setSeccion(vo.getSeccion());
		this.setNombre(vo.getNombre());
		this.setComposicion(vo.getComposicion());
		this.setMedidas(vo.getMedidas());
		this.setCategoria(vo.getCategoria());
	}

}
