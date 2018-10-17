package logo;

public class Taupe extends Image{
	public Taupe() {
		super.setChemin("src/img/Taupe.jpg");
	}

	@Override
	public MyImage getLogo() {
		return new MyImage(super.getChemin());
	}

	@Override
	public double combienCaCoute() {
		// TODO Auto-generated method stub
		return 10;
	}
}
