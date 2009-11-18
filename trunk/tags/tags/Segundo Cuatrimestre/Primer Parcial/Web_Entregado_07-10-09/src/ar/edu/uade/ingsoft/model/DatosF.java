package ar.edu.uade.ingsoft.model;

import java.text.DateFormat;

public class DatosF {
	
  	private String clienteFac;
  	private String fechaFac;
  	private char tipoFac;
  	private String numeroFac;
  	private String cuitcuil;
  	private String razonsocial;
  	private String direccion;

	public DatosF(String cliente, String fecha, char tipoFac, int numeroFac, String cuit, String razon, String direccion){
		this.clienteFac = cliente;
		this.fechaFac = fecha;
		this.tipoFac = tipoFac;
		this.numeroFac = new Integer(numeroFac).toString();
		this.cuitcuil = cuit;
		this.razonsocial = razon;
		this.direccion = direccion;
	}

	public String getClienteFac() {
		return clienteFac;
	}

	public void setClienteFac(String clienteFac) {
		this.clienteFac = clienteFac;
	}

	public String getFechaFac() {
		return fechaFac;
	}

	public void setFechaFac(String fechaFac) {
		this.fechaFac = fechaFac;
	}

	public char getTipoFac() {
		return tipoFac;
	}

	public void setTipoFac(char tipoFac) {
		this.tipoFac = tipoFac;
	}

	public String getNumeroFac() {
		return numeroFac;
	}

	public void setNumeroFac(String numeroFac) {
		this.numeroFac = numeroFac;
	}

	public String getCuitcuil() {
		return cuitcuil;
	}

	public void setCuitcuil(String cuitcuil) {
		this.cuitcuil = cuitcuil;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
