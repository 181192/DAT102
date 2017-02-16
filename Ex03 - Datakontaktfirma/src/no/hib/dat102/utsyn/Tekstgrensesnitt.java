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
	private Hobby nyHobby;

	/**
	 * Leser opplysningene om et medlem fra tastatur
	 * 
	 * @return Nytt Medlem
	 */
	public Medlem lesMedlem() {
		tast = new Scanner(System.in);
		
		System.out.print("Oppgi navn: ");
		String navn = tast.next();

		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();
		System.out.print("Oppgi hobbyer, avslutt med zzz : ");
		String streng = tast.next();
		// leser inn hobbyer
		while (!streng.equals("zzz")) {
			nyHobby = new Hobby(streng);
			hobbyer.leggTil(nyHobby);

			System.out.print("Oppgi hobbyer, avslutt med zzz : ");
			streng = tast.next();
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
