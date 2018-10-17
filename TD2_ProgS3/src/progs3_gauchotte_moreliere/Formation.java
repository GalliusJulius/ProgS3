package progs3_gauchotte_moreliere;

import java.util.HashMap;

/** 
 * Classe repesentant une formation 
 * @author moreliere & gauchotte
 *
 */
public class Formation {
	
	/**
	 * Associe à une matière son coefficient
	 */
	private HashMap<String,Double> matiere;
	/**
	 * Id de la formation
	 */
	private int id; 
	
	/**
	 * Constructeur d'une formation 
	 * @param i id de la formation
	 */
	public Formation(int i) {
		id = i;
		matiere = new HashMap<String,Double>();
	}
	
	/**
	 * Methode permettant d'ajouter une matiere avec son ceof a la formation
	 * @param nom de la matiere
	 * @param coef de la matiere
	 */
	public void ajouterMatiere(String nom, double coef) {
		matiere.put(nom,coef);
	}
	
	/**
	 * Methode permettant de supprimer une matiere a la formation
	 * @param nom de la matiere a supprimer
	 */
	public void supprimerMatiere(String nom) {
		matiere.remove(nom);
	}
	
	/**
	 * Getteur du coef d'une matiere
	 * @param nom matiere dont on veux le coef
	 * @return coef de la matiere
	 */
	public double getCoefficient(String nom) {
		//On retourne 0 si la matiere n'est pas presente (pas d'incidences dans les calculs)
		double res = 0;
		if(matiere.containsKey(nom)) {
			res = matiere.get(nom);
		}
		return res;
	}

	/**
	 * Getteur de l'ensemble des matieres de la formation
	 * @return tableau des matieres avec leurs coefs
	 */
	public HashMap<String, Double> getMatiere() {
		return matiere;
	}

	/**
	 * Setteur du tableau des matieres de la formation
	 * @param matiere nouveau tableau
	 */
	public void setMatiere(HashMap<String, Double> matiere) {
		this.matiere = matiere;
	}

	/**
	 * Getteur de l'id d'une formation
	 * @return id de la formation
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setteur qui modifie l'id de la formation
	 * @param id nouvel id de la formation
	 */
	public void setId(int id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((matiere == null) ? 0 : matiere.hashCode());
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
		Formation other = (Formation) obj;
		if (id != other.id)
			return false;
		if (matiere == null) {
			if (other.matiere != null)
				return false;
		} else if (!matiere.equals(other.matiere))
			return false;
		return true;
	}
}
