package no.hib.dat102;

public class SpesiellKjedetStruktur<T> {
	private int antall; // antall elementer i mengden
	private LinearNode<T> start;

	/******************************************************************
	 * Oppretter en tom mengde.
	 ******************************************************************/
	public SpesiellKjedetStruktur() {
		antall = 0;
		start = null;
	}

	/******************************************************************
	 * Legger til elementet foran i denne mengden.
	 * 
	 ******************************************************************/
	public void leggTil(T element) {

		LinearNode<T> nyNode = new LinearNode<T>(element);

		nyNode.setNeste(start);
		start = nyNode;
		antall++;
	}

	public void snuKjedetStruktur() {
		int n = 0;
		LinearNode<T> a = null;
		LinearNode<T> b = start;
		LinearNode<T> alle;
		while (n < antall && b != null) {
			if (b == start) {
				a = b;
				b = b.getNeste();
				n++;
			} else {
				b.getNeste().setNeste(a);
				n++;
			}

		}
	}

	/******************************************************************
	 * Returnerer sann hvis mengden er tom og usann ellers.
	 ******************************************************************/
	public boolean erTom() {
		return (antall() == 0);
	}

	/******************************************************************
	 * Returnerer antall elementer i den kjedete strukturen.
	 ******************************************************************/
	public int antall() {
		return antall;
	}

	// 2
	/******************************************************************
	 * Returnerer en strengrepresentasjon av elementene.
	 ******************************************************************/
	public String toString() {
		String resultat = "";
		LinearNode<T> aktuell = start;
		while (aktuell != null) {

			resultat = resultat + aktuell.getElement().toString();
			aktuell = aktuell.getNeste();
		}
		return resultat;
	}// class

	public int finnAntalLik(T el) {
		LinearNode<T> gjennomløp = start;
		int n = 0;
		int antTotalt = 0;
		if (start == el) {
			antTotalt++;
		}
		while (n < antall && gjennomløp.getNeste() != null) {
			if (gjennomløp.getNeste() == el) {
				antTotalt++;
			}
			n++;
		}
		return antTotalt;
	}

}