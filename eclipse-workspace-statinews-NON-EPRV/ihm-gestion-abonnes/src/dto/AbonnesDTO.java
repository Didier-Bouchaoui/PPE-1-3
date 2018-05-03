package dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AbonnesDTO {

	private List<AbonneDTO> abonnes = new ArrayList<AbonneDTO>();

	public AbonnesDTO() {
		super();
	}

	public List<AbonneDTO> getAbonnes() {
		return abonnes;
	}

	public void setAbonnes(List<AbonneDTO> abonnes) {
		this.abonnes = abonnes;
	}

}