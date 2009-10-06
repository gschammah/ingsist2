package ar.edu.uade.ingsoft.pages;

import javax.naming.NamingException;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import ar.edu.uade.ingsoft.model.ZaraModel;

public class ConfirmaOfad extends MainPage {

	@Property
	@SessionState
    private OfADVO ofad;
	
	@Property
	private ItemOfADVO item;
			
	private Class action;
	
	public Object onSuccess() {				
		return action;				
	}
	
	private void onSelectedFromGuardar() {
		super.init();
		ofad = getFachada().nuevoOfad(ofad, true);
		action = null;
	}
	
	private void onSelectedFromSalir() {
		action = Ofad.class;
	} 
	
}
