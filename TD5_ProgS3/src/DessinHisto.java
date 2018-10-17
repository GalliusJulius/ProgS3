import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class DessinHisto extends JPanel{
	private HashMap<String,Integer> val;
	private int n;
	private static Color[] coul = {Color.red,Color.blue,Color.CYAN,Color.yellow,Color.LIGHT_GRAY,Color.red,Color.magenta,Color.gray,Color.green,Color.orange};
	
	public DessinHisto(int n, HashMap<String,Integer> tab){
		this.val = tab;
		this.n = n;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int h = getHeight();
		int w = getWidth();
		g.setColor(Color.black);
		for(int i =0;i<h/150;i++){
			//x
			g.drawLine(w-(11*w/12), h-(h/12)+i ,w-w/12 , h-(h/12)+i);
			g.drawLine(w-w/12 , h-h/12+i, w-w/12-30, h-(h/12)+15+i);
			g.drawLine(w-w/12 , h-h/12-i, w-w/12-30, h-(h/12)-15-i);
			//y
			g.drawLine(w-(11*w/12)-i, h-(h/12), w-(11*w/12)-i, h-(11*(h/12)));
			g.drawLine(w-(11*w/12)-i, h-(11*(h/12)),w-(11*w/12)-15-i,h-(11*(h/12))+30) ;
			g.drawLine(w-(11*w/12)+i, h-(11*(h/12)),w-(11*w/12)+15+i,h-(11*(h/12))+30) ;
		}
		int largBar = (w-(2*w/12))/this.n;
		int hmax = h-(2*h/12);
		Font font = new Font("Verdana", Font.BOLD, (largBar+hmax)/2/10);
		g.setFont(font);
		int i =0;
		for(String s : val.keySet()){
			g.setColor(DessinHisto.coul[i]);
			g.fillRect(2+w/12+largBar*i, h-(h/12)-hmax*val.get(s)/20, largBar, hmax*val.get(s)/20 );
			g.drawString(s,-20+w/12+largBar*i+largBar/3+w/175,h-(h/12)+25);
			i++;
		}
	}
	
}
