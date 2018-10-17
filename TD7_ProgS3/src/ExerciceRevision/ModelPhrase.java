package ExerciceRevision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;

public class ModelPhrase extends Observable {
	
	private List<String> liste;
	private String max,min;
	
	public ModelPhrase() {
		liste = new ArrayList<String>();
	}
	
	public void ajouterPhrase(String s) {
		liste.add(s);
		max = Collections.max(liste,new Comparator() {
			public int compare(Object arg0, Object arg1) {
				return ((String)arg0).length()-((String)arg1).length();
			}
		});
		min = Collections.min(liste, new Comparator() {
			public int compare(Object arg0, Object arg1) {
				return ((String) arg0).length()-((String)arg1).length();
			}
		});
		this.setChanged();
		this.notifyObservers(); 
	}

	public List<String> getListe() {
		return liste;
	}

	public void setListe(List<String> liste) {
		this.liste = liste;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public int chercherMot(String text) {
		int i =0;
		for(String c : liste) {
			if(c.equals(text)) {
				i++;
			}
		}
		return i;
	}

}
