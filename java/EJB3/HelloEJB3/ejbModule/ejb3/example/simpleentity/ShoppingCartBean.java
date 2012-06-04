package ejb3.example.simpleentity;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("serial")
@Stateful
@Remote(ShoppingCart.class)
public class ShoppingCartBean implements ShoppingCart, Serializable{

	@PersistenceContext( unitName = "entityexample")
	private EntityManager manager;
	
	private Order order;
	
	public void buy(String product, int quantity, double price) {
		if (null == order) order = new Order();
		order.addPurchase(product, quantity, price);
	}

	@Remove
	public void checkout() {
		manager.persist(order);
		System.out.print("Checked out");
		for (Item item: order.getItems()){
			System.out.print("Item:" + item.getProduct()+ " Price:" + item.getPrice());
		}
	}

	public Order getOrder() {
		return order;
	}

}
