package no.hib.dat102.sortering;

import no.hib.dat102.adt.SorteringADT;
import no.hib.dat102.koe.SirkulaerKoe;

public class RadixSortering<T extends Comparable<T>> implements SorteringADT<T> {

	@Override
	public void sorter(T[] data) {
		radixSort((Integer[]) data, 4);
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
