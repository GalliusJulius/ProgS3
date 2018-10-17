package logo;

public abstract class Image {
	private String chemin;
	protected Image i;
	
	public abstract double combienCaCoute();
	
	public abstract MyImage getLogo();
	
	public String getChemin() {
		return chemin;
	}
	
	public void setChemin(String s) {
		chemin=s;
	}
	
	
}
