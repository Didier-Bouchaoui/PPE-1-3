package test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import dto.AbonneDTO;
import dto.AbonnesDTO;

public class ClientREST {

	public static void main(String[] args) {
		
		String REST_URI = "http://172.17.0.4:8080/service_gestion_abonnes";
		List<AbonneDTO> abonnes = new ArrayList<AbonneDTO>();
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

}
