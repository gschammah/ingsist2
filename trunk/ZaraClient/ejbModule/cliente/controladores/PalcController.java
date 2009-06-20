package cliente.controladores;

import java.io.File;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.swing.JFileChooser;

import server.VO.PALC.ItemPALCVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;
import cliente.modelo.ZaraModel;
import cliente.tools.ParseXML;
import cliente.vistas.VistaListadoPALC;
import cliente.vistas.VistaPALC;
import cliente.vistas.VistaUtils;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class PalcController extends Controlador {
	
	private ZaraModel modelo;
	private VistaPALC vista;

	public PalcController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
		this.modelo = (ZaraModel) mod;
		this.vista = (VistaPALC) vis;
		cargaPALC();
	}

	public Date checkPALC(String hash) {
		return modelo.getFachada().checkPedidoExistente(hash);
	}

	public void cargaPALC() {
		Collection<PalcPropuestoVO> palc = modelo.getFachada().getPALC();
		vista.cargarDatos(palc);
	}

	public void registraPALC() {

		JFileChooser fc = new JFileChooser();
		fc.showSaveDialog(vista.getVistaGrafica());
		File selFile = fc.getSelectedFile();

		if (selFile != null) {

			Collection<ItemPALCVO> articulos = vista.getArticulosElegidos();
			
			PALCVO palc = new PALCVO();
			palc.setArticulos(articulos);
			palc.setEstado("Emitido");
			palc.setFecha(Calendar.getInstance().getTime());

			int idPedido = modelo.getFachada().registraPALC(palc);

			if (idPedido != 0) {

				VistaListadoPALC vis = VistaListadoPALC.getInstance(modelo);
				new ListadoPalcController(this.getModelo(), vis, palc);
				palc.setId(idPedido);

				try {
					ParseXML.generaPALC(selFile.getAbsolutePath(), palc);
				} catch (Exception e) {
					VistaUtils.showErrorPopup(vista.getVistaGrafica(), "Se ha producido un error al guardar el XML");
				}
			} else {
				VistaUtils.showErrorPopup(vista.getVistaGrafica(), "Se ha producido un error al persistir los datos");
			}
		}

	}

	public void cerrar() {
		vista.cerrar();
	}

	public void agregaArticulo(Long ref) {		
			PalcPropuestoVO palc = modelo.getFachada().getPALC(ref);
			
			if (palc == null) {
				VistaUtils.showErrorPopup(vista.getVistaGrafica(), "El artículo ingresado no existe");
			} else {			
				vista.cargarDatos(palc);
			}
	}

	public void showNumericoPopup() {
		VistaUtils.showErrorPopup(vista.getVistaGrafica(), "El nro de referencia debe ser numérico");
	}

	public void showExistentePopup() {
		VistaUtils.showErrorPopup(vista.getVistaGrafica(), "El artículo ingresado ya figura en el PALC sugerido");
	}

}
