package store.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.AUTO, // <----- Here should be GenerationType.SEQUENCE for GenerationType.AUTO
	        generator = "categories_seq"
	)
//	@SequenceGenerator(
//			name = "categories_seq",
//	        allocationSize = 10
//	)
	private Integer id;
	
	@Column(name = "title", length = 100)
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products = new ArrayList<>();
	
	@ManyToOne
	private Category parent;
	
	@OneToMany(mappedBy = "parent")
	private Set<Category> subCategories = new HashSet<>();
	
	public Category() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", products=" + products + "]";
	}

//	@Override
//	public String toString() {
//		String ps = "";
//		for (Product product : products) {
//			ps += product;
//		}
//		return "Category [id=" + id + ", name=" + name + "]\n" + ps;
//	}
	
	
	
	
}
