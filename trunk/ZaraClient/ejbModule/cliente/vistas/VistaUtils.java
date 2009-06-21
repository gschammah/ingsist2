/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.vistas;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VistaUtils {

	public static void showErrorPopup(JFrame vistaGrafica, String mensaje) {
		JOptionPane.showMessageDialog(vistaGrafica, mensaje,
				"Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void showNumericoPopup(JFrame vistaGrafica) {
		JOptionPane.showMessageDialog(vistaGrafica, "El codigo debe ser numérico",
				"Error", JOptionPane.ERROR_MESSAGE); 		
	}
		
}
