package service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.FemmesHommesDTO;
import persistance.FournisseurDeGerantDePersistance;

@Path("/abonnes")
public class ServiceStatistiqueFemmesHommes {

	@GET
	@Path("/dto")
	@Produces(MediaType.APPLICATION_XML)
	public FemmesHommesDTO methode() {			

		FemmesHommesDTO retourDTO = new FemmesHommesDTO();
		
		if(!calculer(retourDTO))
			retourDTO.setMessage("impossible de réaliser le calcul");
		
		return retourDTO;
			
	}

	private boolean calculer(FemmesHommesDTO retourDTO) {
	
		EntityManager em = null;
		try {
			em = FournisseurDeGerantDePersistance.getInstance().fournir();
			em.getTransaction().begin();
		
			StoredProcedureQuery procedure = em.createStoredProcedureQuery("statsfemmeshommes");
			procedure.registerStoredProcedureParameter("nb_femmes", Integer.class, ParameterMode.OUT);
			procedure.registerStoredProcedureParameter("nb_hommes", Integer.class, ParameterMode.OUT);
			procedure.execute();
			
			retourDTO.setNbfemmes((Integer) procedure.getOutputParameterValue("nb_femmes"));
			retourDTO.setNbhommes((Integer) procedure.getOutputParameterValue("nb_hommes"));
			
			System.out.println("nombre de femmes: " + procedure.getOutputParameterValue("nb_femmes"));
			System.out.println("nombre d'hommes: " + procedure.getOutputParameterValue("nb_hommes"));
			
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			em.close();
		}
	}
}