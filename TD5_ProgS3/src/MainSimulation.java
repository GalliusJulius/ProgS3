
public class MainSimulation {
	
	public static void main (String [] args) {

		Simulateur simu = new Simulateur(new FabriquePieton());
		System.out.println("resulat fabrique pieton :");
		simu.ecrireStats();
		simu.dessinerStats();

		simu = new Simulateur(new FabriqueVoiture());
		System.out.println("resulat fabrique voiture :");
		simu.ecrireStats();
		simu.dessinerStats();

		simu = new Simulateur(new FabriqueBus());
		System.out.println("resulat fabrique bus :");
		simu.ecrireStats();
		simu.dessinerStats();

		simu = new Simulateur(new FabriqueIntersection());
		System.out.println("resulat fabrique intersection base :");
		simu.ecrireStats();
		simu.dessinerStats();
		//voiture/bus/byc/piet

		simu = new Simulateur(new FabriqueIntersection(50,20,0,30));
		System.out.println("resulat fabrique intersection bouge :");
		simu.ecrireStats();
		simu.dessinerStats();

		simu = new Simulateur(new FabriqueIntersection(100,20,0,30));
		System.out.println("resulat fabrique intersection erronne :");
		simu.ecrireStats();
		simu.dessinerStats();
		
	}

}
