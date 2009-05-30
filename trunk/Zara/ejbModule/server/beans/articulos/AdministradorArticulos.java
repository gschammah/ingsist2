package server.beans.articulos;

import java.util.Date;

import javax.ejb.Remote;

import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.Articulo;

@Remote
public interface AdministradorArticulos {

	public OfADVO nuevoOfad(OfADVO ofad);
	
	public Date checkExistingOfad(String hash);
	
	public Articulo buscarArticulo(Articulo art);

}
