/**
 * 
 */
package no.hib.dat102;

/**
 * Representerer en iterator for en kjedet 
 * struktur av noder kjedet lineaert.
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 * @param <T> Generisk Type
 */
public class KjedetIterator<T> {
	private LinearNode<T> aktuell; // Den aktuelle referansen i iterasjonen
	
	public KjedetIterator(LinearNode<T> samling) {
		aktuell = samling;
	}
	
	public boolean hasNext() {
		return (aktuell != null);
	}
	
	public T next() {
		T resultat = null;
		if(hasNext()) {
			resultat = aktuell.getElement();
			aktuell = aktuell.getNext();
		}
		return resultat;
	}
}
