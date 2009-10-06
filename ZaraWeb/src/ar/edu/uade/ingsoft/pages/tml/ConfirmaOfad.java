package ar.edu.uade.ingsoft.pages.tml;

import javax.naming.NamingException;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.PageAttached;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.services.Session;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import ar.edu.uade.ingsoft.model.ZaraModel;

public class ConfirmaOfad extends MainPage {

	@Property
	@SessionState
    private OfADVO ofad;
	
	@Property
	private ItemOfADVO item;
	
	@Property
	@Persist
	private boolean success;
			
	private Class action;
	
	public Object onSuccess() {				
		return action;				
	}
		
	private void onSelectedFromGuardar() {
		super.init();
		ofad = getFachada().nuevoOfad(ofad, true);
		success = true;
		action = null;
	}
	
	private void onSelectedFromSalir() {		
		action = Index.class;
	} 
	
}
