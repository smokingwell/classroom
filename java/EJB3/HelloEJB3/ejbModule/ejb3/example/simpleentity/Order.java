package ejb3.example.simpleentity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "PURCHASE_ORDER")
public class Order implements Serializable{
	private int id;
	private double total;
	private Collection<Item> items;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
	public Collection<Item> getItems() {
		return items;
	}
	
	public void setItems(Collection<Item> items) {
		this.items = items;
	}
	
	public void addPurchase(String product, int quantity, double price){
		if (items == null) items = new ArrayList<Item>();
			Item item = new Item();
			item.setOrder(this);
			item.setProduct(product);
			item.setQuantity(quantity);
			item.setPrice(quantity * price);
			items.add(item);
			total += quantity * price;
		}
}
