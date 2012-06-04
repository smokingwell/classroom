package ejb3.example.simpleentity;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote(ShoppingCartDAO.class)
public class ShoppingCartDAOBean implements ShoppingCartDAO {
	
	@PersistenceContext(unitName="entityexample")
	private EntityManager manager;
	
	public List<Item> findByProduct(String product) {
		return manager.createQuery("from Item o where o.product = :product")
		.setParameter("product", product).getResultList();
	}

	public List<Order> loadAllOrders() {
		return manager.createQuery("from Order").getResultList();
	}

}
