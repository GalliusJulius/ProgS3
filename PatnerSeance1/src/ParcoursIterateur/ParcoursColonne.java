package ParcoursIterateur;

public class ParcoursColonne extends Parcours{
	
	public ParcoursColonne(TableauEntier t) {
		super(t);
	}
	
	@Override
	public void suivant() {
		if(super.getNbParcourus()%super.getTab().getHauteur() ==0) {
			super.setLigneCour(0);
			super.setColonneCour(super.getColonneCour()+1);
		}
		else {
			super.setLigneCour(super.getLigneCour()+1);
		}
	}
}
