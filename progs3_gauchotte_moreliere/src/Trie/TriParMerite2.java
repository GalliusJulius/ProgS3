package Trie;

import java.util.Comparator;

import progs3_gauchotte_moreliere.Etudiant;

/**
 * Classe permettant de comparer des etudiants en fonction de leurs moyennes general
 * @author moreliere & Gauchotte
 *
 */
public class TriParMerite2 implements Comparator<Etudiant>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Etudiant e1, Etudiant e2) {
		return (int)((e2.calculerMoyenneGenerale() - e1.calculerMoyenneGenerale()) * Math.pow(10, 2));
	}
}
