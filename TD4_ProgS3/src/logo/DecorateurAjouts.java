package logo;

public class DecorateurAjouts extends Image {
	protected int x,y;
	protected int cout;
	
	public DecorateurAjouts(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public MyImage getLogo() {
		MyImage img = i.getLogo();
		img.paintOver(getChemin(), x, y);
		return img;
	}

	@Override
	public double combienCaCoute() {
		return i.combienCaCoute()+cout;
	}
	
	
}
