package ParcoursIterateur;

public class ParcoursZigzag extends Parcours{
	boolean versDroite;

	public ParcoursZigzag(TableauEntier t) {
		super(t);
		versDroite =true;
	}

	@Override
	public void suivant() {
		if(super.getNbParcourus()%super.getTab().getLargeur() ==0) {
			super.setLigneCour(super.getLigneCour()+1);
			if (versDroite) versDroite=false;
			else versDroite=true;
		}
		else {
			if(versDroite) super.setColonneCour(super.getColonneCour()+1);
			else super.setColonneCour(super.getColonneCour()-1);
		}
	}

}
