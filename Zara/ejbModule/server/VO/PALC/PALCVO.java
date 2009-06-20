package server.VO.PALC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import server.VO.EnvT.ItemEnvTVO;

public class PALCVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;	
	private Collection<ItemPALCVO> articulos = new ArrayList<ItemPALCVO>();
	private String estado;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Collection<ItemPALCVO> getArticulos() {
		return articulos;
	}
	
	public void setArticulos(Collection<ItemPALCVO> articulos) {
		this.articulos = articulos;
	}
		
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void addItem(ItemPALCVO item) {		
		articulos.add(item);
	}
	
}