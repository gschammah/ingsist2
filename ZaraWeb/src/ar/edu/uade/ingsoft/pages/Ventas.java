package ar.edu.uade.ingsoft.pages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.apache.tapestry5.annotations.PageAttached;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import server.VO.articulos.ArticuloVO;


public class Ventas extends MainPage {
	
	@Property
	private String cuit;
	
	@Property
	private char tipoFact;
	
	@Property
	private Long referencia;
	
	@Persist
	@Property
	private Collection<ArticuloVO> articulos;
	
	@Property
	private ArticuloVO item;
			
    public Date getCurrentTime() {
        return new Date();
    }
    
    private void onSelectedFromAgregar() {	
    	
    	if (articulos == null) {
    		articulos = new ArrayList<ArticuloVO>();
    	} else {
    		articulos = new ArrayList<ArticuloVO>(articulos);
    	}
    	
		item = getFachada().buscarArticuloVO(referencia);
		if (item != null) {
			articulos.add(item);
		}
	}
    
    @PageAttached
    public void init() {
    	super.init();    	
        referencia = null;        
    }
}
