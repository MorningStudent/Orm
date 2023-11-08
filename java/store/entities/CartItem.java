package store.entities;

import finance.entities.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Product product;
	
	private Integer quantity;
	
	@ManyToOne
	private Cart cart;
	
	@OneToOne
	private Money totalCost;
	

	public CartItem() {
	
	}
	
}
