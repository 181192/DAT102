/**
 * 
 */
package no.hib.dat102;

import java.util.NoSuchElementException;

import no.hib.dat102.adt.IteratorADT;

/**
 * Representerer en iterator for en kjedet struktur av noder kjedet lineaert.
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 * @param <T>
 *            Generisk Type
 */
public class KjedetIterator<T> implements IteratorADT<T> {
	private int antall;
	private LinearNode<T> aktuell; // Den aktuelle referansen i iterasjonen

	public KjedetIterator(LinearNode<T> mengde, int stoerrelse) {
		aktuell = mengde;
		antall = stoerrelse;
	}

	/**
	 * @return the antall
	 */
	public int getAntall() {
		return antall;
	}

	/**
	 * @param antall
	 *            the antall to set
	 */
	public void setAntall(int antall) {
		this.antall = antall;
	}

	/**
	 * @return the aktuell
	 */
	public LinearNode<T> getAktuell() {
		return aktuell;
	}

	/**
	 * @param aktuell
	 *            the aktuell to set
	 */
	public void setAktuell(LinearNode<T> aktuell) {
		this.aktuell = aktuell;
	}

	public boolean hasNext() {
		return (aktuell != null);
	}

	public T next() throws NoSuchElementException {
		T resultat = null;
		if (!hasNext()) {
			throw new NoSuchElementException("Mengde");
		}
		resultat = aktuell.getElement();
		aktuell = aktuell.getNext();
		return resultat;
	}
}
