package modele;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

import persistence.FournisseurDePersistence;

@ManagedBean
@RequestScoped
@Entity

public class Produit {
	@Id
	@GeneratedValue
	private int idproduit;
	@Column(nullable = false)
	private String designation;
	@Column(nullable = false)
	private double prix;

	public Produit(int idproduit, String designation, double prix) {
		super();
		this.idproduit = idproduit;
		this.designation = designation;
		this.prix = prix;
	}

	public Produit() {
		super();

	}

	public int getIdproduit() {
		return idproduit;
	}

	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	public void enregistrer() {
		EntityManager em = FournisseurDePersistence.getInstance().fournir();
		em.getTransaction().begin();
		em.persist(this);
		
		
	}
	
	
	
	
}
