package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FemmesHommesDTO {

	private int nbfemmes;
	private int nbhommes;
	private String message;

	public FemmesHommesDTO() {
		super();
	}

	public FemmesHommesDTO(int nbfemmes, int nbhommes, String message) {
		super();
		this.nbfemmes = nbfemmes;
		this.nbhommes = nbhommes;
		this.message = message;
	}

	public int getNbfemmes() {
		return nbfemmes;
	}

	public void setNbfemmes(int nbfemmes) {
		this.nbfemmes = nbfemmes;
	}

	public int getNbhommes() {
		return nbhommes;
	}

	public void setNbhommes(int nbhommes) {
		this.nbhommes = nbhommes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}