package no.hib.dat102.adt;

public interface SorteringADT<T extends Comparable<T>> {
	/**
	 * Sorterer tabellen
	 * @param data Tabell med data
	 */
	public void sorter(T[] data);
	
	/**
	 * Avgjøre hvilken funksjon
	 * @param n Antall elementer
	 * @param c Konstanten C
	 */
	public double funksjon(int n, double c);
}
