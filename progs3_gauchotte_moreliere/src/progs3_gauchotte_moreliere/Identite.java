package progs3_gauchotte_moreliere;

/**
 * Classe representant l'identite d'un etudiant
 * @author moreliere
 *
 */
public class Identite {
	
	/**
	 * Numero, nom et prenom qui constituent une identite
	 */
	private String nip, nom,prenom;
	
	/**
	 * Constructeur d'une identite
	 * @param num numero nip
	 * @param n nom de l'identite
	 * @param p prenom de l'identite
	 */
	public Identite(String num, String n,String p) {
		nip=num;
		nom=n;
		prenom = p;
	}

	/**
	 * Getteur du numero d'itenfication personnel  
	 * @return nip  de l'identite
	 */
	public String getNip() {
		return nip;
	}

	/**
	 * Setteur du numero d'identification personnel
	 * @param nip nouveau nip
	 */
	public void setNip(String nip) {
		this.nip = nip;
	}
	
	/**
	 * Getteur du nom  
	 * @return nom  de l'identite
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setteur du nom 
	 * @param nom nouveau nom de l'identite
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Getteur du prenom
	 * @return prenom  de l'identite
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setteur du prenom 
	 * @param nom nouveau prenom de l'identite
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nip == null) ? 0 : nip.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Identite other = (Identite) obj;
		if (nip == null) {
			if (other.nip != null)
				return false;
		} else if (!nip.equals(other.nip))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Identite [nip=" + nip + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
