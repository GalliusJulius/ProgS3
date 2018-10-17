package ExerciceRevision;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class VueMax extends JTextField implements Observer{
	
	public VueMax(int i) {
		super(i);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setText(""+((ModelPhrase)arg0).getMax());
	}
	
	
}
