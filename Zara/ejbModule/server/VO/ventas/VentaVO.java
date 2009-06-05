package server.VO.ventas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class VentaVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private Date fecha;
	private char tipoFactura;
	private Collection<ItemVentaVO> items = new ArrayList<ItemVentaVO>();

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

	public char getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(char tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Collection<ItemVentaVO> getItems() {
		return items;
	}

	public void setItems(Collection<ItemVentaVO> items) {
		this.items = items;
	}

	public void addItem(ItemVentaVO vo) {
		items.add(vo);
	}

}
