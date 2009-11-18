package ar.edu.uade.ingsoft.pages.tml;

import javax.naming.NamingException;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import ar.edu.uade.ingsoft.model.ZaraModel;

public class ConfirmaEnvt extends MainPage {

	@Property
	@SessionState
    private EnvTVO envt;
	
	@Property
	private ItemEnvTVO item;
		
	private ZaraModel modelo;
	
	private Class action;
	
	@Property
	@Persist
	private boolean success;
	
	public Object onSuccess() {				
		return action;
	}
	
	private void onSelectedFromGuardar() {
		super.init();		
		envt = getFachada().nuevoEnvT(envt, true);
		success = true;
		action = null;
	}
	
	private void onSelectedFromSalir() {
		success=false;
		action = Index.class;		
	} 
		
	
}
