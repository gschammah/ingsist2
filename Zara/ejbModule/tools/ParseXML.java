/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package tools;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.JDOMParseException;
import org.jdom.input.SAXBuilder;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
import server.VO.articulos.ArticuloVO;
import vo.EnvtVO;
import vo.ItemenvtVO;

public class ParseXML {
	
	@SuppressWarnings("unchecked")
	public static OfADVO parseOfAD(String xml) throws JDOMParseException, JDOMException  {
		
		SAXBuilder builder = new SAXBuilder();
		Reader in = new StringReader(xml);		
		Document doc = null;
		
		try {
			doc = builder.build(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
						
		Element root = doc.getRootElement();
		List articulos = root.getChild("articulos").getChildren();
		OfADVO ofadVO = new OfADVO();												
				
		for (Object articulo : articulos) {

			Element art = ((Element) articulo);

			ItemOfADVO itemOfadVO = new ItemOfADVO();
			
			try {
				itemOfadVO.setPrecioLista(Float.parseFloat(art.getChildText("precioLista")));
				itemOfadVO.setPrecioOferta(Float.parseFloat(art.getChildText("precioOferta")));
			} catch (NumberFormatException e) {}
			
			ArticuloVO nuevoArt = null;						

			if (art.getName() == "xml.ArtRopaVO") {

				nuevoArt = new ArtRopaVO();																
								
				((ArtRopaVO) nuevoArt).setOrigen(art.getChildText("origen"));
				((ArtRopaVO) nuevoArt).setTalle(art.getChildText("talle"));

				itemOfadVO.setArticulo(nuevoArt);

			} else if (art.getName() == "xml.ArtHogarVO") {

				nuevoArt = new ArtHogarVO();
				
				((ArtHogarVO) nuevoArt).setCategoria(art.getChildText("categoria"));
				((ArtHogarVO) nuevoArt).setComposicion(art.getChildText("composicion"));
				((ArtHogarVO) nuevoArt).setMedidas(art.getChildText("medidas"));
				((ArtHogarVO) nuevoArt).setNombre(art.getChildText("nombre"));									
			}
			
			nuevoArt.setColor(art.getChildText("color"));
			nuevoArt.setDescripcion(art.getChildText("descripcion"));
			nuevoArt.setLinea(art.getChildText("linea"));
															
			
			// Chequeo error en referencia
			
			try {
				nuevoArt.setReferencia(Long.parseLong(art.getChildText("Referencia")));
			} catch (NumberFormatException e) {				
				continue;
			} 
			
			
			// Chequeo error en precios
			try {
				
				nuevoArt.setPrecioLista(Float.parseFloat(art.getChildText("precioLista")));
				nuevoArt.setPrecioOferta(Float.parseFloat(art.getChildText("precioOferta")));
				
			} catch (NumberFormatException e) {				
				continue;
			}
			
			nuevoArt.setSeccion(art.getChildText("seccion"));
			nuevoArt.setPuntoReposicion(Integer.parseInt(art.getChildText("stockReposicion")));			
			
			itemOfadVO.setArticulo(nuevoArt);					
			
			ofadVO.addItem(itemOfadVO);

		}

		return ofadVO;

	}
	
	
	@SuppressWarnings("unchecked")
	public static EnvTVO parseEnvT(String xml) throws JDOMParseException, JDOMException  {
		
		SAXBuilder builder = new SAXBuilder();
		Reader in = new StringReader(xml);		
		Document doc = null;
		
		try {
			doc = builder.build(in);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Element root = doc.getRootElement();
		List articulos = root.getChild("itemsenvt").getChildren();
		EnvTVO envt = new EnvTVO();
		envt.setFecha(Calendar.getInstance().getTime());											
				
		for (Object articulo : articulos) {

			Element art = ((Element) articulo);

			ItemEnvTVO itemEnvT = new ItemEnvTVO();							
			ArticuloVO artVO = new ArticuloVO();
			
			try {
				artVO.setReferencia(Long.parseLong(art.getChildText("referencia")));
			} catch (NumberFormatException e) {				
				continue;
			}
			
			try {
				itemEnvT.setCantidadRecibida(Integer.parseInt(art.getChildText("cantidadenviada")));			
				itemEnvT.setCantidadPendiente(Integer.parseInt(art.getChildText("cantidadpendiente")));
			} catch (NumberFormatException e) {				
				continue;
			}
			itemEnvT.setArticulo(artVO);
			
			envt.addItem(itemEnvT);

		}

		return envt;

	}

		
}
