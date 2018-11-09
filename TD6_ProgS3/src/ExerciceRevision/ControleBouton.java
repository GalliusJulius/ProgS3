package ExerciceRevision;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ControleBouton extends JButton implements ActionListener {
	JTextField texte;
	ModelPhrase m;
	
	public ControleBouton(JTextField t,ModelPhrase mod) {
		super("Compter");
		texte =t;
		m=mod;
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(texte.getText());
		if(texte.getText().length()!=0) {
			texte.setText(""+m.chercherMot(texte.getText()));
		}
		
	}

}
