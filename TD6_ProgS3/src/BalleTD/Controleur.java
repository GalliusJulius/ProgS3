package BalleTD;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controleur extends JSlider {

	Balle modele;

	// constructeur
	public Controleur(Balle b) {
		super();
		// lien avec le modele
		modele = b;
		// initialisation du Slider
		setMaximum(100);
		setMinimum(1);
		// ajout d'un listener pour suivre l'evolution du curseur
		addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				modele.changeTaille(getValue());
			}
		});
	}
}
