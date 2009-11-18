package entitiesVO;

import java.io.Serializable;

public class ItemEnvTVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idItemEnvt;
	private ArticuloVO articulo; //La referencia se setea aca
	private Integer cantidadenviada;
	private Integer cantidadpendiente;
	
	public int getIdItemEnvt() {
		return idItemEnvt;
	}
	
	public void setIdItemEnvt(int idItemEnvt) {
		this.idItemEnvt = idItemEnvt;
	}
	
	public ArticuloVO getArticulo() {
		return articulo;
	}
	
	public void setArticulo(ArticuloVO articulo) {
		this.articulo = articulo;
	}
	
	public Integer getCantidadenviada() {
		return cantidadenviada;
	}
	
	public void setCantidadenviada(Integer cantidadenviada) {
		this.cantidadenviada = cantidadenviada;
	}
	
	public Integer getCantidadpendiente() {
		return cantidadpendiente;
	}
	
	public void setCantidadpendiente(Integer cantidadpendiente) {
		this.cantidadpendiente = cantidadpendiente;
	}
	
}
