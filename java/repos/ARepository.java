package repos;

import jakarta.persistence.EntityManager;

public abstract class ARepository<T> {
	
	private EntityManager entityManager;
	private Class<T> type;
	
	protected ARepository(EntityManager entityManager, Class<T> type) {
		this.entityManager = entityManager;
		this.type = type;
	}
	
	public void create (T entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
	}
	
	public T find (Integer id) {
		T entity = null;
		entityManager.getTransaction().begin();
		entity = entityManager.find(type, id);
		entityManager.getTransaction().commit();
		return entity;
	}
	
	public void update (T entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}
	
	public void remove (Integer id) {
		entityManager.getTransaction().begin();
		T entityToRemove = entityManager.find(type, id);
		entityManager.remove(entityToRemove);
		entityManager.getTransaction().commit();
	}
	
	
}
