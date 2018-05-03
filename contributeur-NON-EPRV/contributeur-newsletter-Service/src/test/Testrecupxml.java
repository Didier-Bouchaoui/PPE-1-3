package test;

import java.io.File;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import modele.Adresse;
import modele.Contributeur;

public class Testrecupxml {

	public static void main(String[] args) {

				
				XStream xstream = new XStream(new StaxDriver());
				xstream.alias("nouveaux-contributeurs", java.util.ArrayList.class);
				xstream.alias("contributeur", Contributeur.class);
				xstream.alias("adresse", Adresse.class);
				List<Contributeur> nouveaux = (List<Contributeur>) xstream.fromXML(new File("contributeurs.xml"));
				
				ObjectContainer conteneur = null;
				
				conteneur = Db4oClientServer.openClient("172.17.0.2", 4448, "db4o", "db4o");
				
				for(Contributeur iter: nouveaux) {
					System.out.println(iter);
					conteneur.store(iter);
				}
				conteneur.commit();
				conteneur.close();
			}

		
	}


