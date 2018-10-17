
public class Text implements Dessinable{
	private TextDrawer t;
	private String mot;
	
	public Text(String s) {
		mot = s;
		t=new TextDrawer();
	}
	@Override
	public void dessiner() {
		t.drawString(mot);
	}

}
