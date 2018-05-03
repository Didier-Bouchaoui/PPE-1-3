package peuplement;

import java.util.Date;

import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;

import modele.Etudiant;
import modele.EtudiantImpl;
import modele.Evaluation;
import modele.Matiere;

public class Test01 {

	public static void main(String[] args) {
		
	
		ObjectContainer conteneur = null;
		
				conteneur = Db4oClientServer.openClient("172.17.0.2", 4448, "db4o", "db4o");
				
				
				Matiere Fr = new Matiere ("Francais",3);
				Matiere Ma = new Matiere ("Mathematiques",4);
				Matiere SL3 = new Matiere ("SLAM 3",5);
				Matiere PPE = new Matiere ("PPE",4);
				Matiere Si = new Matiere ("Si7",5);
				Matiere Ang = new Matiere ("Anglais",3);
				
				
				
				Etudiant e1 = new EtudiantImpl("12345", "DUPONT", "Pierre");
				e1.addEvaluation(new Evaluation(12.00, "moyen", new Date(),Si));
				e1.addEvaluation(new Evaluation(16.00, "très bien", new Date(), SL3));
				e1.addEvaluation(new Evaluation(14.00, "assez bien", new Date(), Si));
				e1.addEvaluation(new Evaluation(10, "juste", new Date(),Ang));
								
				
				Etudiant e2 = new EtudiantImpl("23456", "DURAND", "Isabelle");
				e2.addEvaluation(new Evaluation(11, "moyen", new Date(),PPE));
				e2.addEvaluation(new Evaluation(18, "très bien", new Date(),Ma));
				e2.addEvaluation(new Evaluation(13, "assez bien", new Date(),Fr));
				e2.addEvaluation(new Evaluation(16, "très bien", new Date(),Si));
				
				conteneur.store(e1);
				conteneur.store(e2);
				
				conteneur.commit();
				conteneur.close();

	}

}
