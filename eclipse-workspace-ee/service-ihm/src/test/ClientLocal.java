package test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class ClientLocal {

	public static void main(String[] args) {
		
		String REST_URI = "http://172.17.0.3:8080/service_restful";
		Client client = ClientBuilder.newClient();

		String resultat = client
        .target(REST_URI)
        .path("infos")
        .path("12345")
        .request(MediaType.TEXT_PLAIN)
        .get(String.class);
		
		System.out.println(resultat);
	}

}
