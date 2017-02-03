package no.hib.dat102.adt;

import java.util.Iterator;

import no.hib.dat102.EmptyCollectionException;

/**
 * Inferface ADT for mengde. En menge er en samling ulike elementer av samme
 * type. Det er ingen ordning av elementer i en mengde.
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 * @param <T>
 *            Generisk type
 */
public interface MengdeADT<T> {
	/**
	 * Legg til et nytt element av klasse T til mengde.
	 * 
	 * @param element
	 *            Nytt element
	 */
	public void leggTil(T element);

	/**
	 * Legger til mengden m2 til denne mengden
	 * 
	 * @param m2
	 *            Mengde som skal legges til
	 */
	public void leggTilAlle(MengdeADT<T> m2);

	/**
	 * Fjerner og returnerer et tilfeldig element fra mengden
	 * 
	 * @return Returner tilfeldig element
	 * @throws EmptyCollectionException
	 *             Empty Exception
	 */
	public T fjernTilfeldig() throws EmptyCollectionException;

	/**
	 * 
	 * @param element
	 * @return Returnerer element
	 * @throws EmptyCollectionException
	 *             Empty Exception
	 */
	public T fjern(T element) throws EmptyCollectionException;

	public MengdeADT<T> union(MengdeADT<T> m2);

	public boolean inneholder(T element);

	boolean erLik(MengdeADT<T> m2);

	boolean erTom();

	int antall();

	Iterator<T> oppramser();
}
