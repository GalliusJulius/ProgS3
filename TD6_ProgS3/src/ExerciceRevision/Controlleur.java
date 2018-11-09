package ExerciceRevision;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JTextField;

public class Controlleur extends JTextField implements KeyListener{
	
	private ModelPhrase modele;
	
	public Controlleur(ModelPhrase m ) {
		super(10);
		modele = m;
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == 10) {
			modele.ajouterPhrase(this.getText());
			this.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
