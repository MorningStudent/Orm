package repos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import store.entities.Product;

public class ProductRepositorySingleton {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private static ProductRepositorySingleton instance;
	
	public static ProductRepositorySingleton getInastance() {
        if(instance == null) {
            instance = new ProductRepositorySingleton();
            instance.entityManagerFactory = Persistence.createEntityManagerFactory("local-pg");
            instance.entityManager = instance.entityManagerFactory.createEntityManager();
        }
        return instance;

    }
	
	private ProductRepositorySingleton() {
		
	}
	
	public void create (Product product) {
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
	}
	
	public Product find (Integer id) {
		Product product = null;
		entityManager.getTransaction().begin();
		product = entityManager.find(Product.class, id);
		entityManager.getTransaction().commit();
		return product;
	}
	
	public void update (Product product) {
		entityManager.getTransaction().begin();
		entityManager.merge(product);
		entityManager.getTransaction().commit();
	}
	
	public void remove (Product product) {
		Product productToRemove = entityManager.find(Product.class, product.getId());
		entityManager.getTransaction().begin();
		entityManager.remove(productToRemove);
		entityManager.getTransaction().commit();
	}
	
}
