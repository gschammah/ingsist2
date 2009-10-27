package ar.edu.uade.ingsoft.pages.tml;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.naming.NamingException;

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
