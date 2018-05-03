package proceduresstockees;

import javax.persistence.*;

public
class
TestProcedureStockee {
	public
	static
	void
	main(String[] 
			args
			) {
		EntityManagerFactory 
		emf
		= Persistence.
		createEntityManagerFactory
		(
				"abo"
				);
		EntityManager 
		em
		= 
		emf
		.createEntityManager();
		em
		.getTransaction().begin();
		StoredProcedureQuery 
		procedure
		= 
		em
		.createStoredProcedureQuery(
				"statsfh"
				);
		procedure
		.registerStoredProcedureParameter(
				"nb_femmes"
				, Integer.
				class
				, ParameterMode.
				OUT
				);
		procedure
		.registerStoredProcedureParameter(
				"nb_hommes"
				, Integer.
				class
				, ParameterMode.
				OUT
				);
		procedure
		.execute();
		System.
		out
		.println(
				procedure
				.getOutputParameterValue(
						"nb_femmes"
						));
		System.
		out
		.println(
				procedure
				.getOutputParameterValue(
						"nb_hommes"
						));
		em
		.getTransaction().commit();
		em
		.close();
		emf
		.close();
	}
}