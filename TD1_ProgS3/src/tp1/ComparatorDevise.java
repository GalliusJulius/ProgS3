package tp1;

import java.util.Comparator;

/**
 * Comparator par devise
 * @author victo
 *
 */
public class ComparatorDevise implements Comparator<Money>{

	@Override
	public int compare(Money o1, Money o2) {
		return o1.getDevise().compareTo(o2.getDevise());
	}

}
