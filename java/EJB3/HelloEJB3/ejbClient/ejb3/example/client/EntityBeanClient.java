package ejb3.example.client;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb3.example.simpleentity.Item;
import ejb3.example.simpleentity.Order;
import ejb3.example.simpleentity.ShoppingCart;
import ejb3.example.simpleentity.ShoppingCartDAO;

public class EntityBeanClient {

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

			System.out.println("Buying Cake");
			cart.buy("Cake", 1, 3.9);

			System.out.println("Buying Bread");
			cart.buy("Bread", 1, 2.9);

			System.out.println("Buying Cake");
			cart.buy("Cake", 2, 7.5);

			System.out.println("Checkout");
			cart.checkout();

			ShoppingCartDAO cartDAO = (ShoppingCartDAO) ctx
					.lookup("ShoppingCartDAOBean/remote");

			System.out.println("*******************************");
			System.out.println("Print total order list on client:");
			List<Order> orders = cartDAO.loadAllOrders();
			for (Iterator<Order> iter = orders.iterator(); iter.hasNext();) {
				Order order = (Order) iter.next();
				for (Item item : order.getItems()) {
					System.out.println("Item:" + item.getProduct() + " Price:"
							+ item.getPrice());
				}
				System.out.println("Order id:" + order.getId()
						+ " Total Price: " + order.getTotal());
			}

			System.out.println("*******************************");
			System.out.println("Print cake order list on client:");

			List<Item> orderList = cartDAO.findByProduct("Cake");
			for (Iterator<Item> iter = orderList.iterator(); iter.hasNext();) {
				Item element = (Item) iter.next();
				System.out.println(element.getProduct() + " "
						+ element.getQuantity() + " " + element.getPrice());
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

}
