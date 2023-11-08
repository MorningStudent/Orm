package store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100)
	private String name;
	
	@OneToOne(mappedBy = "client")
	private Address address;

	public Client() {
	
	
	}
	
}
