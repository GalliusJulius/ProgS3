
public class FabriqueVoiture implements FabriqueVehicule{

	@Override
	public Vehicule fabriqueVehicule() {
		return new Voiture();
	}
	
	

}
