package controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;

@WebServlet(urlPatterns={"/ihm"}, loadOnStartup=1)
public class ControleurWeb extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String REST_URI = "http://service:8080/service-abonnement/newsletter";	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse rep) throws IOException {
		
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String courriel = req.getParameter("courriel");
		AbonneDTO envoi = new AbonneDTO(nom, prenom, courriel, null);
		
		
		Client client = ClientBuilder.newClient();
		AbonneDTO retour = client
				 .target(REST_URI)
				 .path("abonnement")
				 .path("dto")
				 .request(MediaType.APPLICATION_XML)
				 .post(Entity.entity(envoi, MediaType.APPLICATION_XML), AbonneDTO.class);
		

		PrintWriter sortie = rep.getWriter();
		 try {
	         
			 	sortie.println("<html>");
			 	sortie.println("<head>");
			 	sortie.println("</head>");
			 	sortie.println("<body>");
			 	sortie.println("<title>Inscription Newsletter</title>"); 
			 	sortie.println("<fieldset>");
			 	sortie.println("<h1>" + retour.getMessage() + "<h1>");
			 	sortie.println("</fieldset>");
			 	sortie.println("</body>");
			 	sortie.println("</html>");
			 	
	        } finally {
	            sortie.close();
	        }
	}
	
	
	
	
	
	
	}

