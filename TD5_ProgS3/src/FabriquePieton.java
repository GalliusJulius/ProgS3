
public class FabriquePieton implements FabriqueVehicule{

	@Override
	public Vehicule fabriqueVehicule() {
		return new Pieton();
	}

}
