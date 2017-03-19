package no.hib.dat102.sortering;

import no.hib.dat102.adt.SorteringADT;

public class FletteSortering<T extends Comparable<T>> implements SorteringADT<T> {

	@Override
	public void sorter(T[] data) {
		fletteSort(data, 0, data.length);
	}

	
	public void fletteSort(T[] data, int foerste, int siste) {
		if (foerste < siste) {
			int midten = (foerste + siste) / 2;

			fletteSort(data, foerste, midten);

			fletteSort(data, midten + 1, siste);

			flette(data, foerste, midten, siste);
		}
		
	}
	
	private void flette(T[] tabell, int foerste, int midten, int siste) {
		int stor = siste - foerste + 1;
		T[] hjelpeTabell = (T[]) (new Comparable[stor]);

		int foerste1 = foerste;
		int siste1 = midten;

		int foerste2 = midten + 1;
		int siste2 = siste;

		int indeks = 0;

		while ((foerste1 <= siste1) && (foerste2 <= siste2)) {
			if (tabell[foerste1].compareTo(tabell[foerste2]) <= 0) {
				hjelpeTabell[indeks] = tabell[foerste1];
				foerste1++;
			} else {
				hjelpeTabell[indeks] = tabell[foerste2];
				foerste2++;
			}
			indeks++;
		}

		while (foerste1 <= siste1) {
			hjelpeTabell[indeks] = tabell[foerste1];
			foerste1++;
			indeks++;
		}

		while (foerste2 <= siste2) {
			hjelpeTabell[indeks] = tabell[foerste2];
			foerste2++;
			indeks++;
		}
		int h = 0;
		for (indeks = foerste; indeks <= siste; indeks++) {
			tabell[indeks] = hjelpeTabell[h];
			h++;
		}
	}

}
