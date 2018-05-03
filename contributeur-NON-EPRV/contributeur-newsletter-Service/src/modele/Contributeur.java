package modele;

public class Contributeur {
	
	private String nom;
	private String prenom;
	private String Courriel;
	private int mobile;
	private int fixe;
	private String specialite;
	
	
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
		return Courriel;
	}
	public void setCourriel(String courriel) {
		Courriel = courriel;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public int getFixe() {
		return fixe;
	}
	public void setFixe(int fixe) {
		this.fixe = fixe;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Contributeur() {
		super();
	}
	public Contributeur(String nom, String prenom, String courriel, int mobile, int fixe, String specialite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		Courriel = courriel;
		this.mobile = mobile;
		this.fixe = fixe;
		this.specialite = specialite;
	}
	public Contributeur(String string, String string2, String string3, String string4, String string5, String string6,
			Adresse adresse) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Contributeur [nom=" + nom + ", prenom=" + prenom + ", Courriel=" + Courriel + ", mobile=" + mobile
				+ ", fixe=" + fixe + ", specialite=" + specialite + "]";
	}
	

}
