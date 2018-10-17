
public class FabriqueIntersection implements FabriqueVehicule{
	private double probaVoiture=80,probaBus=10,probaByc=0,probaPieton=10;
	
	public FabriqueIntersection(){}
	
	public FabriqueIntersection(double voit, double bus,double byc,double piet ) {
		if(voit+bus+byc+piet==100) {
			probaVoiture = voit;
			probaBus=bus;
			probaByc=byc;
			probaPieton=piet;
		}
	}
	
	
	@Override
	public Vehicule fabriqueVehicule() {
		int chance = 1+(int) Math.round(Math.random()*100);
		if(chance<=probaVoiture) {
			return new Voiture();
		}
		else if(chance <=probaVoiture+probaBus) {
			return new Bus();
		}
		else if(chance <=probaVoiture+probaBus+probaByc) {
			return null;
		}
		else {
			return new Pieton();
		}
	}

}
