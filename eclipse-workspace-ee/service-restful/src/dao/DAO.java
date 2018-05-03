package dao;

import java.util.List;

import modele.Etudiant;

public interface DAO {

	public List<Etudiant> restaurer();
	public Etudiant trouver(String matricule);
}
