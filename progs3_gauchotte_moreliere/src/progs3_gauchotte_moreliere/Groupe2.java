package progs3_gauchotte_moreliere;

import java.util.ArrayList;
import java.util.Collections;

import Trie.TriAlpha2;
import Trie.TriParMerite2;

/**
 * Classe representant un groupe d'etudiant 
 * @author moreliere & gauchotte
 */
public class Groupe2 {
	/**
	 * Groupe d'etudiant 
	 */
	private ArrayList<Etudiant> groupe;
	/**
	 * Formation de ce groupe d'etudiant
	 */
	private Formation formation;
	
	/**
	 * Constructeur d'un groupe d'etudiant avec un id formation
	 * @param n id de la formation
	 */
	public Groupe2(int n) {
		groupe = new ArrayList<Etudiant>();
		formation = new Formation(n);
	}
	
	/**
	 * Methode permettant d'ajouter un etudiant au groupe courant
	 * @param e etudiant a ajouter
	 */
	public void ajouterEtudiant(Etudiant e) {
		if(e.getFormation().getId() == formation.getId()) {
			groupe.add(e);
		}
	}
	
	/**
	 * Methode permettant de supprimer un etudiant au groupe
	 * @param e etudiant a supprimer
	 */
	public void supprimerEtudiant(Etudiant e) {
		int i;
		for(i = 0; (i < groupe.size()) && (! groupe.get(i).equals(e)); i++) {}
		
		if(i < groupe.size()) {
			groupe.remove(e);
		}
	}
	
	/**
	 * Methode permettant de calculer la moyenne d'un groupe pour une matiere donne
	 * @param matiere matiere de laquelle on veut calculer la moyenne du groupe
	 * @return moyenne du groupe
	 */
	public double calculerMoyGroupe(String matiere) {
		double res = 0;
		if(groupe.size() > 0) {
			for(Etudiant e : groupe) {
				res += e.calculerMoyenne(matiere);
			}
			res = res/groupe.size();
		}
		
		return res;
	}
	
	/**
	 * Methode permettant de calculer la moyenne general du groupe 
	 * @return moyenne general du groupe
	 */
	public double calculerMoyGenGroupe() {
		double res = 0;
		
		if(groupe.size() > 0) {
			for(Etudiant e : groupe) {
				res += e.calculerMoyenneGenerale();
			}
			res = res/groupe.size();
		}
		
		return res;
	}
	
	/**
	 * Methode permettant de trier les etudiants par Merite (selon leur moyenne general)
	 */
	public void triParMerite() {
		Collections.sort(groupe, new TriParMerite2());
	}
	
	/**
	 * Methode peremettant de trier les etudiants par Alpha (selon leur ordre alphabétique croissant)
	 */
	public void triAlpha() {
		Collections.sort(groupe, new TriAlpha2());
	}
	
	/**
	 * Getteur du groupe d'etudiant
	 * @return groupe courrant
	 */
	public ArrayList<Etudiant> getGroupe(){
		return groupe;
	}
	
	/**
	 * Getteur de la formation des etudiants
	 * @return Formation commune aux etudiants
	 */
	public Formation getFormation() {
		 return formation;
	}
	
	/**
	 * Permet de modifier la formation pour l'ensemble des etudiants 
	 * @param f nouvelle formation
	 */
	public void setFormation(Formation f) {
		formation = f;
	}
}
