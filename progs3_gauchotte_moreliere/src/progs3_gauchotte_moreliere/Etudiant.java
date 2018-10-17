package progs3_gauchotte_moreliere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Classe representant un etudiant
 * @author moreliere & Gauchotte
 *
 */
public class Etudiant {
	/**
	 * Identite de l'etudiant en cours
	 */
	private Identite id;
	/**
	 * Formation de l'etudiant
	 */
	private Formation formation;
	/**
	 * Tableau qui a une matiere associe la liste de notes
	 */
	private HashMap<String, ArrayList<Integer>> resultats;
	
	/**
	 * Constructeur d'un etudiant
	 * @param num numero nip de l'etudiant
	 * @param n nom de l'etudiant
	 * @param p prenom de l'etudiant
	 * @param idF numero de la formation
	 */
	public Etudiant(String num, String n,String p, Formation f) {
		id = new Identite(num, n, p);
		formation = f;
		resultats = new HashMap<String, ArrayList<Integer>>();
	}
	
	/**
	 * Methode ajoutant une note a un etudiant
	 * @param note note recu
	 * @param matiere matiere dans laquel la note doit etre ajoute
	 */
	public void ajouterNote(int note, String matiere) {
		try {
			ArrayList<Integer> inter = resultats.get(matiere);
			if((note >= 0) && (note <= 20) && (formation.getCoefficient(matiere) != 0))
				inter.add(note);
		} catch(NullPointerException e) {
			ArrayList<Integer> inter = new ArrayList<Integer>();
			if((note >= 0) && (note <= 20) && (formation.getCoefficient(matiere) != 0))
				inter.add(note);
			resultats.put(matiere, inter);
		}
		
	}
	
	/**
	 * Calculer la moyenne pour une matiere donne
	 * @param matiere nom de la matiere
	 * @return moyenne de la matiere 
	 */
	public double calculerMoyenne(String matiere) {
		double res = 0;
		try {
			ArrayList<Integer> inter = resultats.get(matiere);
			for(int i : inter) {
				res += i;
			}
			res = res/inter.size();
		} catch(Exception e) {
			return res;
		}
		return res;
	}
	
	/**
	 * Methode peremettant de retourner la moyenne general de l'etudiant
	 * @return moyenne general
	 */
	public double calculerMoyenneGenerale() {
		double res = 0;
		int div = 0;
		for(String k : resultats.keySet()) {
			res += calculerMoyenne(k) * formation.getCoefficient(k);
			div += formation.getCoefficient(k);
		}
		return div!=0 ? Math.round(Math.pow(10, 2) * res/div) * Math.pow(10, -2) : 0;
	}
	
	/**
	 * Getteur de l'identite 
	 * @return l'identite de l'etudiant
	 */
	public Identite getIdentite() {
		return id;
	}
	
	/**
	 * Getteur du nom de l'etudiant
	 * @return nom de l'etudiant
	 */
	public String getNom() {
		return id.getNom();
	}
	
	/**
	 * Getteur du prenom de l'etudiant
	 * @return prenom de l'etudiant
	 */
	public String getPrenom() {
		return id.getPrenom();
	}
	
	/**
	 * Getteur du numero nip
	 * @return numero nip
	 */
	public String getNip() {
		return id.getNip();
	}
	
	/**
	 * Getteur de l'id formation de l'etudiant
	 * @return id de formation
	 */
	public int getIdFomation() {
		return formation.getId();
	}
	
	/**
	 * Getteur de la formation de l'etudiant
	 * @return Formation de l'etudiant
	 */
	public Formation getFormation() {
		return formation;
	}
	
	/**
	 * Getteur du tableau des resultats de l'etudiant
	 * @return tableau de resultats
	 */
	public HashMap<String, ArrayList<Integer>> getResultats(){
		return resultats;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formation == null) ? 0 : formation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((resultats == null) ? 0 : resultats.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (formation == null) {
			if (other.formation != null)
				return false;
		} else if (!formation.equals(other.formation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (resultats == null) {
			if (other.resultats != null)
				return false;
		} else if (!resultats.equals(other.resultats))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", resultats=" + resultats + "]";
	}
}
