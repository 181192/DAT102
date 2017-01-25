package no.hib.dat102.adt;

/**
 * Generisk Interface for Stacks
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 * @param <T>
 *            Generisk type
 */
public interface StackADT<T> {

	/**
	 * Legger til ett spesifikt element til toppen av stabelen.
	 * 
	 * @param element
	 *            element som skal legges til toppen av stabelen
	 */
	public void push(T element);

	/**
	 * Sletter og returnerer topp elementet fra stabelen
	 * 
	 * @return elementet som fjernes fra toppen av stabelen
	 */
	public T pop();

	/**
	 * Returerer uten å slette topp elementet fra stabelen
	 * 
	 * @return elementet fra toppen av stabelen
	 */
	public T peek();

	/**
	 * Returnerer true eller false om stabelen innholder elementer
	 * 
	 * @return true visst stabelen er tom
	 */
	public boolean isEmpty();

	/**
	 * Returnerer antall elementer som er i stabelen
	 * 
	 * @return antall elementer som er i stabelen
	 */
	public int size();

	/**
	 * Returerer en String representasjon av denne stabelen
	 * 
	 * @return En String representasjon av stabelen
	 */
	// public String toString();

}
