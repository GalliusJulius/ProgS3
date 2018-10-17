package BalleTD;
import java.awt.Color;
import java.util.Observable;

/** classe balle* */

public class Balle extends Observable {

	public int taille;
	public Color c;

	public Balle() {
		taille = 10;
		c = new Color(0, 0, 0);
		//setChanged();
		//notifyObservers();
	}

	public void changeCouleur(Color t) {
		if (t != null) {
			c = t;
			setChanged();
		}
		notifyObservers();
	}

	public void changeTaille(int t) {
		if (t > 0) {
			taille = t;
			setChanged();
		}
		notifyObservers();
	}

}
