package procedure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class TestProcedureStockeeNb {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("abo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		StoredProcedureQuery procedure = em.createStoredProcedureQuery("statsfh");
		procedure.registerStoredProcedureParameter("nb_femmes", Integer.class, ParameterMode.OUT);
		procedure.registerStoredProcedureParameter("nb_hommes", Integer.class, ParameterMode.OUT);
		procedure.execute();
		System.out.println(procedure.getOutputParameterValue("nb_femmes"));
		System.out.println(procedure.getOutputParameterValue("nb_hommes"));
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
