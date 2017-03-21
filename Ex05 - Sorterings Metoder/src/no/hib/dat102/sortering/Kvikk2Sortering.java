package no.hib.dat102.sortering;

import no.hib.dat102.adt.SorteringADT;

public class Kvikk2Sortering<T extends Comparable<T>> implements SorteringADT<T> {
	private final int skille = 92;
	@Override
	public void sorter(T[] data) {
		kvikkSortNy(data, 0, data.length - 1);
	}
	
	public void kvikkSortNy(T[] data, int min, int maks) {
		kvikkSort2(data, skille, maks);
		sorteringVedInnsetting2(data, min, skille);
	}
	
	public void sorteringVedInnsetting2(T[] data, int min, int maks) {
		for (int indeks = min + 1; indeks < maks; indeks++) {
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

	public void kvikkSort2(T[] data, int min, int maks) {
		int posPartisjon;
		if (maks - min + 1 > skille) {// antall elementer > MIN ?
			/** Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);
			/** Sorterer venstre side */
			kvikkSort2(data, min, posPartisjon - 1);
			/** Sorterer høyre side */
			kvikkSort2(data, posPartisjon + 1, maks);
		}
	} // metode

	private int finnPartisjon(T[] data, int min, int maks) {
		int venstre;
		int hoeyre;
		T temp;
		T pivot;

		// Pivot som første element
		pivot = data[min];
		venstre = min;
		hoeyre = maks;

		while (venstre < hoeyre) {
			/* Søker et element som er større enn pivot */
			while (venstre < hoeyre && data[venstre].compareTo(pivot) <= 0) {
				venstre++;
			}
			/* Søker et element som er <= enn pivot */
			while (data[hoeyre].compareTo(pivot) > 0) {
				hoeyre--;
			}
			if (venstre < hoeyre) {
				temp = data[venstre];
				data[venstre] = data[hoeyre];
				data[hoeyre] = temp;
			}
		} // while
		/* Flytter pivot til riktig og endelig plass */
		temp = data[min];
		data[min] = data[hoeyre];
		data[hoeyre] = temp;
		return hoeyre;
	} // metode

	@Override
	public double funksjon(int n, double c) {
		return c*n*(Math.log(n)/Math.log(2));
	}

}
