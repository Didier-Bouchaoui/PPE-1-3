package modele;

public interface Etudiant {
	
	public String infos();
	public void setMatricule(String matricule);
	public void addEvaluation(Evaluation nouvelle);
}
