
public class Main {

	public static void main(String[] args) {
		Dessinable[] d= {new Rectangle(), new Cercle(), new Text("Salut")};
		for(Dessinable dess : d) {
			dess.dessiner();
		}

	}

}
