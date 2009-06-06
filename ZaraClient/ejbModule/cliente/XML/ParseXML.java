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

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.VO.PALC.PALCVO;
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
			itemOfadVO.setPrecioLista(Float.parseFloat(art
					.getChildText("precioLista")));
			itemOfadVO.setPrecioOferta(Float.parseFloat(art
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
			nuevoArt.setPrecioLista(Float.parseFloat(art.getChildText("precioLista")));
			nuevoArt.setPrecioOferta(Float.parseFloat(art.getChildText("precioOferta")));
			nuevoArt.setReferencia(Long.parseLong(art.getChildText("Referencia")));
			nuevoArt.setSeccion(art.getChildText("seccion"));
			nuevoArt.setPuntoReposicion(Integer.parseInt(art.getChildText("stockReposicion")));			
			
			itemOfadVO.setArticulo(nuevoArt);					
			
			ofadVO.addItem(itemOfadVO);

		}

		return ofadVO;

	}
	
	
	public static EnvTVO parseEnvT(String file) {

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
		List articulos = root.getChild("itemsenvt").getChildren();
		EnvTVO envt = new EnvTVO();
		envt.setFecha(Calendar.getInstance().getTime());				
		envt.setXmlHash(md5.obtenerMD5Hash());		
				
				
		for (Object articulo : articulos) {

			Element art = ((Element) articulo);

			ItemEnvTVO itemEnvT = new ItemEnvTVO();							
			ArticuloVO artVO = new ArticuloVO();
			
			artVO.setReferencia(Long.parseLong(art.getChildText("referencia")));
			
			itemEnvT.setCantidadRecibida(Integer.parseInt(art.getChildText("cantidadenviada")));			
			itemEnvT.setCantidadPendiente(Integer.parseInt(art.getChildText("cantidadpendiente")));
			itemEnvT.setArticulo(artVO);
			
			envt.addItem(itemEnvT);

		}

		return envt;

	}
	
	public static void generaPALC(String file, PALCVO palc){
		
	}
	
	
}
