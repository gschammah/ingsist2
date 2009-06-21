/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.entidades.OfAD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;


@Entity
public class OfAD implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private int id;
	private String xmlHash;
	private Date fecha;
	private Collection<ItemOfAD> articulos = new ArrayList<ItemOfAD>();

	public OfAD(){
		
	}	
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
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


	@Column(columnDefinition="datetime")
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@OneToMany(mappedBy="ofad", fetch=FetchType.EAGER, cascade=(CascadeType.ALL))
	public Collection<ItemOfAD> getArticulos() {		
		return articulos;
	}	

	public void setArticulos(Collection<ItemOfAD> articulos) {
		this.articulos = articulos;
	}
	
	@Transient
    public OfADVO getVO(){
            OfADVO vo = new OfADVO();
            vo.setId(this.getId());
            vo.setXmlHash(this.getXmlHash());
            vo.setArticulos(this.ofadToVO());
            vo.setFecha(fecha);
            return vo;
    }
    
	
    private Collection<ItemOfADVO> ofadToVO() {		
    	ArrayList<ItemOfADVO> result = new ArrayList<ItemOfADVO>();
    	
    	for (ItemOfAD itemOfAD : this.articulos) {
			result.add(itemOfAD.getVO());
		}
    	
		return result;
	}
    
    private Collection<ItemOfAD> voToOfad(Collection<ItemOfADVO> vo) {		
    	ArrayList<ItemOfAD> result = new ArrayList<ItemOfAD>();
    	
    	for (ItemOfADVO itemOfADVo : vo) {
    		ItemOfAD item = new ItemOfAD();
    		item.setVO(itemOfADVo);
    		item.setOfad(this);
			result.add(item);
		}
    	
		return result;
	}

	public void setVO(OfADVO vo){
            this.xmlHash = vo.getXmlHash();
            this.id = vo.getId();
            this.fecha = vo.getFecha();            
            this.articulos = this.voToOfad(vo.getArticulos());            
    }

	
}
