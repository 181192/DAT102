package no.hib.dat102.utsyn;

import java.util.Scanner;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;

public class Tekstgrensesnitt {
	private static Scanner tast;

	/**
	 * Leser opplysningene om et medlem fra tastatur
	 * 
	 * @return Nytt Medlem
	 */
	public static Medlem lesMedlem() {
		System.out.println("Oppi navn: ");
		String navn = tast.next();

		System.out.println("Oppgi hobbyer: ");
		MengdeADT<Hobby> hobbyer = new KjedetMengde<Hobby>();
		hobbyer = null;

		int statusIndeks = 0;

		Medlem nyMedlem = new Medlem(navn, hobbyer, statusIndeks);
		return nyMedlem;
	}

	/**
	 * Skriver hobbylisten for et medlem
	 * 
	 * @param medlem
	 *            Medlem
	 */
	public static void skrivHobbyListe(Medlem medlem) {
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
	public static void skrivParListe(Datakontakt arkiv) {

	}
}
