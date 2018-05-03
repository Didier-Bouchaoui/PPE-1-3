package controleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@WebServlet(urlPatterns={"/moyenne"}, loadOnStartup=1)
public class ControleurWeb extends HttpServlet {
	
	private static final String REST_URI = "http://service:8080/service_restful";
	private Client client = ClientBuilder.newClient();

	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws IOException {
		
		String matricule = req.getParameter("matricule");
		
		PrintWriter sortie = rep.getWriter();
		 try {
	         
			 	sortie.println("<html>");
			 	sortie.println("<head>");
			 	sortie.println("</head>");
			 	sortie.println("<title>Moyenne de l'étudiant</title>"); 
			 	sortie.println("<body>");
			 	sortie.println("<fieldset>");
			 	sortie.println("<h1>" + obtenirLaMoyenne(matricule) + "<h1>");
			 	sortie.println("</fieldset>");
			 	sortie.println("</body>");
			 	sortie.println("</html>");
			 	
	        } finally {
	            sortie.close();
	        }
	}
	
	private String obtenirLaMoyenne(String matricule) {
		
		return client
		          .target(REST_URI)
		          .path("etudiant")
		          .path("infos")
		          .path(matricule)
		          .request(MediaType.TEXT_PLAIN)
		          .get(String.class);
	}
}




