package tools;

import weblc.WSLCBean;
import weblc.WSLCBeanServiceLocator;

public class WSPalc {

	public static void enviarPalc(weblc.Palcvo palc) throws Exception {
		
		WSLCBeanServiceLocator serviceLocator = new WSLCBeanServiceLocator();
		
		serviceLocator.setWSLCBeanPortEndpointAddress(IPReader.getCoruniaIP("C:\\UADE\\jboss-4.2.2.GA\\server\\default\\config\\zara.cfg")); //$NON-NLS-1$
				
		WSLCBean port = serviceLocator.getWSLCBeanPort();		
		//Invocación del Web Service
		if (!port.recibirPALCweb(palc)) {
			throw new Exception("error_ws_palc"); //$NON-NLS-1$
		}			
					
	}
	
}
