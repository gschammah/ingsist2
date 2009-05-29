/*
 * Ingenieria de Sistemas II - 1C2009
 * Marzo/2009
 * 
 * Ejercicio 11A - Creación de un objeto a partir de XML
 *  
 */

package cliente.tools;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase Wrapper para leer un archivo
 * 
 */
public class MD5 {
	private String file;
	private FileInputStream fileInputStream = null;

	public FileInputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(FileInputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public MD5(String file) {
		this.file = file;
		try {
			this.fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el contenido del archivo");
		}
	}

	public byte[] obtenerContenido() {
		BufferedInputStream bis = new BufferedInputStream(fileInputStream);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int ch;
		try {
			while ((ch = bis.read()) != -1) {
				baos.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buffer = baos.toByteArray();

		return buffer;
	}

	public String obtenerMD5Hash() {
		MessageDigest digest = null;
		
		try {
			digest = java.security.MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		digest.update(obtenerContenido());
		byte[] hash = digest.digest();

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			hexString.append(Integer.toHexString(0xFF & hash[i]));
		}
		return hexString.toString();
	}
}
