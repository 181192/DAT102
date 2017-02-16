package no.hib.dat102.utsyn;

import java.util.Scanner;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;

/**
 * Klasse for tekstgrensesnitt
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Tekstgrensesnitt {
	private Scanner tast;

	/**
	 * Leser opplysningene om et medlem fra tastatur
	 * 
	 * @return Nytt Medlem
	 */
	public Medlem lesMedlem() {
		System.out.println("Oppi navn: ");
		String navn = tast.next();

		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();
		Hobby nyHobby = null;
		System.out.println("Oppgi hobbyer, avslutt med -1 : ");
		String streng = tast.nextLine();

		// leser inn hobbyer
		while (!nyHobby.equals("-1")) {
			nyHobby = new Hobby(streng);
			hobbyer.leggTil(nyHobby);

			System.out.println("Oppgi hobbyer, avslutt med -1 : ");
			streng = tast.nextLine();
		} // while

		// setter standard status indeks til -1
		int statusIndeks = -1;

		Medlem nyMedlem = new Medlem(navn, hobbyer, statusIndeks);
		return nyMedlem;
	}

	/**
	 * Skriver hobbylisten for et medlem
	 * 
	 * @param medlem
	 *            Medlem
	 */
	public void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	/**
	 * Skriver ut på skjermen en oversikt over medlemmer som er koblet til
	 * hverandre i medlemstabellen til enhver tid. Et slikt par skal kun vises
	 * en gang på utskriftlisten. Metoden skriver også ut antall par som er
	 * funnet.
	 * 
	 * @param arkiv
	 *            Datakontakt arkiv som skal skrives ut
	 */
	public void skrivParListe(Datakontakt arkiv) {

	}
}
