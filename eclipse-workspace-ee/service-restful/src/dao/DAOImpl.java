package dao;

import java.util.ArrayList;
import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;

import modele.Etudiant;
import modele.EtudiantImpl;

public class DAOImpl implements DAO {
		
	public DAOImpl() {
		super();
	}

	@Override
	public Etudiant trouver(String matricule) {
		ObjectContainer conteneur = null;
		try {
				conteneur = Db4oClientServer.openClient("db4o", 4448, "db4o", "db4o");
				Etudiant patron = new EtudiantImpl();
				patron.setMatricule(matricule);
				List<Etudiant> resultat = conteneur.queryByExample(patron);
				if(resultat.size() == 1)
					return resultat.get(0);
			
				return null;
	} catch (Exception e) {e.printStackTrace();
							return null;       }
	finally {
		conteneur.close();			
	}
	}
	
	@Override
	public List<Etudiant> restaurer() {
		ObjectContainer conteneur = null;
		try {
				conteneur = Db4oClientServer.openClient("db4o", 4448, "db4o", "db4o");
				List<Etudiant> etudiants = conteneur.queryByExample(Etudiant.class);
				return new ArrayList<>(etudiants);
	} catch (Exception e) {e.printStackTrace();
							return null;       }
	finally {
		conteneur.close();			
	}
	}
}
