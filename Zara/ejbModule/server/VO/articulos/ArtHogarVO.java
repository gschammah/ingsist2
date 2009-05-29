package server.VO.articulos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ArtHogarVO extends ArticuloVO {
	
	private String nombre;
	private String composicion;
	private String medidas;
	private String categoria;
	
	public ArtHogarVO(){
		
	}
	
	public ArtHogarVO(long ref, String desc, String linea, double pL, double pO, 
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
	
	public void setVO(ArticuloVO artVO) {
		ArtHogarVO vo = (ArtHogarVO)artVO;
		this.setColor(vo.getColor());
		this.setDescripcion(vo.getDescripcion());
		this.setLinea(vo.getLinea());	
		this.setPrecioLista(vo.getPrecioLista());
		this.setPrecioOferta(vo.getPrecioOferta());
		this.setReferencia(vo.getReferencia());
		this.setSeccion(vo.getSeccion());
		this.setStock(vo.getStock());
		this.setCategoria(vo.getCategoria());
		this.setComposicion(vo.getComposicion());
		this.setMedidas(vo.getMedidas());
		this.setNombre(vo.getNombre());
	}
	
}
