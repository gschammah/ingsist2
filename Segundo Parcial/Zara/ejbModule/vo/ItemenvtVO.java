package vo;

import java.io.Serializable;

public class ItemenvtVO implements Serializable{
	
	private static final long serialVersionUID = 7122607151759170798L;
	private Integer referencia;
	private Integer cantidadenviada;
	private Integer cantidadpendiente;
	
	public ItemenvtVO(){}	
	
	public Integer getCantidadEnviada() {
		return cantidadenviada;
	}
	public void setCantidadEnviada(Integer cantidadEnviada) {
		cantidadenviada = cantidadEnviada;
	}
	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}
	public Integer getReferencia() {
		return referencia;
	}
	public void setCantidadpendiente(Integer cantidadpendiente) {
		this.cantidadpendiente = cantidadpendiente;
	}
	public Integer getCantidadpendiente() {
		return cantidadpendiente;
	}

}


