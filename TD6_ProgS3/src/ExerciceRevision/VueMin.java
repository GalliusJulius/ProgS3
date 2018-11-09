package ExerciceRevision;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class VueMin extends JTextField implements Observer{

	public VueMin(int i) {
		super(i);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setText(""+((ModelPhrase)arg0).getMin());
	}
	
	

}
