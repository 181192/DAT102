package no.hib.dat102;

import java.util.NoSuchElementException;

import no.hib.dat102.adt.IteratorADT;

public class TabellIterator<T> implements IteratorADT<T> {

	private int antall;
	private int aktuell;
	private T[] elementer;

	public TabellIterator(T[] mengde, int stoerrelse) {
		elementer = mengde;
		antall = stoerrelse;
		aktuell = 0;
	}

	@Override
	public boolean hasNext() {
		return (aktuell < antall);
	}

	@Override
	public T next() throws NoSuchElementException {
		if (!hasNext()) {
			throw new NoSuchElementException("TabellMengde");
		}
		antall++;

		return elementer[antall - 1];
	}
}
