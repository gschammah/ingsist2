/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 11A - Creación de un objeto a partir de XML
 *  
 */

package cliente.tools;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Clase Wrapper para leer un archivo
 *
 */
public class FileReaderWrapper {
	private String file;

	public FileReaderWrapper(String file){
		this.file = file;
	}

	public String obtenerContenido(){
		StringBuffer contenido = new StringBuffer();
		try
		{
			FileInputStream fileInputStream = new FileInputStream(file);
			DataInputStream input = new DataInputStream(fileInputStream);
			while (input.available() !=0)
			{
				contenido.append(input.readLine());
			}
			input.close();
		}catch(Exception ex){
			System.out.println("Error al leer el contenido del archivo");
		}
		return contenido.toString();
	}
}
