package no.hib.dat102.stack;

public class EmptyCollectionException extends RuntimeException{

	/**
	 * Returnerer en passende feilmelding
	 * @param collection navn p� samlingen
	 */
	public EmptyCollectionException(String collection) {
	      super ("" + collection + " er tom.");

	}
}
