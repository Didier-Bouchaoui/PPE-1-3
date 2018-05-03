package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import ressources.Civilite;
import ressources.Service;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder= {
		"civilite",
		"nom",
		"prenom",
		"courriel",
		"service",
		"message"
})

@XmlRootElement
public class AbonneDTO {

	@XmlElement(required=true)
	private Civilite civilite;
	private String nom;
	private String prenom;
	private String courriel;
	@XmlElement(required=true)
	private Service service;
	private String message;

	public AbonneDTO() {
		super();
	}

	public AbonneDTO(Civilite civilite, String nom, String prenom, String courriel, Service service, String message) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.courriel = courriel;
		this.service = service;
		this.message = message;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
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
		return "AbonneDTO [civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", courriel=" + courriel
				+ ", service=" + service + ", message=" + message + "]";
	}

}