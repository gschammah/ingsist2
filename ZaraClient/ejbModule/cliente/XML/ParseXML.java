package cliente.XML;

import com.thoughtworks.xstream.XStream;

import server.entidades.OfAD.OfAD;
import cliente.tools.FileReaderWrapper;

public class ParseXML {
	
	private String file; 

	public static void main(String[] args) {
		new ParseXML("test.xml");
	}
	
	public ParseXML(String file) {
		this.file = file;
	}
	
	public OfAD parseOfAD(){
		
		FileReaderWrapper fileReader = new FileReaderWrapper(this.file);		
		String contenidoXML = fileReader.obtenerContenido();

			XStream xstream = new XStream();
			xstream.alias("OfadVo", OfAD.class);
			OfAD OfADXML = (OfAD)xstream.fromXML(contenidoXML);
			
			return OfADXML;
	
			/*for (int i=0; i<l.getArticulos().size(); i++) {
				if (l.getArticulos().get(i) instanceof ArtRopaVO) {
					System.out.println("IDENTIFICADO COMO ROPA: " + l.getArticulos().get(i).getDescripcion());
				}
				if (l.getArticulos().get(i) instanceof ArtHogarVO) {
					System.out.println("IDENTIFICADO COMO HOGAR: " + l.getArticulos().get(i).getDescripcion());
				}
			}*/			
	}
	
}
