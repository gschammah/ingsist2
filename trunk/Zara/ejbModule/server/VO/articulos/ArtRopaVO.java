package server.VO.articulos;

public class ArtRopaVO extends ArticuloVO {
	 
	private static final long serialVersionUID = 1L;
	
	private String talle;
	private String origen;

	public ArtRopaVO() {

	}

	public ArtRopaVO(long ref, String desc, String linea, float pL, float pO,
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
	
	@Override
	public String toString(){
		StringBuffer result = new StringBuffer();
		
		result.append("<b>Tipo:</b> Ropa<br>");
		result.append(super.toString());
		result.append("<b>Talle:</b> " + talle + "<br>");
		result.append("<b>Origen:</b> " + origen);
		
		return result.toString();
	}

}
