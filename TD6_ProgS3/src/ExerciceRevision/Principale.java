package ExerciceRevision;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Principale {


	 public static void main(String[] args) { 
		 	
		 JTextField saisie,max,min; //Composants textuels de l'interface
		 JTextArea liste;

		 //JPanel Nord
		 ModelPhrase m = new ModelPhrase();
		 Controlleur c = new Controlleur(m);
		 c.setPreferredSize(new Dimension(200,30));
		 JPanel panneauDeControle= new JPanel(new GridLayout(1,2));
		 panneauDeControle.add(new JLabel("Donner une cha�ne "+"    ",JLabel.CENTER));
		 panneauDeControle.add(c);
		 
		 //Zone centrale
		 liste = new JTextArea(5,5);		

		 //JPanel Sud
		 JPanel panMaxMin = new JPanel(new GridLayout(3,2));
		 panMaxMin.add(new JLabel("Plus grand mot ",JLabel.CENTER));
		// max= new JTextField(10);
		 max = new VueMax(10);
		 max.setPreferredSize(new Dimension(200,30));
		 panMaxMin.add(max);

		 panMaxMin.add(new JLabel("Plus petit mot ", JLabel.CENTER));
		 //min= new JTextField(10);
		 min = new VueMin(10);
		 panMaxMin.add(min);
		 
		 JTextField compter = new JTextField(10);
		 ControleBouton cb = new ControleBouton(compter,m);
		 panMaxMin.add(compter);
		 panMaxMin.add(cb);
		 
		 
		 VueTotal total = new VueTotal(liste);
		 
		 //obser
		 m.addObserver((Observer) min);
		 m.addObserver((Observer) max);
		 m.addObserver(total);
		 
		 //Construction de l'IG dans une JFrame		 
		 JFrame frame=new JFrame();
		 frame.getContentPane().add(panneauDeControle,BorderLayout.NORTH);
		 frame.getContentPane().add(total,BorderLayout.CENTER);
		 frame.getContentPane().add(panMaxMin,BorderLayout.SOUTH);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(new Dimension(400,400));
		 frame.setVisible(true);	
		
	}

} 


