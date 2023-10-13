package student.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import student.examples.domain.Address;
import student.examples.domain.Cart;
import student.examples.domain.CartItem;
import student.examples.domain.Category;
import student.examples.domain.Client;
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
        Client client = new Client("Marry Poppins");
        client.getContactPhones().add("+334455667788");
        client.getContactPhones().add("+445544332244");
        Address address = new Address("New York", "88", "11/a");
        Cart cart = new Cart();
        CartItem cartItem = new CartItem(product_1, 1);
        cart.getCartItems().add(cartItem);
        client.getCarts().add(cart);
        client.getAddresses().add(address);
        product_1.setPrice(moneyProduct_1);
        product_1.setCategory(category_1);

        em.getTransaction().begin();
        em.persist(category_1);
        em.persist(currencyUsd);
        em.persist(product_1);
        em.persist(moneyProduct_1);
        em.persist(client);
        //em.persist(address); <-----| with combination of @ElementCollection and @Embeddable, we don't need to persist
        em.persist(cart);     //     | the @Embeddable, otherwise we have an error called
        em.persist(cartItem); //     | "UnknownEntityTypeException: Unable to locate persister"
        em.getTransaction().commit();



    }
}