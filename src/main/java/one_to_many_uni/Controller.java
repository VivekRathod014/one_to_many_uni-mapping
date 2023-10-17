package one_to_many_uni;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Controller {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vivek");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = new Person();
		person.setName("vishal");
		person.setEmail("vishal@gmail.com");
		person.setGender("male");
		
		Account account1 = new Account();
		account1.setAccount_no(0123456);
		account1.setBank_name("HDFC");
		account1.setIfsc_code("HDFC123");
		
		Account account2 = new Account();
		account2.setAccount_no(345677);
		account2.setBank_name("Axis");
		account2.setIfsc_code("AXIS1234");
		
		
		Account account3 = new Account();
		account3.setAccount_no(9876543);
		account3.setBank_name("ICICI");
		account3.setIfsc_code("ICICI0123");
		
		
		
		ArrayList<Account>accounts = new ArrayList<Account>();
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		person.setAccounts(accounts);
		
		
		entityTransaction.begin();
		entityManager.persist(person);
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);
		entityTransaction.commit();
	}

}
