package tools;

import weblc.WSLCBean;
import weblc.WSLCBeanServiceLocator;

public class WSPalc {

	public static void enviarPalc(String xml) throws Exception {
		
		WSLCBeanServiceLocator serviceLocator = new WSLCBeanServiceLocator();
		
		serviceLocator.setWSLCBeanPortEndpointAddress(Messages.getString("WSPalc.URL")); //$NON-NLS-1$
				
		WSLCBean port = serviceLocator.getWSLCBeanPort();		
		//Invocación del Web Service
		if (!port.recibirPALCweb(xml)) {
			throw new Exception("error_ws_palc"); //$NON-NLS-1$
		}			
					
	}
	
}
