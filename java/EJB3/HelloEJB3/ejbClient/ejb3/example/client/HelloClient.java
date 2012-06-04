package ejb3.example.client;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb3.example.session.stateless.HelloEJB3;

public class HelloClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HelloEJB3 hello = null;
		try {
			Properties props = new Properties();        
	        props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
	        props.setProperty("java.naming.provider.url", "localhost:1099");
			InitialContext ctx = new InitialContext(props);
			hello = (HelloEJB3) ctx.lookup("HelloEJB3Bean/local");
			System.out.println(hello.echo("Hello EJB3, How are u doing!"));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
