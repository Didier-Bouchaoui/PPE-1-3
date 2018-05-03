package peuplement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Abonne;

public class Peupleur {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Abonne a1 = new Abonne("Mme", "DUPONT", "Isabelle", "isabelle.dupont@open&freesoftware.com", "DIRECTION");
		Abonne a2 = new Abonne("M.", "DURAND", "Pierre", "pdurand@open&freesoftware.com", "INFORMATIQUE");
		
		em.persist(a1);
		em.persist(a2);
			
		em.getTransaction().commit();
		em.close();
        emf.close();
	}

}