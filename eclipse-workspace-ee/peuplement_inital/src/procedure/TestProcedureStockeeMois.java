package procedure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class TestProcedureStockeeMois {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		StoredProcedureQuery procedure = em.createStoredProcedureQuery("croissance");
		procedure.registerStoredProcedureParameter(1, void.class, ParameterMode.REF_CURSOR);
		List<Object[]> resultats = procedure.getResultList();
		for(Object[] iter: resultats)
		System.out.println(iter[0] + " " + iter[1]);
		em.getTransaction().commit();
		em.close();
		emf.close();
		}
		

	}


