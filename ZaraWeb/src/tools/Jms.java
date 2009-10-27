package tools;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Jms {

	public static void enviarPalc(String xml) throws Exception {
		Hashtable props = new Hashtable();
		
		props.put(InitialContext.INITIAL_CONTEXT_FACTORY , "org.jnp.interfaces.NamingContextFactory"); //$NON-NLS-1$
		props.put(InitialContext.PROVIDER_URL, Messages.getString("Jms.ip")); //$NON-NLS-1$
				
			
			InitialContext ctx = new javax.naming.InitialContext(props);
			
			// buscar la ConnectionFactory en JNDI
			QueueConnectionFactory qfactory = (QueueConnectionFactory) ctx.lookup("ConnectionFactory"); //$NON-NLS-1$
			
			// buscar la Cola en JNDI
			Queue queue = (Queue) ctx.lookup("queue/ColaPalc"); //$NON-NLS-1$
			
			// crear la connection y la session a partir de la connection
			QueueConnection qCon = qfactory.createQueueConnection();
			QueueSession qSession = qCon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			 
			// crear un producer para enviar mensajes usando la session
			QueueSender qSender = qSession.createSender(queue);
			
			// crear un mensaje de tipo text y setearle el contenido
			TextMessage message = qSession.createTextMessage();
			message.setText(xml);
			
			// enviar el mensaje
			qSender.send(message);
					
	}
	
}
