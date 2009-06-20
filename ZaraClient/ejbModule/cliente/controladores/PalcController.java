package cliente.controladores;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.swing.JFileChooser;

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
import cliente.XML.ParseXML;
import cliente.modelo.ZaraModel;
import cliente.vistas.VistaListadoPALC;
import cliente.vistas.VistaPALC;
import cliente.vistas.VistaRecEnvT;
import cliente.vistas.VistaUtils;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class PalcController extends Controlador {

	public PalcController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		cargaPALC();
	}

	public Date checkPALC(String hash) {
		return ((ZaraModel) this.getModelo()).getFachada()
				.checkPedidoExistente(hash);
	}

	public void cargaPALC() {
		Collection<PalcPropuestoVO> palc = ((ZaraModel) this.getModelo())
				.getFachada().getPALC();
		((VistaPALC) this.getVista()).cargarDatos(palc);
	}

	public void registraPALC() {

		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(((VistaPALC) this.getVista()).getVistaGrafica());
		File selFile = fc.getSelectedFile();

		if (selFile != null) {

			Collection<ItemPALCVO> articulos = ((VistaPALC) this.getVista())
					.getArticulosElegidos();
			
			PALCVO palc = new PALCVO();
			palc.setArticulos(articulos);
			palc.setEstado("Emitido");
			palc.setFecha(Calendar.getInstance().getTime());

			int idPedido = ((ZaraModel) this.getModelo()).getFachada()
					.registraPALC(palc);

			if (idPedido != 0) {

				VistaListadoPALC vista = VistaListadoPALC
						.getInstance((ZaraModel) this.getModelo());
				new ListadoPalcController(this.getModelo(), vista, palc);
				palc.setId(idPedido);

				try {
					ParseXML.generaPALC(selFile.getAbsolutePath(), palc);
				} catch (Exception e) {
					VistaUtils.showErrorPopup(((VistaPALC) this.getVista())
							.getVistaGrafica(),
							"Se ha producido un error al guardar el XML");
				}
			} else {
				VistaUtils.showErrorPopup(((VistaPALC) this.getVista())
						.getVistaGrafica(),
						"Se ha producido un error al persistir los datos");
			}
		}

	}

	public void cerrar() {
		((VistaPALC) this.getVista()).cerrar();
	}

	public void agregaArticulo(Long ref) {		
			PalcPropuestoVO palc = ((ZaraModel) this.getModelo()).getFachada().getPALC(ref);
			
			if (palc == null) {
				VistaUtils.showErrorPopup(((VistaPALC) this.getVista()).getVistaGrafica(), "El artículo ingresado no existe");
			} else {			
				((VistaPALC) this.getVista()).cargarDatos(palc);
			}
	}

	public void showNumericoPopup() {
		VistaUtils.showErrorPopup(((VistaPALC) this.getVista()).getVistaGrafica(), "El nro de referencia debe ser numérico");
	}

	public void showExistentePopup() {
		VistaUtils.showErrorPopup(((VistaPALC) this.getVista())
				.getVistaGrafica(),
				"El artículo ingresado ya figura en el PALC sugerido");
	}

}
