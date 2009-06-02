package server.entidades.articulos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
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
	
	public ArtHogar(long ref, String desc, String linea, double pL, double pO, 
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
		ArtHogarVO vo = new ArtHogarVO();
		vo.setColor(this.getColor());
		vo.setDescripcion(this.getDescripcion());
		vo.setLinea(this.getLinea());
		vo.setNuevo(this.isNuevo());		
		vo.setPrecioLista(this.getPrecioLista());
		vo.setPrecioOferta(this.getPrecioOferta());
		vo.setReferencia(this.getReferencia());
		vo.setSeccion(this.getSeccion());
		vo.setStock(this.getStock());
		vo.setCategoria(this.getCategoria());
		vo.setComposicion(this.getComposicion());
		vo.setMedidas(this.getMedidas());
		vo.setNombre(this.getNombre());		
		return vo;		
	}

	public void setVO(ArticuloVO artVO){
		super.setVO(artVO);		
		this.setNombre(((ArtHogarVO)artVO).getNombre());
		this.setComposicion(((ArtHogarVO)artVO).getComposicion());
		this.setMedidas(((ArtHogarVO)artVO).getMedidas());
		this.setCategoria(((ArtHogarVO)artVO).getCategoria());
	}

}
