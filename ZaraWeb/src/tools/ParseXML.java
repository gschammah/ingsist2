/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package tools;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.JDOMParseException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import server.VO.EnvT.EnvTVO;
import server.VO.EnvT.ItemEnvTVO;
import server.VO.OfAD.ItemOfADVO;
import server.VO.OfAD.OfADVO;
import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PALCVO;
import server.VO.articulos.ArtHogarVO;
import server.VO.articulos.ArtRopaVO;
import server.VO.articulos.ArticuloVO;
import sun.nio.cs.ISO_8859_2;

public class ParseXML {
	
	private static Document getDocument(String file) throws IOException, JDOMException {		
		SAXBuilder builder = new SAXBuilder();		
		
		FileInputStream f = new FileInputStream(file);									
		InputStreamReader reader = new InputStreamReader(f);
		BufferedReader r = new BufferedReader(reader);
		CharArrayWriter charWriter = new CharArrayWriter();											
														
		String firstLine = r.readLine();
		byte[] firstLineBytes = firstLine.getBytes(new ISO_8859_2());
		
		//me fijo si es utf8 o si ya tiene header
		if (!firstLine.startsWith("<?xml") && firstLineBytes[0] != 63) {
			charWriter.append("<?xml version='1.0' encoding='ISO-8859-1'?>\n");
			charWriter.append(firstLine + "\n");				
			while (r.ready()){					
				charWriter.append(r.readLine() + "\n");
			}				
			charWriter.close();
			
			String output = new String(charWriter.toCharArray());
			
			return builder.build(new ByteArrayInputStream(output.getBytes()));			
		} else {
			return builder.build(new FileInputStream(file));
		}																									
		

	}

	@SuppressWarnings("unchecked")
	public static OfADVO parseOfAD(String file) throws JDOMParseException, JDOMException  {
		
		
		MD5 md5 = new MD5(file);
		Document doc = null;
					
		try {
			doc = ParseXML.getDocument(file);									
		} catch (FileNotFoundException e) {} 
		  catch (IOException e) {}
		
		Element root = doc.getRootElement();
		List articulos = root.getChild("articulos").getChildren();
		OfADVO ofadVO = new OfADVO();					
		ofadVO.setXmlHash(md5.obtenerMD5Hash());		
				
				
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
				Logger.getLogger("ofad").warning("Se encontró un artículo con referencia no numérica o sin referencia. Se descarta.");
				continue;
			} 
			
			
			// Chequeo error en precios
			try {
				
				nuevoArt.setPrecioLista(Float.parseFloat(art.getChildText("precioLista")));
				nuevoArt.setPrecioOferta(Float.parseFloat(art.getChildText("precioOferta")));
				
			} catch (NumberFormatException e) {
				Logger.getLogger("ofad").warning("Se encontraron precios no numéricos o nulos para el artículo " + nuevoArt.getReferencia() + ". Se descarta.");
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
	public static EnvTVO parseEnvT(String file) throws JDOMParseException, JDOMException  {
		
		Document doc = null;
		
		MD5 md5 = new MD5(file);
												
		try {
			doc = ParseXML.getDocument(file);			
		} 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
		
		Element root = doc.getRootElement();
		List articulos = root.getChild("itemsenvt").getChildren();
		EnvTVO envt = new EnvTVO();
		envt.setFecha(Calendar.getInstance().getTime());				
		envt.setXmlHash(md5.obtenerMD5Hash());		
				
				
		for (Object articulo : articulos) {

			Element art = ((Element) articulo);

			ItemEnvTVO itemEnvT = new ItemEnvTVO();							
			ArticuloVO artVO = new ArticuloVO();
			
			try {
				artVO.setReferencia(Long.parseLong(art.getChildText("referencia")));
			} catch (NumberFormatException e) {
				Logger.getLogger("envt").warning("Se encontró un artículo con referencia no numérica. Se descarta.");
				continue;
			}
			
			try {
				itemEnvT.setCantidadRecibida(Integer.parseInt(art.getChildText("cantidadenviada")));			
				itemEnvT.setCantidadPendiente(Integer.parseInt(art.getChildText("cantidadpendiente")));
			} catch (NumberFormatException e) {
				Logger.getLogger("envt").warning("Existe un error en las cantidades para el artículo " + artVO.getReferencia() + ". Se descarta.");
				continue;
			}
			itemEnvT.setArticulo(artVO);
			
			envt.addItem(itemEnvT);

		}

		return envt;

	}
	
	public static void generaPALC(String file, PALCVO palc) throws Exception {
		
		Element root = new Element ("PalcVo");	
		
		Element idPedido = new Element ("IdPedido");		
		idPedido.setText(new Integer(palc.getId()).toString());		
		root.addContent (idPedido);
		
		Element idTienda = new Element ("IdTienda");		
		idTienda.setText("13");
		root.addContent (idTienda);
		
		Element itemsPedido = new Element ("ItemsPedido");
		
		for (ItemPALCVO item : palc.getArticulos()) {
			Element itemPedidoVO = new Element ("xml.ItemPedidoVO");
			
			Element referencia = new Element ("Referencia");
			referencia.setText(new Long(item.getArticulo().getReferencia()).toString());
			Element cantSolicitada = new Element ("CantidadSolicitada");
			cantSolicitada.setText(new Integer(item.getCantidadSolicitada()).toString());
			
			itemPedidoVO.addContent(referencia);
			itemPedidoVO.addContent(cantSolicitada);
			
			itemsPedido.addContent(itemPedidoVO);
		}
		
		
		Element estado = new Element ("Estado");		
		estado.setText(palc.getEstado());
		root.addContent (estado);
		
		root.addContent (itemsPedido);
		
		XMLOutputter out = new XMLOutputter (Format.getPrettyFormat());
		
		out.output (new Document(root), new FileOutputStream (file));			
		 


	}
	
	
}
