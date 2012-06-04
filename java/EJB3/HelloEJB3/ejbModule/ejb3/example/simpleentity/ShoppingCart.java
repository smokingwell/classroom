package ejb3.example.simpleentity;

public interface ShoppingCart {
	public void buy(String product, int quantity, double price);
	public Order getOrder();
	public void checkout();
}
