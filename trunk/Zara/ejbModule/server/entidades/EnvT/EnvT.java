/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.entidades.EnvT;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;

@Entity
@Table(name="EnvT")
public class EnvT implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date fecha;
	private String xmlHash;
	private Collection<ItemEnvT> articulos = new ArrayList<ItemEnvT>();
	//TODO hash
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(columnDefinition="datetime")
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@OneToMany(mappedBy="envt", fetch=FetchType.EAGER)
	public Collection<ItemEnvT> getArticulos() {
		return articulos;
	}
	
	public void setArticulos(Collection<ItemEnvT> articulos) {
		this.articulos = articulos;
	}
	
	@Transient
    public EnvTVO getVO(){
            EnvTVO vo = new EnvTVO();
            vo.setId(this.getId());
            vo.setFecha(this.fecha);
            vo.setXmlHash(this.getXmlHash());
            vo.setArticulos(this.envTToVO());            
            return vo;
    }
    
	
    private Collection<ItemEnvTVO> envTToVO() {		
    	ArrayList<ItemEnvTVO> result = new ArrayList<ItemEnvTVO>();
    	
    	for (ItemEnvT itemEnvT : this.articulos) {
			result.add(itemEnvT.getVO());
		}
    	
		return result;
	}
    
    private Collection<ItemEnvT> voToEnvT(Collection<ItemEnvTVO> vo) {		
    	ArrayList<ItemEnvT> result = new ArrayList<ItemEnvT>();
    	
    	for (ItemEnvTVO itemEnvtVO : vo) {
    		ItemEnvT item = new ItemEnvT();
    		item.setVO(itemEnvtVO);    		
    		item.setEnvt(this);
			result.add(item);
		}
    	
		return result;
	}

	public void setVO(EnvTVO vo){            
            this.id = vo.getId();
            this.fecha = vo.getFecha();
            this.xmlHash = vo.getXmlHash();
            this.articulos = this.voToEnvT(vo.getArticulos());            
    }

	public String getXmlHash() {
		return xmlHash;
	}

	public void setXmlHash(String xmlHash) {
		this.xmlHash = xmlHash;
	}
	
}
