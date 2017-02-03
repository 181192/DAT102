package no.hib.dat102;

import java.util.Iterator;
import java.util.Random;

import no.hib.dat102.adt.MengdeADT;
import no.hib.dat102.exception.EmptyCollectionException;

/**
 * 
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 * @param <T>
 *            Generisk type
 */
public class KjedetMengde<T> implements MengdeADT<T> {

	private static Random rand = new Random();
	private int antall;
	private LinearNode<T> start;

	/**
	 * 
	 */
	public KjedetMengde() {
		antall = 0;
		start = null;
	}

	@Override
	public void leggTil(T element) {
		if (!(inneholder(element))) {
			LinearNode<T> node = new LinearNode<T>(element);
			node.setNext(start);
			start = node;
			antall++;
		}

	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			leggTil(teller.next());
		}

	}

	@Override
	public T fjernTilfeldig() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjern(T element) throws EmptyCollectionException {
		LinearNode<T> forgjenger;
		LinearNode<T> aktuell;
		T resultat = null;

		if (!erTom()) {
			int valg = rand.nextInt(antall) + 1;
			if (valg == 1) {
				resultat = start.getElement();
				start = start.getNext();
			} else {
				forgjenger = start;
				for (int nr = 2; nr < valg; nr++) { // posisjoner
					forgjenger = forgjenger.getNext();
				}
				aktuell = forgjenger.getNext();
				resultat = aktuell.getElement();
				forgjenger.setNext(aktuell.getNext()); // slett
			}
			antall--;
		} // if
		return resultat;
	} // metode

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		KjedetMengde<T> begge = new KjedetMengde<T>();
		LinearNode<T> aktuell = start;
		while(aktuell != null) {
			begge.leggTil(aktuell.getElement());
			aktuell = aktuell.getNext();
		} // while
		
		Iterator<T> teller = m2.oppramser();
		while (teller.hasNext()) {
			begge.leggTil(teller.next());
		}
		return begge;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		LinearNode<T> aktuell = start;
		for (int soek = 0; soek < antall && !funnet; soek++) {
			if (aktuell.getElement().equals(element)) {
				funnet = true;
			} else {
				aktuell = aktuell.getNext();
			}
		}
		return funnet;
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return false;
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
		return new KjedetIterator<T> (start, antall);
	}

}
