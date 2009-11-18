/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.principal;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.naming.NamingException;

import cliente.controladores.ZaraMainController;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaMainMenu;

public class ZaraMain {

	public static void main(String[] args) {
		new ZaraMain();
	}

	public ZaraMain(){
		ZaraModel modelo = null;
		
		try {
			modelo = new ZaraModel();
			
			FileHandler ofadHandler = new FileHandler("error_ofad.txt", true);
			FileHandler envtHandler = new FileHandler("error_envt.txt", true);
			
			Formatter formatter = new Formatter() {						
		        @Override
				public String format(LogRecord rec) {
		        	Date fecha = new Date();
		            StringBuffer buf = new StringBuffer();
		            buf.append("[");
		            buf.append(DateFormat.getDateInstance().format(fecha));
		            buf.append(' ');
		            buf.append(DateFormat.getTimeInstance().format(fecha));
		            buf.append("] ");
		            buf.append(rec.getLevel());
		            buf.append(" - ");
		            buf.append(formatMessage(rec));
		            buf.append('\n');
		            return buf.toString();
		            }
		         };

			
			ofadHandler.setFormatter(formatter);
			envtHandler.setFormatter(formatter);
			
			Logger.getLogger("ofad").addHandler(ofadHandler);
			Logger.getLogger("envt").addHandler(envtHandler);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (IOException e) {}		
		VistaMainMenu mainMenu = new VistaMainMenu(modelo);
		new ZaraMainController(modelo, mainMenu);
	}

}
