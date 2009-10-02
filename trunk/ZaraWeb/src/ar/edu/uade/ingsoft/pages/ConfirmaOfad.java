package ar.edu.uade.ingsoft.pages;

import javax.naming.NamingException;

import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import ar.edu.uade.ingsoft.model.ZaraModel;

public class ConfirmaOfad {

	@Property
	@SessionState
    private OfADVO ofad;
	
	@Property
	private ItemOfADVO item;
	
	private ZaraModel modelo;
	
	private String action;
	
	public Object onSuccess() {
		
		if (action.equals("guardar")) {		
			try {
				modelo = new ZaraModel();
				ofad = modelo.getFachada().nuevoOfad(ofad, true);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return null;
		} else {
			return Ofad.class;
		}
		
	}
	
	private void onSelectedFromGuardar() {
		action = "guardar";
	}
	
	private void onSelectedFromSalir() {
		action = "salir";
	} 
	
}
