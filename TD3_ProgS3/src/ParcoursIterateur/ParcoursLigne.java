package ParcoursIterateur;

public class ParcoursLigne extends Parcours{

	public ParcoursLigne(TableauEntier t) {
		super(t);
	}

	@Override
	public void suivant() {
		if(super.getNbParcourus()%super.getTab().getLargeur() ==0) {
			super.setLigneCour(super.getLigneCour()+1);
			super.setColonneCour(0);
		}
		else {
			super.setColonneCour(super.getColonneCour()+1);
		}
	}
	
	
	
}
