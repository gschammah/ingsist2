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
		

		//((VistaFactura) this.getVista()).agregarInfo(VentaVo venta);
		
		/*
		for (Vector<Object> fila : datos) {
			
			Object[] dat = {
					Long.parseLong(fila.get(0).toString()),
					Integer.parseInt(fila.get(5).toString()),
					fila.get(2).toString(),
					Float.parseFloat(fila.get(3).toString()),
					(Float.parseFloat(fila.get(3).toString())*Integer.parseInt(fila.get(5).toString()))
			};
			
			((VistaFactura) this.getVista()).agregarInfo(dat, datosT, datosF);
			
		}
		*/
		
		
	}
		
	public void cerrar(){
		((VistaFactura)this.getVista()).cerrar();
	}

}
