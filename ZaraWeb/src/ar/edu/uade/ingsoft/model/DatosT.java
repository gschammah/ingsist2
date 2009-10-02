package ar.edu.uade.ingsoft.model;

import server.VO.clientes.ClienteVO;

public class DatosT {
	
	private float subTotal;
	private float iva;
	private float total;
	
	public DatosT(float subtotal, float iva, float total){
		this.subTotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
