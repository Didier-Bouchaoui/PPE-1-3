package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Creation {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory ("jpa02");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();

	}

}
