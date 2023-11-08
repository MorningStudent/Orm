package finance.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Money {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Double value;
	
	@ManyToOne
	private Currency currency;

	public Money() {
		
	}

	public Money(Double value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}
	
	public Integer getId() {
		return id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Money [id=" + id + ", value=" + value + ", currency=" + currency.getCode() + "]";
	}
	
}
