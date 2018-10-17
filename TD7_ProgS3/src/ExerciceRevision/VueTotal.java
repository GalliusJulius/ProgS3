package ExerciceRevision;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VueTotal extends JScrollPane implements Observer{
	JTextArea t;

	public VueTotal(JTextArea text){
		super(text);
		t=text;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		List<String> liste = ((ModelPhrase)arg0).getListe();
		String res ="";
		for(String courant : liste) {
			res+=courant+"\n";
		}
		t.setText(res);
	}
	
	

}
