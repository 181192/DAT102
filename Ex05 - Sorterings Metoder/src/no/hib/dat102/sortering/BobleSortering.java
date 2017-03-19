package no.hib.dat102.sortering;

import no.hib.dat102.adt.SorteringADT;

public class BobleSortering<T extends Comparable<T>> implements SorteringADT<T> {
	@Override
	public void sorter(T[] data) {
		T temp;

		for (int p = data.length - 1; p >= 0; p--) {
			for (int soek = 0; soek <= p - 1; soek++) {
				temp = data[soek];
				data[soek] = data[soek + 1];
				data[soek + 1] = temp;
			}
		}
	}
}
