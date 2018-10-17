package logo;

public class CrazyFrog extends Image{

	public CrazyFrog() {
		super.setChemin("src/img/CrazyFrog.jpg");
	}
	
	@Override
	public double combienCaCoute() {
		return 15;
	}

	@Override
	public MyImage getLogo() {
		return new MyImage(super.getChemin());
	}

}
