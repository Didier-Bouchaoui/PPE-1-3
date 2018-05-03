package modele;

import java.util.Date;

public class Evaluation {

	private double note;
	private String appreciation;
	private Date date;
	private Matiere matiere;

	public Evaluation() {
		super();

	}

	public Evaluation(double note, String appreciation, Date date, Matiere matiere) {
		super();
		this.note = note;
		this.appreciation = appreciation;
		this.date = date;
		this.matiere = matiere;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Evaluation [note=" + note + ", appreciation=" + appreciation + ", date=" + date + ", matiere=" + matiere
				+ "]";
	}

}
