/*
 * Ingeniería en sistemas 2
 * TP Tienda Zara - Grupo 13
 * 
 * Integrantes:
 * Gabriel Schammah
 * Maximiliano Landivar
 */
package cliente.controladores;

import server.VO.ventas.VentaVO;
import cliente.vistas.VistaFactura;
import framework.controlador.Controlador;
import framework.modeloCliente.ProxyModelo;
import framework.vista.Vista;

public class FacturaController extends Controlador {

	public FacturaController(ProxyModelo mod, Vista vis) {
		super(mod, vis);
	}
	
	public void setData(VentaVO venta){
		

		((VistaFactura) this.getVista()).agregarInfo(venta);
		
		
		
		
	}
		
	public void cerrar(){
		((VistaFactura)this.getVista()).cerrar();
	}

}
