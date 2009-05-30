package server.beans.articulos;

import java.util.Date;

import javax.ejb.Remote;

import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;

@Remote
public interface AdministradorArticulos {

	public void nuevoOfad(OfADVO ofad);
	
	public Date checkExistingOfad(String hash);

}
