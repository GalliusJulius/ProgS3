package tp1;

/**
 * Classe representant une Money
 * @author victo
 *
 */
public class Money {
	/**
	 * Montant de la Money
	 * @see Money#getMontant
	 */
	private int montant;
	/**
	 * Devise de cette Money
	 * @see Money#getDevise
	 */
	private String devise;
	
	/**
	 * Constructeur permettant d'instancier une Money avec un montant et une devise
	 * @param mon montant de la nouvelle Money
	 * @param dev devise de la Money
	 */
	public Money(int mon, String dev) {
		this.montant = mon;
		this.devise = dev;
	}
	
	/**
	 * Getteur du montant de la Money
	 * @return montant de la Money en cours
	 */ 
	public int getMontant() {
		return this.montant;
	}
	
	/**
	 * Getteur de la devise de la Money
	 * @return devise de la Money 
	 */
	public String getDevise() {
		return this.devise;
	}
	
	/**
	 * Methode permettant d'ajouter le montant d'une Money en parametre au montant de la Money courrante
	 * @param m Money de laquelle on va ajouter son montant à la courante
	 * @return la nouvelle Money crée
	 */
	//Probleme initial de la méthode : ajoute sans prendre en compte la devise de m
	public Money add(Money m) {
		Money res = null;
		try {
			if(!devise.equals(m.getDevise())) {
				throw new DeviseException("Pas la meme devise");
			}
			res = new Money(this.getMontant()+m.getMontant(), this.getDevise());
		}
		catch(DeviseException e){
			System.out.println(e.getMessage());
		}
		if(!devise.equals(m.getDevise())) {
			new DeviseException();
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((devise == null) ? 0 : devise.hashCode());
		result = prime * result + montant;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (devise == null) {
			if (other.devise != null)
				return false;
		} else if (!devise.equals(other.devise))
			return false;
		if (montant != other.montant)
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("Money en :"+devise+" possèdant un montant de :"+montant);
	}
}
