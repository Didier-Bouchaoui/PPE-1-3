package controleur;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ressources.Civilite;

@ManagedBean(name="abo")
@RequestScoped
public class ControleurAbonne {
	
	private String nom;
	private String prenom;
	private String courriel;
	private Civilite[] civilites = Civilite.values();
	
	public ControleurAbonne() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public Civilite[] getCivilites() {
		return civilites;
	}

	public void setCivilites(Civilite[] civilites) {
		this.civilites = civilites;
	}
	
	
}
