package no.hib.dat102.adt;

public interface KoeADT<T> {

	/**
	 * Legge til et element bak i køen.
	 * @param element Element som legges bak i koen
	 */
	public void innKoe(T element);

	/**
	 * Fjerner og returnerer elementet foran i koeen.
	 * 
	 * @return Element forran i koe, som blir slettet
	 */
	public T utKoe();

	/**
	 * Returnerer elementet foran i kown uten å fjerne det fra koeen.
	 * @return Element forran i koe
	 */
	public T foerste();
	
	/**
	 * Returnerer sann hvis denne koen ikke innholder noen elementer.. 
	 * @return True visst koe er tom
	 */
	public boolean erTom();
	
	/**
	 * Returnerer antall elementer i koeen.
	 * @return Antall elementer i koeen
	 */
	public int antall();
}
