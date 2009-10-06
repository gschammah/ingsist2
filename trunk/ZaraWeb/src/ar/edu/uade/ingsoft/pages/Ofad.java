package ar.edu.uade.ingsoft.pages;

import java.io.File;
import java.util.Date;

import org.apache.tapestry5.annotations.PageAttached;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.upload.services.UploadedFile;

import server.VO.OfAD.OfADVO;
import tools.ParseXML;

public class Ofad extends MainPage {
    
	@Property
    private Date ultimaAct;
	
	@Property
	@SessionState
    private OfADVO ofad;	
		
	@Property
    private UploadedFile fileOfad;


    @PageAttached
    public void init() {
    	  super.init();
          ultimaAct = getFachada().checkExistingOfad(null);             
    }


    public Object onSuccess() {        
        ultimaAct = null;               
				
		File copied = new File("../server/default/tmp/" + fileOfad.getFileName());		
        fileOfad.write(copied);        
		
			try {
				ofad = ParseXML.parseOfAD(copied.getPath());
				ofad = getFachada().nuevoOfad(ofad, false);
				return ConfirmaOfad.class;
			} 				
			catch (Exception e) {				
				e.printStackTrace();
				return null;
			}			
			
		}
        
        
                
}
        
      

