package BalleTD;
import java.awt.*;
import javax.swing.*;

public class Principale {

/**
 * @param args
 */
public static void main(String[] args) {
	//creer une balle
	Balle b=new Balle();
	//creer une vue
	VueBalle vue=new VueBalle();
	//attacher la vue au modele
	b.addObserver(vue);
	vue.setPreferredSize(new Dimension(200,200));
	//creer le controleur
	Controleur c=new Controleur(b);
	c.setPreferredSize(new Dimension(100,50));
	//ranger tout dans une frame
	JFrame frame=new JFrame();
	frame.setLayout(new BorderLayout());
	frame.getContentPane().add(vue,BorderLayout.NORTH);
	frame.getContentPane().add(c,BorderLayout.SOUTH);
	frame.pack();
	frame.setSize(new Dimension(300,300));
	//frame.pack();
	frame.setVisible(true);	
	b.changeTaille(10);
	c.setValue(10);
	}

}
