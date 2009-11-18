package vo;

import java.io.Serializable;
import java.util.ArrayList;

public class EnvtVO implements Serializable {

	private static final long serialVersionUID = -5864876582489679646L;
	private static int id;
	private Integer idenvt;
	private ArrayList<ItemenvtVO> itemsenvt;
	
	public EnvtVO(ArrayList<ItemenvtVO> item) {
		this.itemsenvt=item;
		id++;
		this.setIdenvt(idenvt);
	}


	public EnvtVO() {
		// TODO Auto-generated constructor stub
	}


	public ArrayList<ItemenvtVO> getItemsenvt() {
		return itemsenvt;
	}

	public void setItemsenvt(ArrayList<ItemenvtVO> itemsenvt) {
		this.itemsenvt = itemsenvt;
	}


	public void setIdenvt(Integer idenvt) {
		this.idenvt = idenvt;
	}


	public Integer getIdenvt() {
		return idenvt;
	}

	
	
}
