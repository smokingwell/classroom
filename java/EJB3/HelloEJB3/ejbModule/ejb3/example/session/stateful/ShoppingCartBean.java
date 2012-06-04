package ejb3.example.session.stateful;

import java.io.Serializable;
import java.util.HashMap;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class ShoppingCartBean
 */
@SuppressWarnings("serial")
@Stateful
@Remote (ShoppingCart.class)
public class ShoppingCartBean implements Serializable{
	/**
	 * 
	 */
	private HashMap<String, Integer> cart = new HashMap<String, Integer>();

    /**
     * Default constructor. 
     */
    public ShoppingCartBean() {
    }

	public void buy(String product, int quantity) {
		if (cart.containsKey(product)) { 
			int currq = ((Integer)cart.get(product)).intValue();
				currq += quantity;
				cart.put(product, new Integer(currq)); 
			} else {
				cart.put(product, quantity);
			}
		
	}
	
	@Remove
	public void checkout() {
		System.out.println("Print cart list on server:"); 
		HashMap<String, Integer> fullCart = getCartContents();
		for(String product : fullCart.keySet()){
			System.out.println(fullCart.get(product) + " " + product);
		}
			System.out.println("Checked Out");
	}

	public HashMap<String, Integer> getCartContents() {
		return cart;
	}

}
