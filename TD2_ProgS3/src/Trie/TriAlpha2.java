package Trie;

import java.util.Comparator;

import progs3_gauchotte_moreliere.Etudiant;

/** 
 * Classe permettant de comparer deux etudiant en fonction de leur ordre alphabetique
 * @author moreliere & gauchotte
 *
 */
public class TriAlpha2 implements Comparator<Etudiant>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Etudiant e1, Etudiant e2) {
		int res = e1.getNom().compareTo(e2.getNom());
		
		if(res == 0) {
			res = e1.getPrenom().compareTo(e2.getPrenom());
		}
		
		return res;
	}

}
