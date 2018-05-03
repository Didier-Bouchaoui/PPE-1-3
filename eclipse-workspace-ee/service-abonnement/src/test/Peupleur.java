package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Abonne;

public class Peupleur {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Abonne a1 = new Abonne("DURANT", "Jacques","durant.jacques@open&freesoftware.com");

		em.persist(a1);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
