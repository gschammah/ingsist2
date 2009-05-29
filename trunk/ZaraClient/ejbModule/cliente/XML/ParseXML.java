package cliente.XML;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.thoughtworks.xstream.XStream;

import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
import server.VO.articulos.ArticuloVO;
import server.entidades.OfAD.ItemOfAD;
import server.entidades.OfAD.OfAD;
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
		ofadVO.setId(md5.obtenerMD5Hash());		
		
		//TODO hacer que sea autonumerico
		int i = 1;
				
		for (Object articulo : articulos) {

			Element art = ((Element) articulo);

			ItemOfADVO itemOfadVO = new ItemOfADVO();
			itemOfadVO.setPrecioLista(Double.parseDouble(art
					.getChildText("precioLista")));
			itemOfadVO.setPrecioOferta(Double.parseDouble(art
					.getChildText("precioOferta")));
			itemOfadVO.setId(i++);

			if (art.getName() == "xml.ArtRopaVO") {

				ArtRopaVO nuevoArt = new ArtRopaVO();

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
				nuevoArt.setOrigen(art.getChildText("origen"));
				nuevoArt.setTalle(art.getChildText("talle"));

				itemOfadVO.setArticulo(nuevoArt);

			} else if (art.getName() == "xml.ArtHogarVO") {

				ArtHogarVO nuevoArt = new ArtHogarVO();

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
				nuevoArt.setCategoria(art.getChildText("categoria"));
				nuevoArt.setComposicion(art.getChildText("composicion"));
				nuevoArt.setMedidas(art.getChildText("medidas"));
				nuevoArt.setNombre(art.getChildText("nombre"));

				itemOfadVO.setArticulo(nuevoArt);				
			}
			
			ofadVO.addItem(itemOfadVO);

		}

		return ofadVO;

	}
}
