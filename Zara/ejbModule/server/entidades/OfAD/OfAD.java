package server.entidades.OfAD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;


@Entity
public class OfAD implements Serializable{
		
	private static final long serialVersionUID = 1L;
	private String id;
	private Date fecha;
	private Collection<ItemOfAD> articulos = new ArrayList<ItemOfAD>();

	public OfAD(){
		
	}	
	
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
			result.add(item);
		}
    	
		return result;
	}

	public void setVO(OfADVO vo){
            this.id = vo.getId();
            this.fecha = vo.getFecha();            
            this.articulos = this.voToOfad(vo.getArticulos());            
    }

	
}
