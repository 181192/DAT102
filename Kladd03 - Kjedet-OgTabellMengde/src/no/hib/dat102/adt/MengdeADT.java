package no.hib.dat102.adt;

import java.util.Iterator;

import no.hib.dat102.exception.EmptyCollectionException;

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
	 * Fjerner elementet fra mengden
	 * 
	 * @param element
	 * @return Returnerer element
	 * @throws EmptyCollectionException
	 *             Empty Exception
	 */
	public T fjern(T element) throws EmptyCollectionException;

	/**
	 * Union mellom to mengder
	 * 
	 * @param m2
	 *            mengde som skal inn i union
	 * @return en mengde som inneholder begge mengdene
	 */
	public MengdeADT<T> union(MengdeADT<T> m2);

	/**
	 * Skjekker om en mengde innholder ett element
	 * 
	 * @param element
	 *            Element som skal skjekkes
	 * @return true hvis mengden inneholder elementet
	 */
	public boolean inneholder(T element);

	/**
	 * Skjekker om to mengder er like
	 * 
	 * @param m2
	 *            Mengde som skal sammenlignes
	 * @return True visst mengdene inneholder det samme
	 */
	public boolean erLik(MengdeADT<T> m2);

	/**
	 * Returerer boolean verdi hvis mengden er tom
	 * 
	 * @return true hvis mengden er tom
	 */
	public boolean erTom();

	/**
	 * Antall elementer i mengden
	 * 
	 * @return antall elementer
	 */
	public int antall();

	/**
	 * Itererer gjennom en mengde
	 * 
	 * @return
	 */
	public Iterator<T> oppramser();
}
