package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AbonneDTO {
	private String nom;
	private String prenom;
	private String courriel;
	private String message;

	public AbonneDTO() {
		super();

	}

	public AbonneDTO(String nom, String prenom, String courriel, String message) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AbonneDTO [nom=" + nom + ", prenom=" + prenom + ", courriel=" + courriel + ", message=" + message + "]";
	}

}
