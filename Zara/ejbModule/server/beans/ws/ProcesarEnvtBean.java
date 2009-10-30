package server.beans.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import server.VO.EnvT.EnvTVO;
import server.beans.fachada.Fachada;
import tools.ParseXML;

@WebService
@Stateless
public class ProcesarEnvtBean implements ProcesarEnvt {

	@EJB(name="ZaraEAR/FachadaBean/local") 
    Fachada fachada;
	
	@WebMethod
	public boolean recibirEnvt(String envtXML){			
				
		EnvTVO vo;
		
		try {
			vo = ParseXML.parseEnvT(envtXML);
			fachada.nuevoEnvT(vo, true);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;		
		}
		
	}
}
