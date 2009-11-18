package ar.edu.uade.ingsoft.pages.tml;

import server.beans.fachada.Fachada;
import ar.edu.uade.ingsoft.model.ZaraModel;

public abstract class MainPage {
	
	private ZaraModel modelo;
	private Fachada fachada;
	
    public void init() {        
        try {
			modelo = new ZaraModel();															
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public Fachada getFachada() {
		return modelo.getFachada();
	}
}
