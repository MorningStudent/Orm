package main;

import finance.entities.Money;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repos.ARepository;
import repos.ProductRepository;
import store.entities.Category;
import store.entities.Product;

public class Application {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("local-pg");
		EntityManager em = emf.createEntityManager();
		
		//------------------------------------------- MAIN HWs -----------------------------------------------//
		//
		//.Part 4_15 HW make a Repository ---> repos.ProductRepositorySingleton
		//.HW make a currency transformer --> finance.transformers.CurrencyTransformer
		//.HW make a Sequence Generator that increment by 10 -----> store.entities.Category
		//.HW make an Enum state for Cart and integrate it in DB by dint of Hibernate / or make Embeddable
		// (I did Embeddable in the previous project, so I decided to do an Enum)
		//.Part 13_15 HW make an Abstract Repository and Inherited Repositories for each entity from store.entities
		// |----------> repos.ARepository + repos.ProductRepository (it may be extended based on needs, and
		// it can be taken as an example for the others entities as well)


	}

}
