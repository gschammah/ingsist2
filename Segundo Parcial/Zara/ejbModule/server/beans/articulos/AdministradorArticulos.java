/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package server.beans.articulos;

import java.util.Date;

import javax.ejb.Remote;

import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.articulos.Articulo;


/**
 * Interface para administrar los Articuloos y OfAD.
 */
@Remote
public interface AdministradorArticulos {

	/**
	 * Ésta función recibe un ofadVO parseado desde el cliente 
	 * y lo persiste en la base de datos o únicamente informa al
	 * cliente si los artículos son nuevos o no, dependiendo el valor
	 * del parametro save.
	 * 
	 * @param ofad Objeto OFAD del tipo Value Object 
	 * @param save Si es true persiste los datos, sino unicamente completa si el art. es nuevo o no.
	 * 
	 * @return si save es true, devuelve los datos que persistio, si es false devuelve lo mismo que recibió agregándole si el art. es nuevo o no 
	 */
	public OfADVO nuevoOfad(OfADVO ofad, boolean save);
	
	/**
	 * Recibe el hash md5 de los datos de un ofad previamente persistido
	 * y devuelve la fecha de cuando se persistió, o null si nunca fue 
	 * persistido. Si el parametro hash es nulo, devuelve la fecha de la última
	 * persistencia de un OFAD.
	 * 
	 * @param hash Hash MD5
	 * 
	 * @return Fecha de la última persistencia
	 */
	public Date checkExistingOfad(String hash);
	
	/**
	 * Busca un artículo por el codigo de referencia y devuelve un objeto
	 * del tipo Articulo.
	 * 
	 * @param ref Referencia del art
	 * 
	 * @return Articulo
	 */
	public Articulo buscarArticulo(long ref);
	
	/**
	 * Busca un artículo por el codigo de referencia y devuelve un objeto
	 * del tipo ArticuloVO.
	 * 
	 * @param ref Referencia del Art
	 * 
	 * @return Articulo Value Object
	 */
	public ArticuloVO buscarArticuloVO(long ref);

}
