package cliente.vistas;

import javax.swing.JOptionPane;

import cliente.modelo.ZaraModel;
import cliente.vistas.gui.MainMenu;
import framework.vista.Vista;

public class VistaMainMenu extends Vista {

	private MainMenu vistaGrafica;

	public VistaMainMenu(ZaraModel modelo) {
		super(modelo);

		if (modelo == null) {
			
			showErrorPopup("No se ha podido conectar al servidor.");
			System.exit(1);
			
		} else {

			vistaGrafica = new MainMenu(this);
			this.centrarVista(vistaGrafica);
			vistaGrafica.pack();
			vistaGrafica.setVisible(true);

		}

	}

	public void showErrorPopup(String mensaje) {
		JOptionPane.showMessageDialog(vistaGrafica, mensaje, "Error de conexión",
				JOptionPane.ERROR_MESSAGE);
	}

}
