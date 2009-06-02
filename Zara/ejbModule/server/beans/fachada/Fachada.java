package server.beans.fachada;

import java.util.Date;

import javax.ejb.Remote;

import server.VO.EnvT.EnvTVO;
import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.Articulo;

@Remote
public interface Fachada {

	public OfADVO nuevoOfad(OfADVO ofadVO);
	
	public Date checkExistingOfad(String hash);
	
	public Articulo buscarArticulo(long ref);
		
	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save);
	
	public Date checkExistingEnvT(String hash);
	
	public ArticuloVO buscarArticuloVO(long ref);
}
