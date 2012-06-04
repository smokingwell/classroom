package ejb3.example.session.stateless;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloEJB3Bean
 */

@Stateless
@Local ({HelloEJB3.class})
public class HelloEJB3Bean  {

    /**
     * Default constructor. 
     */
    public HelloEJB3Bean() {
        // TODO Auto-generated constructor stub
    }
    
    public String echo(String msg) {
    	System.out.println("Joeyta try Hello World.");
    	return msg;
    }
}
