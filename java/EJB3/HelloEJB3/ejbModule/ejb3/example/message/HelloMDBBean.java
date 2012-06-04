package ejb3.example.message;

import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
	@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Topic"), 
	@ActivationConfigProperty(propertyName="destination", propertyValue="topic/jms/HelloMDBTopic")
	})
public class HelloMDBBean implements MessageListener {

	public HelloMDBBean() {
		System.out.println("Local Server initialized on HelloMDBBean");
	}
	
	public void onMessage(Message arg) {
		if ( arg instanceof TextMessage) {
			TextMessage tm = (TextMessage)arg;
			try {
				System.out.println("Local Server HelloMDBBean received message: " + tm.getText());
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}

	}
	
	@PreDestroy
	public void remove(){
		System.out.println("Local Server HelloMDBBean destroyed");
	}

}
