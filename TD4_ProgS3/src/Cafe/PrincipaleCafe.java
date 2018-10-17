package Cafe;

public class PrincipaleCafe {
	
	public static void main(String [] args) {
		Boisson  deca = new Deca();
		System.out.println(deca);
		deca = new BoissonCreme(deca);
		System.out.println(deca);
		deca = new BoissonChantilly(deca);
		System.out.println(deca);
		deca = new BoissonChantilly(deca);
		System.out.println(deca);
	}
}
