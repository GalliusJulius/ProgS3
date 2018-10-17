package tp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Classe représentant une liste de monaie
 * @author victo
 *
 */
public class MoneyList {
	/**
	 * Liste de money
	 */
	private List<Money> list;
	
	/**
	 * Constructeur vide d'une liste de money 
	 */
	public MoneyList() {
		list= new ArrayList<Money>();
	}
	
	/**
	 * Getteur de la liste des money
	 * @return la liste 
	 */
	public List<Money> getList() {
		return list;
	}
	
	
	public void ajouterSomme (Money m) throws DeviseException {
		ListIterator<Money> i = list.listIterator();
		boolean ajoute = false;
		while(i.hasNext() && !ajoute) {
			Money temp = i.next();
			if(temp.getDevise().equals(m.getDevise())) {
				i.set(temp.add(m));
				ajoute=true;
			}
		}
		if(!ajoute) {
			list.add(m);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = true;
		if (this == obj)
			res= true;
		if (obj == null)
			res= false;
		if (getClass() != obj.getClass())
			res= false;
		MoneyList other = (MoneyList) obj;
		if (list == null) {
			if (other.list != null)
				res= false;
		} 
		else if (!list.equals(other.list)) {
			res= false;
		}
		
		if(res == true && list.size() == ((MoneyList)obj).getList().size()) {
			for(int i = 0; i<list.size();i++) {
				if(!list.get(i).equals(((MoneyList)obj).getList().get(i))) {
					res=false;
				}
			}
		}
		else {
			res=false;
		}
		return res;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MoneyList [list=" + list + "]";
	}
	
	/**
	 * Methode peremettant de trier par montant les money
	 */
	public void triMontant() {
		Collections.sort(list,new ComparatorMontant());
	}
	
	/**
	 * Methode peremettant de trier par devise les money
	 */
	public void triDevise() {
		Collections.sort(list,new ComparatorDevise());
	}
	
	
}
