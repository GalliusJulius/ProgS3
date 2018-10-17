package logo;

public class Text extends DecorateurAjouts{
	
	public Text(Image img, String phrase) {
		super(100, 50);
		i=img;
		setChemin(phrase);
		cout = 10;
		// TODO Auto-generated constructor stub
	}
	
	public MyImage getLogo() {
		MyImage img = i.getLogo();
		img.textOver(getChemin(), x, y);
		return img;
	}

}
