package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persistence.FournisseurDePersistence;

public class FournisseurDePersistence {
	

	private static FournisseurDePersistence instance = null;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("monolithique");
	
	private FournisseurDePersistence() {
		super();
	}
	
	public static FournisseurDePersistence getInstance() {
		if(instance == null)
			instance = new FournisseurDePersistence();
		
		return instance;
	}
	
	public EntityManager fournir() {
		return emf.createEntityManager();
	}
	
	
	
	
}
