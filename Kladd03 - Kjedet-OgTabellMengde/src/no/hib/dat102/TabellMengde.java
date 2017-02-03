/**
 * 
 */
package no.hib.dat102;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import no.hib.dat102.adt.MengdeADT;
import no.hib.dat102.exception.EmptyCollectionException;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 * @param <T>
 *            Generisk type
 */
public class TabellMengde<T> implements MengdeADT<T> {

	private static Random tilf = new Random();
	private final static int STDK = 100;
	private final static int NOT_FOUND = -1;
	private int antall;
	private T[] tab;

	/**
	 * Oppretter en tom mengde tabell med standard kapasitet
	 */
	public TabellMengde() {
		this(STDK);
	}

	/**
	 * Oppretter en tom mengde tabell med spesifisert kapasitet
	 * 
	 * @param startKapasitet
	 *            Antall plasser tabellen skal inneholde
	 */
	public TabellMengde(int startKapasitet) {
		tab = (T[]) (new Object[startKapasitet]);
		antall = 0;

	}

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			if (antall() == tab.length) {
				// utvid metodee
			}
			tab[antall] = element;
			antall++;
		}

	}

	private void utvid() {
		T[] stoerre = (T[]) (new Object[tab.length * 2]);
		for (int indeks = 0; indeks < tab.length; indeks++) {
			stoerre[indeks] = tab[indeks];
		}
		tab = stoerre;
	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> soek = m2.oppramser();

		while (soek.hasNext()) {
			leggTil(soek.next());
		}
	}

	@Override
	public T fjernTilfeldig() throws EmptyCollectionException {
		if (erTom()) {
			throw new EmptyCollectionException("Mengde");
		}
		int valg = tilf.nextInt(antall);
		T resultat = tab[valg];

		tab[valg] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;
		return resultat;
	}

	@Override
	public T fjern(T element) throws EmptyCollectionException, NoSuchElementException {
		int soek = NOT_FOUND;
		if (erTom()) {
			throw new EmptyCollectionException("Mengde");
		}
		for (int indeks = 0; indeks < antall && soek == NOT_FOUND; indeks++) {
			if (tab[indeks].equals(element)) {
				soek = indeks;
			}
		}
		if (soek == NOT_FOUND) {
			throw new NoSuchElementException();
		}
		T resultat = tab[soek];

		tab[soek] = tab[antall - 1];
		tab[antall - 1] = null;
		antall--;

		return resultat;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		TabellMengde<T> begge = new TabellMengde<T>();

		for (int indeks = 0; indeks < antall; indeks++) {
			begge.leggTil(tab[indeks]);
		}
		Iterator<T> soek = m2.oppramser();
		while (soek.hasNext()) {
			begge.leggTil(soek.next());
		}
		return begge;
	}

	@Override
	public boolean inneholder(T element) {
		int soek = NOT_FOUND;

		for (int indeks = 0; indeks < tab.length && soek == NOT_FOUND; indeks++) {
			if (tab[indeks].equals(element)) {
				soek = indeks;
			}
		}
		return (soek != NOT_FOUND);
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		boolean resultat = false;
		TabellMengde<T> temp1 = new TabellMengde<T>();
		TabellMengde<T> temp2 = new TabellMengde<T>();
		T obj;

		if (antall() == m2.antall()) {
			temp1.leggTilAlle(this);
			temp2.leggTilAlle(m2);

			Iterator<T> soek = m2.oppramser();

			while (soek.hasNext()) {
				obj = soek.next();
				if (temp1.inneholder(obj)) {
					temp1.fjern(obj);
					temp2.fjern(obj);
				}
			}
			resultat = (temp1.erTom() && temp2.erTom());
		}
		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall() == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public Iterator<T> oppramser() {
		return (Iterator<T>) new TabellIterator(tab, antall);
	}
}
