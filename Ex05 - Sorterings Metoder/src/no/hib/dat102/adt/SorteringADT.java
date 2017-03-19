package no.hib.dat102.adt;

public interface SorteringADT<T extends Comparable<T>> {
	/**
	 * Sorterer tabellen
	 * @param data Tabell med data
	 */
	public void sorter(T[] data);
}
