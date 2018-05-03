package controleur;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;
import dto.AbonnesDTO;

@ManagedBean(name = "ctrl")
@RequestScoped
public class ControleurDesAbonnes {
	
	private final String REST_URI = "http://tomcatservicegestion:8080/service_gestion_abonne";
	private List<AbonneDTO> abonnes = new ArrayList<AbonneDTO>();
	
	private void initialiser() {		
		
		Client client = ClientBuilder.newClient();
		AbonnesDTO dto = client
		 .target(REST_URI)
		 .path("abonnes")
		 .path("dto")
		 .request(MediaType.APPLICATION_XML)
		 .get(AbonnesDTO.class);
		
		abonnes = dto.getAbonnes();
		for(AbonneDTO iter: abonnes)
			System.out.println(iter);
	}
	
	public String controler() {
		return "abonnes";
	}
	
	public ControleurDesAbonnes() {
		super();
		this.initialiser();
	}

	public List<AbonneDTO> getAbonnes() {
		return abonnes;
	}

	public void setAbonnes(List<AbonneDTO> abonnes) {
		this.abonnes = abonnes;
	}
	
	
}