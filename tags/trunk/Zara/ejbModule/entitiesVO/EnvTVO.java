package entitiesVO;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;


public class EnvTVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEnvT;
	private List<ItemEnvTVO> ItemsEnvio = new Vector<ItemEnvTVO>();

	
	

	public int getIdEnvT() {
		return idEnvT;
	}

	public void setIdEnvT(int idEnvT) {
		this.idEnvT = idEnvT;
	}


	public List<ItemEnvTVO> getItemsEnvio() {
		return ItemsEnvio;
	}

	public void setItemsEnvio(List<ItemEnvTVO> itemsEnvio) {
		ItemsEnvio = itemsEnvio;
	}

	
}
