package server.VO.OfAD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class OfADVO implements Serializable {
					
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String xmlHash;
	private Date fecha;
	private Collection<ItemOfADVO> articulos = new ArrayList<ItemOfADVO>();

	public OfADVO(){
		
	}		
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
		
	public Collection<ItemOfADVO> getArticulos() {
		return articulos;
	}

	public void setArticulos(Collection<ItemOfADVO> articulos) {
		this.articulos = articulos;
	}
	
	public void addItem(ItemOfADVO articulo){
		articulos.add(articulo);
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getXmlHash() {
		return xmlHash;
	}


	public void setXmlHash(String xmlHash) {
		this.xmlHash = xmlHash;
	}
	
}
