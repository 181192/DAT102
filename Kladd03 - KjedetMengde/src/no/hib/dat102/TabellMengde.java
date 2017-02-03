/**
 * 
 */
package no.hib.dat102;

import java.util.Iterator;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		// TODO Auto-generated method stub

	}

	@Override
	public T fjernTilfeldig() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fjern(T element) throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inneholder(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erLik(MengdeADT<T> m2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erTom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<T> oppramser() {
		// TODO Auto-generated method stub
		return null;
	}

}
