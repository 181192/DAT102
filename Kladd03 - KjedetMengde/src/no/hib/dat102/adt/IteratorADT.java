package no.hib.dat102.adt;

import java.util.NoSuchElementException;

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
	 * @throws NoSuchElementException
	 *             hvis iterasjonen har naadd slutten, hvis harNext() er false
	 */
	public T next() throws NoSuchElementException;
}
