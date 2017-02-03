package no.hib.dat102.exception;

public class NoSuchElementsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Returnerer en passende feilmelding
	 * 
	 * @param collection
	 *            navn på samlingen
	 */
	public NoSuchElementsException(String collection) {
		super("" + collection + " er tom.");

	}
}
