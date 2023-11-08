package finance.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rates")
public class Rate {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private LocalDate date;
	
	private Double value;
	
	@ManyToOne
	private Currency sourceCurrency;
	
	@ManyToOne
	private Currency targetCurrency;

	public Rate() {
		
	}

	public Rate(Double value, Currency sourceCurrency, Currency targetCurrency) {
		this.date = LocalDate.now();
		this.value = value;
		this.sourceCurrency = sourceCurrency;
		this.targetCurrency = targetCurrency;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Currency getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(Currency sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public Currency getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(Currency targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	@Override
	public String toString() {
		return "Rate [id=" + id + ", date=" + date + ", value=" + value + ", sourceCurrency=" + sourceCurrency.getCode()
				+ ", targetCurrency=" + targetCurrency.getCode() + "]";
	}
	
}
