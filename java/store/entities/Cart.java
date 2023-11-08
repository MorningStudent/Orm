package store.entities;

import java.util.HashSet;
import java.util.Set;

import finance.entities.Money;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Client client;
	
	@OneToMany(mappedBy = "cart")
	private Set<CartItem> items = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
    private CartState state = CartState.ACTIVE;
	
	@OneToOne
	private Money totalCost;

	public Cart() {
	
	}
	
	public Integer getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public Set<CartItem> getItems() {
		return items;
	}

	public CartState getState() {
		return state;
	}

	public void setState(CartState state) {
		this.state = state;
	}

	public Money getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Money totalCost) {
		this.totalCost = totalCost;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", client=" + client + ", items=" + items + ", totalCost=" + totalCost + "]";
	}
	
	public enum CartState {
		ACTIVE,
	    CANCELED,
	    COMPLETED;
	}
	
}
