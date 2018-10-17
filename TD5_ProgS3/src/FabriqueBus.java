
public class FabriqueBus implements FabriqueVehicule {

	@Override
	public Vehicule fabriqueVehicule() {
		return new Bus();
	}

}
