package no.hib.data102.node;

/**
 * Unntaks klasse for håndtering av tomme stabler
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class EmptyCollectionException extends RuntimeException {

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
