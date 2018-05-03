package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.DAO;
import dao.DAOImpl;
import modele.Etudiant;

@Path("/{infos}")
public class ServiceInformation {	
	
	public ServiceInformation() {
		super();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
	@Path("{matricule}")
	public String moyenne(@PathParam("matricule") String matricule) {
		
		DAO dao = new DAOImpl();
		Etudiant resultat = dao.trouver(matricule);
		if(resultat != null)
			return resultat.infos();
		
		return "étudiant introuvable";
	}	
}
