package peuplement;

import java.util.Date;

import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;

import modele.Etudiant;
import modele.EtudiantImpl;
import modele.Evaluation;

public class Test01 {

	public static void main(String[] args) {
		
	
		ObjectContainer conteneur = null;
		
				conteneur = Db4oClientServer.openClient("172.17.0.2", 4448, "db4o", "db4o");
				
				Etudiant e1 = new EtudiantImpl("12345", "DUPONT", "Pierre");
				e1.addEvaluation(new Evaluation(12, "moyen", new Date(), "système UNIX",2));
				e1.addEvaluation(new Evaluation(16, "très bien", new Date(), "bases de données",3));
				e1.addEvaluation(new Evaluation(14, "assez bien", new Date(), "composants logiciels",1));
				e1.addEvaluation(new Evaluation(10, "juste", new Date(), "anglais",2));
								
				
				Etudiant e2 = new EtudiantImpl("23456", "DURAND", "Isabelle");
				e2.addEvaluation(new Evaluation(11, "moyen", new Date(), "système UNIX",2));
				e2.addEvaluation(new Evaluation(18, "très bien", new Date(), "bases de données",3));
				e2.addEvaluation(new Evaluation(13, "assez bien", new Date(), "composants logiciels",3));
				e2.addEvaluation(new Evaluation(16, "très bien", new Date(), "anglais",1));
				
				conteneur.store(e1);
				conteneur.store(e2);
				
				conteneur.commit();
				conteneur.close();

	}

}
