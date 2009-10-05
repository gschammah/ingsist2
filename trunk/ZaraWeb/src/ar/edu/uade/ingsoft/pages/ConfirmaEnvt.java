package ar.edu.uade.ingsoft.pages;

import javax.naming.NamingException;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import ar.edu.uade.ingsoft.model.ZaraModel;

public class ConfirmaEnvt {

	@Property
	@SessionState
    private EnvTVO envt;
	
	@Property
	private ItemEnvTVO item;
		
	private ZaraModel modelo;
	
	private String action;
	
	public Object onSuccess() {
		
		if (action.equals("guardar")) {		
			try {
				modelo = new ZaraModel();
				envt = modelo.getFachada().nuevoEnvT(envt, true);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		} else {
			return Envt.class;
		}
		
	}
	
	private void onSelectedFromGuardar() {
		action = "guardar";
	}
	
	private void onSelectedFromSalir() {
		action = "salir";
	} 
	
	
	public boolean isNotPendiente(){
		return item.getCantidadRecibida()!=0;
	}
	
	public boolean isPendiente(){
		return item.getCantidadPendiente()!=0;
		
	}
	
}
