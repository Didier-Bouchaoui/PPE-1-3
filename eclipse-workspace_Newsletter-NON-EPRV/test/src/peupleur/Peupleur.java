package peupleur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Abonne;

public class Peupleur {
	
	public static void main(String args[]) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Abonne a1 = new Abonne("Mme","DURAND", "Isabelle", "isabelle.durand@open&freesoftware.com", "COMPTBILITE");
		Abonne a2 = new Abonne("Mme","DUPONT", "Catherine", "catherine.dupont@open&freesoftware.com", "MARKETING");
		Abonne a3 = new Abonne("M.","ABELLARD", "Jack", "jabellard@open&freesoftware.com", "INFORMATIQUE");
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.flush();
		
		em.getTransaction().commit();
		em.close();
		emf.close();		
	}	
}