package server.beans.ws;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.articulos.ArticuloVO;
import server.beans.fachada.Fachada;
import vo.ItemenvtVO;

@WebService
@Stateless
public class ProcesarEnvtBean implements ProcesarEnvt {

	@EJB(name="ZaraEAR/FachadaBean/local") 
    Fachada fachada;
	
	@WebMethod
	public boolean recibirEnvt(vo.EnvtVO vo){							
		
		try {
								
				server.VO.EnvT.EnvTVO envtVO = new server.VO.EnvT.EnvTVO();
				
				envtVO.setFecha(new Date());				
				
				for (ItemenvtVO item : vo.getItemsenvt()) {
					ItemEnvTVO itemVO = new ItemEnvTVO();
					ArticuloVO artVO = new ArticuloVO();
					artVO.setReferencia(new Long(item.getReferencia()));
					itemVO.setArticulo(artVO);
					itemVO.setCantidadPendiente(item.getCantidadpendiente());
					itemVO.setCantidadRecibida(item.getCantidadEnviada());
					itemVO.setEnvt(envtVO);
					
					if (itemVO.getArticulo() != null) {
						envtVO.getArticulos().add(itemVO);
					}
				}
				
				fachada.nuevoEnvT(envtVO, true);
				
				return true;
				
			} catch (Exception e) {
				e.printStackTrace();
				return false;				
			}
				
	}
}
