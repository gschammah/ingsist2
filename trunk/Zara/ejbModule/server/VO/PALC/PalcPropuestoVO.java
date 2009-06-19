package server.VO.PALC;

import java.io.Serializable;

import server.VO.articulos.ArticuloVO;

public class PalcPropuestoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ArticuloVO articulo;
	private int Ventas;
	private int pendientes;	
	
	public PalcPropuestoVO(){
		
	}

	public ArticuloVO getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}

	public int getVentas() {
		return Ventas;
	}

	public void setVentas(int ventas) {
		Ventas = ventas;
	}

	public int getPendientes() {
		return pendientes;
	}

	public void setPendientes(int pendientes) {
		this.pendientes = pendientes;
	}


}
