package cliente.XML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
import server.VO.articulos.ArticuloVO;
import cliente.tools.MD5;

public class ParseXML {

	public static OfADVO parseOfAD(String file) {

		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		
		MD5 md5 = new MD5(file);
								
		try {			
			doc = builder.build(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = doc.getRootElement();
		List articulos = root.getChild("articulos").getChildren();
		OfADVO ofadVO = new OfADVO();
		ofadVO.setFecha(Calendar.getInstance().getTime());				
		ofadVO.setXmlHash(md5.obtenerMD5Hash());		
				
				
		for (Object articulo : articulos) {

			Element art = ((Element) articulo);

			ItemOfADVO itemOfadVO = new ItemOfADVO();
			itemOfadVO.setPrecioLista(Double.parseDouble(art
					.getChildText("precioLista")));
			itemOfadVO.setPrecioOferta(Double.parseDouble(art
					.getChildText("precioOferta")));		
			
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
			nuevoArt.setPrecioLista(Double.parseDouble(art
					.getChildText("precioLista")));
			nuevoArt.setPrecioOferta(Double.parseDouble(art
					.getChildText("precioOferta")));
			nuevoArt.setReferencia(Long.parseLong(art
					.getChildText("Referencia")));
			nuevoArt.setSeccion(art.getChildText("seccion"));
			
			itemOfadVO.setArticulo(nuevoArt);					
			
			ofadVO.addItem(itemOfadVO);

		}

		return ofadVO;

	}
}
