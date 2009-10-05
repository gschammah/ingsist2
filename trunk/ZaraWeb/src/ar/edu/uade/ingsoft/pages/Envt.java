package ar.edu.uade.ingsoft.pages;

import java.io.File;
import java.util.Date;

import javax.naming.NamingException;

import org.apache.tapestry5.annotations.PageAttached;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.upload.services.UploadedFile;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.OfADVO;
import tools.ParseXML;
import ar.edu.uade.ingsoft.model.ZaraModel;

public class Envt {

    private ZaraModel modelo;
	
	@Property
    private Date ultimaAct;
	
	@Property
	@SessionState
    private EnvTVO envt;	
		
	@Property
    private UploadedFile fileEnvt;


    @PageAttached
    public void init() {
        if (ultimaAct == null) {
        	try {        		
				modelo = new ZaraModel();
			} catch (NamingException e) { 
				e.printStackTrace();
			}
        	ultimaAct = modelo.getFachada().checkPedidoExistente(null);     
        }
    }


    public Object onSuccess() {        
        ultimaAct = null;               
				
		File copied = new File("../server/default/tmp/" + fileEnvt.getFileName());		
        fileEnvt.write(copied);        
		
			try {
				envt = ParseXML.parseEnvT(copied.getPath());
				envt = modelo.getFachada().nuevoEnvT(envt, false);
				return ConfirmaEnvt.class;
			} 				
			catch (Exception e) {				
				e.printStackTrace();
				return null;
			}			
			
		}
        
        
                
}
        
      

