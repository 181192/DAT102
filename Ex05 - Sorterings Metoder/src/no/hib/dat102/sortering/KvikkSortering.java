package no.hib.dat102.sortering;

import no.hib.dat102.adt.SorteringADT;

public class KvikkSortering<T extends Comparable<T>> implements SorteringADT<T> {

	@Override
	public void sorter(T[] data) {
		kvikkSort(data, 0, data.length);
	}

	public void kvikkSort(T[] data, int min, int maks) {
		int posPartisjon;
		if (min < maks) { // minst to elementer
			/* Lager partisjon */
			posPartisjon = finnPartisjon(data, min, maks);

			/* Sorterer venstre side */
			kvikkSort(data, min, posPartisjon - 1);

			/* Sorterer høyre side */
			kvikkSort(data, posPartisjon + 1, maks);
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
}
