package repos;

import jakarta.persistence.EntityManager;
import store.entities.Product;

public class ProductRepository extends ARepository<Product> {

	public ProductRepository(EntityManager entityManager) {
		super(entityManager, Product.class);
		
	}

	public void remove (Product product) { // <----- Some sort of overriding but,
		remove(product.getId());           // without the need to respect the original form - remove(Integer id)!
	}
	
	//... to be continued
	
}
