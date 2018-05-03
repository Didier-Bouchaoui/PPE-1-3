package service;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;
import modele.Abonne;
import persistance.FournisseurDeGerantDePersistance;

@Path("/abonnement")
public class ServiceAbonnement {

	@POST
	@Path("/dto")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public AbonneDTO methode(AbonneDTO entree) {

		AbonneDTO retour = new AbonneDTO();
		String email = entree.getCourriel();

		if (email.substring(email.lastIndexOf('@') + 1)=="open&freesoftware.com")
			if (enregistrer(constructeurAbonne(entree))) {
				retour.setNom(entree.getNom());
				retour.setPrenom(entree.getPrenom());
				retour.setMessage("Bienvenue, vous êtes maintenant abonné-e à la newsletter [Open&Free Software Inc.]");
			} else
				retour.setMessage(
						"Un incident est survenu qui rend votre abonnement impossible [Open&Free Software Inc.]");

	else

	{

		retour.setMessage("Adresse email non valide");
	}

	return retour;

}

	

	private boolean enregistrer(Abonne nouveau) {
		EntityManager em = null;
		try {
			em = FournisseurDeGerantDePersistance.getInstance().fournir();
			em.getTransaction().begin();
			em.persist(nouveau);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	private Abonne constructeurAbonne(AbonneDTO entree) {
		return new Abonne(entree.getNom(), entree.getPrenom(), entree.getCourriel());
	}
}