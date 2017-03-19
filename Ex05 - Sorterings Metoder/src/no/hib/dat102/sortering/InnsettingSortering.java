package no.hib.dat102.sortering;

import no.hib.dat102.adt.SorteringADT;

public class InnsettingSortering<T extends Comparable<T>> implements SorteringADT<T> {

	@Override
	public void sorter(T[] data) {
		for (int indeks = 1; indeks < data.length; indeks++) {
			T noekkel = data[indeks];
			int p = indeks;

			// Forskyv større verdier mot høyre
			while (p > 0 && data[p - 1].compareTo(noekkel) > 0) {
				data[p] = data[p - 1];
				p--;
			}
			data[p] = noekkel;
		}
	}
}
