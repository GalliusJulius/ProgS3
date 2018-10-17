package tp1;

import java.util.Comparator;

/**
 * Comparator par montant
 * @author victo
 *
 */
public class ComparatorMontant implements Comparator<Money>{

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Money arg0, Money arg1) {
		int res = 0;
		if(arg0.getMontant()>arg1.getMontant()) res=1;
		else if (arg0.getMontant()<arg1.getMontant()) res=-1;
		return res;
	}

}
