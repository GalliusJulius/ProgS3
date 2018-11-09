package BalleTD;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class VueBalle extends JPanel implements Observer {

	Balle balleAAfficher;

	public void paint(Graphics arg0) {
		super.paint(arg0);
		arg0.setColor(balleAAfficher.c);
		arg0.fillOval(0, 0, balleAAfficher.taille * 10,
				balleAAfficher.taille * 10);
	}

	public void update(Observable arg0, Object arg1) {
		System.out.println("update");
		balleAAfficher = (Balle) arg0;
		repaint();
	}

}
