package no.hib.dat102;

import no.hib.dat102.adt.KoeADT;

public class SirkulaerKoe<T> implements KoeADT<T> {

	private static final int STD = 100;
	private int front;
	private int bak;
	private int antall;
	private T[] koe;

	/**
	 * Oppretter en tom koe med standard kapasitet
	 */
	public SirkulaerKoe() {
		this(STD);
	}

	/**
	 * Oppretter en tom koe med en spesifisert kapasitet.
	 * 
	 * @param startKapasitet
	 *            Antall plasser koeen skal inneholde
	 */
	public SirkulaerKoe(int startKapasitet) {
		koe = (T[]) (new Object[startKapasitet]);
		front = 0;
		bak = 0;
		antall = 0;
	}

	/**
	 * Oppretter en ny stoerre tabell for aa lagre elementene.
	 */
	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int soek = 0; soek < antall; soek++) {
			hjelpetabell[soek] = koe[front];
			front = (front + 1) % koe.length;
		}
		front = 0;
		bak = antall;
		koe = hjelpetabell;
	}

	@Override
	public void innKoe(T element) {
		if (antall() == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak = (bak + 1) % koe.length;
		antall++;
	}

	@Override
	public T utKoe() throws EmptyCollectionException {
		T resultat = null;
		if (erTom()) {
			throw new EmptyCollectionException("Koe");
		}
		resultat = koe[front];
		koe[front] = null;
		front = (front + 1) % koe.length;
		antall--;

		return resultat;
	}

	@Override
	public T foerste() throws EmptyCollectionException {
		T resultat = null;
		if (erTom()) {
			throw new EmptyCollectionException("Koe");
		}
		resultat = koe[front];
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

}
