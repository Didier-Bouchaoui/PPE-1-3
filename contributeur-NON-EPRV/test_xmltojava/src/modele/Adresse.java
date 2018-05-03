package modele;

public class Adresse {

	private String voie;
	private String specialisation;
	private String codepostal;
	private String ville;
	private String pays;

	public Adresse() {
		super();
	}

	public Adresse(String voie, String specialisation, String codepostal, String ville, String pays) {
		super();
		this.voie = voie;
		this.specialisation = specialisation;
		this.codepostal = codepostal;
		this.ville = ville;
		this.pays = pays;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Adresse [voie=" + voie + ", specialisation=" + specialisation + ", codepostal=" + codepostal
				+ ", ville=" + ville + ", pays=" + pays + "]";
	}

}

