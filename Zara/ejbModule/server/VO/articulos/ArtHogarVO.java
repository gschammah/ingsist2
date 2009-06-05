package server.VO.articulos;

public class ArtHogarVO extends ArticuloVO {
	
	private String nombre;
	private String composicion;
	private String medidas;
	private String categoria;
	
	public ArtHogarVO(){
		
	}
	
	public ArtHogarVO(long ref, String desc, String linea, float pL, float pO, 
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
	
	public String toString(){
		StringBuffer result = new StringBuffer();
		
		result.append("<b>Tipo:</b> Hogar<br>");
		result.append(super.toString());
		result.append("<b>Nombre:</b> " + nombre + "<br>");
		result.append("<b>Categoría:</b> " + categoria + "<br>");
		result.append("<b>Medidas:</b> " + medidas + "<br>");
		result.append("<b>Composición:</b> " + composicion);
		
		return result.toString();
	}
		
}
