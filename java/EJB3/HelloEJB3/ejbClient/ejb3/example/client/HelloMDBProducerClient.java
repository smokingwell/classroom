package ejb3.example.client;

import java.util.Properties;

import javax.annotation.PreDestroy;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloMDBProducerClient {
	
	public HelloMDBProducerClient() {
		Properties props = new Properties();        
        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
        props.setProperty("java.naming.provider.url", "localhost:1099");
		try {
			InitialContext ctx = new InitialContext(props);
			ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
			
			Connection conn = factory.createConnection();
			
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Topic topic = (Topic) ctx.lookup("topic/jms/HelloMDBTopic");
			
			MessageProducer producer = session.createProducer(topic);
			
			TextMessage msg = session.createTextMessage();
			msg.setText("Hello, this is my first JMS message.");
			producer.send(msg);
			
			producer.close();
			
			System.out.println("Message produced!");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new HelloMDBProducerClient();
	}
	
	
}
