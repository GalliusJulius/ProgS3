
public class FabriqueJonction implements FabriqueVehicule{
	private FabriqueVehicule faba,fabb;
	private static int nb = 0;

	public FabriqueJonction(FabriqueVehicule f1, FabriqueVehicule f2) {
		faba = f1;
		fabb=f2;
	}
	
	@Override
	public Vehicule fabriqueVehicule() {
		nb++;
		if(nb%2==0) {
			return faba.fabriqueVehicule();
		}
		else {
			return fabb.fabriqueVehicule();
		}
	}
	
	

}
