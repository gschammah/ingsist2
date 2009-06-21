/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.VO.EnvT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class EnvTVO implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;
	private String xmlHash;
	private Collection<ItemEnvTVO> articulos = new ArrayList<ItemEnvTVO>();
	
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
	
	public Collection<ItemEnvTVO> getArticulos() {
		return articulos;
	}
	
	public void setArticulos(Collection<ItemEnvTVO> articulos) {
		this.articulos = articulos;
	}
	
	public void addItem(ItemEnvTVO item){
		this.articulos.add(item);
	}

	public String getXmlHash() {
		return xmlHash;
	}

	public void setXmlHash(String xmlHash) {
		this.xmlHash = xmlHash;
	}
}
