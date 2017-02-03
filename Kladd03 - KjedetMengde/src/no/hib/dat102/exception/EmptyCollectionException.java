package no.hib.dat102.exception;

/**
 * Unntaks klasse for håndtering av tomme stabler
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class EmptyCollectionException extends RuntimeException {

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
	public EmptyCollectionException(String collection) {
		super("" + collection + " er tom.");

	}
}
