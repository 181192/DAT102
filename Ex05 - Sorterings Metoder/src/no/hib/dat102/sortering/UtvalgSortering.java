package no.hib.dat102.sortering;

import no.hib.dat102.adt.SorteringADT;

public class UtvalgSortering<T extends Comparable<T>> implements SorteringADT<T> {

	@Override
	public void sorter(T[] data) {
		int minste;
		T temp;
		for (int neste = 0; neste < data.length - 1; neste++) {
			minste = neste;
			for (int soek = neste + 1; soek < data.length; soek++) {
				if (data[soek].compareTo(data[minste]) < 0) {
					minste = soek;
				}
			}
			temp = data[minste];
			data[minste] = data[neste];
			data[neste] = temp;
		}
	}
}
