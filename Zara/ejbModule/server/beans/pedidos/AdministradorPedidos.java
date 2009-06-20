package server.beans.pedidos;

import java.util.Collection;
import java.util.Date;

import javax.ejb.Remote;
import server.VO.EnvT.EnvTVO;
import server.VO.PALC.PALCVO;
import server.VO.PALC.PalcPropuestoVO;

@Remote
public interface AdministradorPedidos {

	public EnvTVO nuevoEnvT(EnvTVO envtVO, boolean save);
	
	public Date checkPedidoExistente(String hash);
	
	public Collection<PalcPropuestoVO> getPALC();
	
	public PalcPropuestoVO getPALC(long ref);
	
	public int registraPALC(PALCVO palc);
				
}
