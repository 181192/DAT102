package no.hib.dat102.adt;

import no.hib.dat102.exception.NoSuchElementsException;

public interface IteratorADT<T> {

	/**
	 * Avgjør om iterasjonen har fullført.
	 * 
	 * @return true hvis iterasjonen har flere elementer
	 */
	public boolean hasNext();

	/**
	 * Henter neste element i samlingen hvis den fins. Flytter til neste
	 * element.
	 * 
	 * @return element hvis det eksisterer
	 * @throws NoSuchElementsException
	 *             hvis iterasjonen har naadd slutten, hvis harNext() er false
	 */
	public T next() throws NoSuchElementsException;
}
