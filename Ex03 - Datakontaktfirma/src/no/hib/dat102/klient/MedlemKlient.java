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
		MengdeADT<Hobby> hobbyer2 = new KjedetMengde<Hobby>();

				Hobby h1 = new Hobby("Sykkle");
				Hobby h2 = new Hobby("Java");
				Hobby h3 = new Hobby("Klatre");
				Hobby h4 = new Hobby("Gitar");

				hobbyer.leggTil(h1);
				hobbyer.leggTil(h2);
				hobbyer.leggTil(h3);
				hobbyer.leggTil(h4);
				hobbyer2.leggTil(h1);
				hobbyer2.leggTil(h2);

				String navn = "Arne";
				int statusIndeks = -1;

				String navn2 = "Kristoffer";

				Medlem m1 = new Medlem(navn, statusIndeks);
				m1.setHobbyer(hobbyer);

				Medlem m2 = new Medlem(navn2, statusIndeks);
				m2.setHobbyer(hobbyer2);

				m1.skrivUt();
				m2.skrivUt();
	}
}
