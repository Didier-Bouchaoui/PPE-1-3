package modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABON")
public class Abonne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDABON")
	private int IDAbon;
	@Column(nullable = false ,name="NOM")
	private String nom;
	@Column(nullable = false ,name="PRENOM")
	private String prenom;
	@Column(nullable = false ,name="DATE_ABON")
	private Date dateabon;
	@Column(nullable = false ,unique = true , name = "COURRIEL") 
	private String courriel;

	public Abonne() {
		super();

	}

	public Abonne(int iDAbon, String nom, String prenom, Date dateabon, String courriel) {
		super();
		IDAbon = iDAbon;
		this.nom = nom;
		this.prenom = prenom;
		this.dateabon = dateabon;
		this.courriel = courriel;
	}

	public int getIDAbon() {
		return IDAbon;
	}

	public void setIDAbon(int iDAbon) {
		IDAbon = iDAbon;
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

	public Date getDateabon() {
		return dateabon;
	}

	public void setDateabon(Date dateabon) {
		this.dateabon = dateabon;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	@Override
	public String toString() {
		return "Abonne [IDAbon=" + IDAbon + ", nom=" + nom + ", prenom=" + prenom + ", dateabon=" + dateabon
				+ ", courriel=" + courriel + "]";
	}

}
