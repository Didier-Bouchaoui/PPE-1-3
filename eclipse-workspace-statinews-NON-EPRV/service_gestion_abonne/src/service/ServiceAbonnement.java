package service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;
import dto.AbonnesDTO;
import modele.Abonne;
import persistance.FournisseurDeGerantDePersistance;

@Path("/abonnes")
public class ServiceAbonnement {

	@GET
	@Path("/dto")
	@Produces(MediaType.APPLICATION_XML)
	public AbonnesDTO methode() {			

		AbonnesDTO retourDTO = new AbonnesDTO();
		
		if(!restaurer(retourDTO))
			retourDTO.setMessage("impossible de restaurer les objets abonnés");
		
		return retourDTO;
			
	}

	private boolean restaurer(AbonnesDTO retourDTO) {
	
		EntityManager em = null;
		try {
			em = FournisseurDeGerantDePersistance.getInstance().fournir();
			em.getTransaction().begin();
		
			List<Abonne> resultat = em.createNativeQuery("SELECT * FROM TABON", Abonne.class).getResultList();
			constructeurAbonne(resultat, retourDTO);
			
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			em.close();
		}
	}

	private AbonnesDTO constructeurAbonne(List<Abonne> resultat, AbonnesDTO retourDTO) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		for(Abonne iter: resultat)
			retourDTO.getAbonnes().add(new AbonneDTO(iter.getCivilite(), iter.getNom(), iter.getPrenom(), iter.getCourriel(), iter.getService(), df.format(iter.getDateabon()), null));
		
		return retourDTO;
	}
}