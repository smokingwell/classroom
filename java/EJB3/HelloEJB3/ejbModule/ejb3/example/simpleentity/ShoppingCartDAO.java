package ejb3.example.simpleentity;

import java.util.List;

public interface ShoppingCartDAO {
	public List<Item> findByProduct(String product);
	public List<Order> loadAllOrders();
}
