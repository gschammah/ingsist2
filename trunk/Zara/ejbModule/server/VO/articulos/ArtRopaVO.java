package server.VO.articulos;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ArtRopaVO extends ArticuloVO {

	private String talle;
	private String origen;

	public ArtRopaVO() {

	}

	public ArtRopaVO(long ref, String desc, String linea, double pL, double pO,
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

	public void setVO(ArticuloVO artVO) {
		ArtRopaVO vo = (ArtRopaVO)artVO;
		this.setColor(vo.getColor());
		this.setDescripcion(vo.getDescripcion());
		this.setLinea(vo.getLinea());
		this.setOrigen(vo.getOrigen());
		this.setPrecioLista(vo.getPrecioLista());
		this.setPrecioOferta(vo.getPrecioOferta());
		this.setReferencia(vo.getReferencia());
		this.setSeccion(vo.getSeccion());
		this.setStock(vo.getStock());
		this.setTalle(vo.getTalle());
	}

}
