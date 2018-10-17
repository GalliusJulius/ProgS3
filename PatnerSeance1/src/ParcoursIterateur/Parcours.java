package ParcoursIterateur;

import java.util.Iterator;

public abstract class Parcours implements Iterator<Integer> {
	private TableauEntier tab;
	private int ligneCour, colonneCour, nbParcourus;
	
	public Parcours(TableauEntier t) {
		tab=t;
		ligneCour = 0;
		colonneCour = 0;
		nbParcourus =0;
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return tab.getHauteur()*tab.getLargeur()>nbParcourus;
	}
	
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public Integer next() {
		int  res = tab.valA(ligneCour, colonneCour);
		nbParcourus++;
		suivant();
		return res;
	}
	
	/**
	 * Permet d'aller au suivant
	 */
	public abstract void suivant();

	
	public TableauEntier getTab() {
		return tab;
	}

	public void setTab(TableauEntier tab) {
		this.tab = tab;
	}

	public int getLigneCour() {
		return ligneCour;
	}

	public void setLigneCour(int ligneCour) {
		this.ligneCour = ligneCour;
	}

	public int getColonneCour() {
		return colonneCour;
	}

	public void setColonneCour(int colonneCour) {
		this.colonneCour = colonneCour;
	}

	public int getNbParcourus() {
		return nbParcourus;
	}

	public void setNbParcourus(int nbParcourus) {
		this.nbParcourus = nbParcourus;
	}
	
	
	

}
