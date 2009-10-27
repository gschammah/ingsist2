package server.beans.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import server.VO.OfAD.OfADVO;
import server.beans.fachada.Fachada;
import tools.ParseXML;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination", propertyValue="queue/ColaOfad")
})

public class ProcesarOfadBean implements MessageListener {
	
	@EJB(name="ZaraEAR/FachadaBean/local") 
    Fachada fachada;

	public void onMessage(Message mensaje) {
		
		TextMessage msg = null;
		
		try {
			if (mensaje instanceof TextMessage) {
				msg = (TextMessage) mensaje;
				String ofadXML = msg.getText();
				
				OfADVO vo = ParseXML.parseOfAD(ofadXML);
				fachada.nuevoOfad(vo, true);
			} 
				
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
