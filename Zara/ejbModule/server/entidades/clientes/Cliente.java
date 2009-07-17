package server.entidades.clientes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import server.VO.clientes.ClienteVO;
import server.entidades.ventas.Venta;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private String nombre;
	private String razonSocial;
	private String cuit;
	private String direccion;
	//private Venta venta;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	@Id
	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Transient
	public ClienteVO getVO(){
		ClienteVO vo = new ClienteVO();
		vo.setCuit(cuit);
		vo.setDireccion(direccion);
		vo.setNombre(nombre);
		vo.setRazonSocial(razonSocial);
		
		return vo;
	}
	
	public void setVO(ClienteVO vo) {
		this.cuit = vo.getCuit();
		this.direccion = vo.getDireccion();
		this.nombre = vo.getNombre();
		this.razonSocial = vo.getRazonSocial();		
	}

	/*@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}*/

}
