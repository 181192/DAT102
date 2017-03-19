package no.hib.dat102.sortering;

import no.hib.dat102.koe.SirkulaerKoe;

public class SorteringsMetoder<T extends Comparable<T>> {

	public void utvalgsSortering(T[] data) {
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

	public void sorteringVedInsetting(T[] data) {
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

	public void bobleSort(T[] data) {
		T temp;

		for (int p = data.length - 1; p >= 0; p--) {
			for (int soek = 0; soek <= p - 1; soek++) {
				temp = data[soek];
				data[soek] = data[soek + 1];
				data[soek + 1] = temp;
			}
		}
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

	public void fletteSort(T[] tabell, int foerste, int siste) {
		if (foerste < siste) {
			int midten = (foerste + siste) / 2;

			fletteSort(tabell, foerste, midten);

			fletteSort(tabell, midten + 1, siste);

			flette(tabell, foerste, midten, siste);
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

	public void radixSort(Integer[] data, int antallSiffer) {
		String temp;
		Integer tallObj;
		int siffer;
		int tall;

		SirkulaerKoe<Integer>[] sifferKoeer = (SirkulaerKoe<Integer>[]) (new SirkulaerKoe[10]);

		for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
			sifferKoeer[sifferVerdi] = new SirkulaerKoe<Integer>();
		}
		for (int posisjon = 0; posisjon <= antallSiffer; posisjon++) {
			for (int i = 0; i < data.length; i++) {
				temp = String.valueOf(data[i]);
				siffer = Character.digit(temp.charAt(antallSiffer - posisjon), 10);
				sifferKoeer[siffer].innKoe(new Integer(data[i]));
			} // indre løkke
			tall = 0;
			for (int sifferVerdi = 0; sifferVerdi <= 9; sifferVerdi++) {
				while (!(sifferKoeer[sifferVerdi].erTom())) {
					tallObj = sifferKoeer[sifferVerdi].utKoe();
					data[tall] = tallObj.intValue();
					tall++;
				} // while
			} // for
		} // ytre løkke
	}
}
