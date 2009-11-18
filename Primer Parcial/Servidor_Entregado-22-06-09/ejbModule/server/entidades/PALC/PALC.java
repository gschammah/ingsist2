/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.entidades.PALC;

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

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PALCVO;

@Entity
public class PALC implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Date fecha;
	private Collection<ItemPALC> articulos = new ArrayList<ItemPALC>();
	private String estado;

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

	@OneToMany(mappedBy = "palc", fetch=FetchType.EAGER, cascade=(CascadeType.ALL))
	public Collection<ItemPALC> getArticulos() {
		return articulos;
	}

	public void setArticulos(Collection<ItemPALC> articulos) {
		this.articulos = articulos;
	}

	@Transient
	public PALCVO getVO() {
		PALCVO vo = new PALCVO();
		vo.setEstado(this.getEstado());
		vo.setFecha(vo.getFecha());
		vo.setId(vo.getId());
		vo.setArticulos(this.PalcToVO());
		return vo;
	}

	private Collection<ItemPALCVO> PalcToVO() {
		ArrayList<ItemPALCVO> result = new ArrayList<ItemPALCVO>();

		for (ItemPALC itemPALC : this.articulos) {
			result.add(itemPALC.getVO());
		}

		return result;
	}

	public void setVO(PALCVO vo) {
		this.estado = vo.getEstado();
		this.fecha = vo.getFecha();
		this.id = vo.getId();
		this.articulos = this.voToPALC(vo.getArticulos());
	}

	private Collection<ItemPALC> voToPALC(Collection<ItemPALCVO> vo) {
		ArrayList<ItemPALC> result = new ArrayList<ItemPALC>();

		for (ItemPALCVO itemPALCVO : vo) {
			ItemPALC item = new ItemPALC();
			item.setVO(itemPALCVO);
			item.setPalc(this);
			result.add(item);
		}

		return result;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
