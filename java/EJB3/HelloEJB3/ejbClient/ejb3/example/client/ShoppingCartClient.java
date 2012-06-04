package ejb3.example.client;

import java.util.HashMap;
import java.util.Properties;

import javax.ejb.NoSuchEJBException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb3.example.session.stateful.ShoppingCart;

public class ShoppingCartClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShoppingCart cart = null;
		try {
			Properties props = new Properties();
			props.setProperty("java.naming.factory.initial",
					"org.jnp.interfaces.NamingContextFactory");
			props.setProperty("java.naming.provider.url", "localhost:1099");
			InitialContext ctx = new InitialContext(props);
			cart = (ShoppingCart) ctx.lookup("ShoppingCartBean/remote");
		} catch (NamingException e1) {
			e1.printStackTrace();
			return;
		}

		System.out.println("Buying 1st Cake");
		cart.buy("Cake", 1);

		System.out.println("Buying 2nd Cake");
		cart.buy("Cake", 1);

		System.out.println("Buying 1st Bread");
		cart.buy("Bread", 1);

		System.out.println("Print cart list on client:");
		HashMap<String, Integer> fullCart = cart.getCartContents();
		for (String product : fullCart.keySet()) {
			System.out.println(fullCart.get(product) + " " + product);
		}

		System.out.println("Checkout");

		cart.checkout();

		System.out
				.println("Should throw an object not found exception by invoking on cart after @Remove method");
		try {
			cart.getCartContents();
		} catch (NoSuchEJBException e) {
			System.out.println("Successfully caught no such object exception.");
		}
	}

}
