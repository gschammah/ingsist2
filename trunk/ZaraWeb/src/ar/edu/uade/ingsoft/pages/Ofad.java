package ar.edu.uade.ingsoft.pages;

import java.io.File;
import java.util.Date;

import javax.naming.NamingException;

import org.apache.tapestry5.annotations.PageAttached;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.upload.services.UploadedFile;

import server.VO.OfAD.OfADVO;
import tools.ParseXML;
import ar.edu.uade.ingsoft.model.ZaraModel;

public class Ofad {

    private ZaraModel modelo;
	
	@Property
    private Date ultimaAct;
	
	@Property
	@SessionState
    private OfADVO ofad;	
		
	@Property
    private UploadedFile fileOfad;


    @PageAttached
    public void init() {
        if (ultimaAct == null) {
        	try {        		
				modelo = new ZaraModel();
			} catch (NamingException e) { 
				e.printStackTrace();
			}
        	ultimaAct = modelo.getFachada().checkExistingOfad(null);     
        }
    }


    public Object onSuccess() {        
        ultimaAct = null;               
				
		File copied = new File("../server/default/tmp/" + fileOfad.getFileName());		
        fileOfad.write(copied);        
		
			try {
				ofad = ParseXML.parseOfAD(copied.getPath());
				ofad = modelo.getFachada().nuevoOfad(ofad, false);
				return ConfirmaOfad.class;
			} 				
			catch (Exception e) {				
				e.printStackTrace();
				return null;
			}			
			
		}
        
        
                
}
        
      

