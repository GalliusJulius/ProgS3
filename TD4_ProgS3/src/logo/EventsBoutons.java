package logo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class EventsBoutons implements ActionListener{
	private MyImage img;
	
	public EventsBoutons(MyImage i) {
		img =i;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String boutons = ((JButton)arg0.getSource()).getText();
		switch (boutons){
		case "Lunette":
			img.paintOver("src/img/Sunglasses.png", 255, 76);
			break;
		case "Chapeau":
			img.paintOver("src/img/Chapeau.png", 280, 42);
			break;
		case "Texte":
			img.textOver("Test test", 100, 100);
			break;
		case "Reset":
			//img.image=new BufferedImage("src/img/Taupe.jpg");
			break;
		default:
			System.out.println("soucis!");
		}
		img.repaint();
		
	}
	

}
