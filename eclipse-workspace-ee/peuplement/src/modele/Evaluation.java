package modele;

import java.util.Date;

public class Evaluation {

	private double note;
	private String appreciation;
	private Date date;
	private String matiere;
	private double coefficient;

	public Evaluation(double note, String appreciation, Date date, String matiere, double coefficient) {
		super();
		this.note = note;
		this.appreciation = appreciation;
		this.date = date;
		this.matiere = matiere;
		this.coefficient = coefficient;
	}

	public Evaluation() {
		super();

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

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	@Override
	public String toString() {
		return "Evaluation [note=" + note + ", appreciation=" + appreciation + ", date=" + date + ", matiere=" + matiere
				+ ", coefficient=" + coefficient + "]";
	}

}