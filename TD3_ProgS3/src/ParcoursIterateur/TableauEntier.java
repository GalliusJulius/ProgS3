package ParcoursIterateur;

import java.util.Iterator;

public class TableauEntier implements Iterable<Integer> {
	private int[][] tab;
	
	public TableauEntier(int[][] t) {
		tab=t;
	}
	
	public int valA(int l,int c) {
		return tab[l][c];
	}
	
	public int getLargeur() {
		return tab[0].length;
	}
	
	public int getHauteur() {
		return tab.length;
	}
	
	public ParcoursLigne iterateurLigne() {
		return new ParcoursLigne(this);
	}
	
	public ParcoursZigzag iterateurZigZag() {
		return new ParcoursZigzag(this);
	}
	
	public ParcoursColonne iterateurColonne() {
		return new ParcoursColonne(this);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new ParcoursZigzag(this);
	}
}
