package server.beans.ventas;

import javax.ejb.Remote;

import server.VO.ventas.VentaVO;

@Remote
public interface AdministradorVentas {
	
	public VentaVO nuevaVenta(VentaVO vo);
	
}
