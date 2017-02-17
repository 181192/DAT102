package no.hib.dat102.klient;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;

/**
 * Klient for medlemmer
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class MedlemKlient {
	public static void main(String[] args) {
		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();

		Hobby h1 = new Hobby("Sykkle");
		Hobby h2 = new Hobby("Java");
		Hobby h3 = new Hobby("Klatre");
		Hobby h4 = new Hobby("Gitar");

		hobbyer.leggTil(h1);
		hobbyer.leggTil(h2);
		hobbyer.leggTil(h3);
		hobbyer.leggTil(h4);

		String navn = "Arne";
		int statusIndeks = -1;

		Medlem m1 = new Medlem(navn, statusIndeks);
		m1.setHobbyer(hobbyer);

		m1.skrivUt();
	}
}
