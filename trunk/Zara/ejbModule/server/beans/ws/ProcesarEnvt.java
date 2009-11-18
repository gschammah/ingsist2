package server.beans.ws;

import javax.ejb.Remote;

@Remote
public interface ProcesarEnvt {
	
	public boolean recibirEnvt(vo.EnvtVO vo);

}
