package tp1;

/**
 * Exception en cas de meme devise
 * @author victo
 *
 */
public class DeviseException extends Exception {
	
	/**
	 * Constructeur vide de l'exception
	 */
	public DeviseException() {
		super();
	}
	
	/**
	 * Constructeur avec un message de l'exception
	 * @param m
	 */
	public DeviseException(String m) {
		super(m);
	}
}
