package client;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

public class ClientPourTestApartirEclipse {

	public static void main(String[] args) throws IOException {


		byte[] flux = Files.readAllBytes(Paths.get("contributeurs.xml"));		
		String xml = new String(flux, Charset.defaultCharset());
		System.out.println(xml);
		Client client = ClientBuilder.newClient();
		WebTarget cible = client.target(UriBuilder.fromPath("http://172.17.0.7:8080/service-enregistrement-nouveaux-contributeurs"));
		WebTarget ciblefinale = cible.path("xml");
		Response reponse = ciblefinale.request(MediaType.TEXT_PLAIN_TYPE).post(Entity.entity(xml, MediaType.TEXT_PLAIN));
		if(reponse.getStatus() == 200) System.out.println("enregistrement réussi");
		else System.out.println("échec de l'enregistrement");		
	}

}
