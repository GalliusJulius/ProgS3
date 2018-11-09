package Compteurs;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class VueConsole extends JPanel implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println(""+ ((Model)arg0).getCompteur());
		
	}

}

