package student.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import student.examples.domain.Category;
import student.examples.domain.Currency;
import student.examples.domain.Money;
import student.examples.domain.Product;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("e-shop-main");
        EntityManager em = emf.createEntityManager();

        Category category_1 = new Category("Smartphones");
        Currency currencyUsd = new Currency("US Dollar", "USD", 840, 18.1553f);
        Product product_1 = new Product("Samsung XXII", "image 1.jpg");
        Money moneyProduct_1 = new Money(1000, currencyUsd.getCharCode());
        product_1.setPrice(moneyProduct_1);
        // moneyProduct_1.setProduct(product_1);
        // product_1.getPrice().add(moneyProduct_1);
        product_1.setCategory(category_1);

        em.getTransaction().begin();
        em.persist(category_1);
        em.persist(currencyUsd);
        em.persist(product_1);
        em.persist(moneyProduct_1);
        em.getTransaction().commit();
    }
}