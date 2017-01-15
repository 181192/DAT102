package no.hib.data102;

import java.util.Scanner;

import no.hib.data102.adt.CDArkivADT;

public class Tekstgrensesnitt {
	/**
	 * Lese opplysningene om en CD fra tastatur
	 * 
	 * @return
	 */
	public CD lesCd() {
		Scanner tast = new Scanner(System.in);

		System.out.print("Oppgi CD-Nummer: ");
		int cdNr = tast.nextInt();

		System.out.print("Oppgi artist/gruppe: ");
		String artist = tast.nextLine();

		System.out.print("Oppgi tittel: ");
		String tittel = tast.nextLine();

		System.out.print("Oppgi laseringsår: ");
		int lanseringsår = tast.nextInt();

		System.out.print("Oppgi sjanger: ");
		Sjanger sjanger = Sjanger.finnSjanger(tast.next());

		System.out.print("Oppgi lanseringsår: ");
		String plateselskap = tast.nextLine();

		CD nycd = new CD(cdNr, artist, tittel, lanseringsår, sjanger, plateselskap);

		tast.close();
		return nycd;
	}

	/**
	 * Vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	 * 
	 * @param cd
	 */
	public void visCD(CD cd) {
		cd.toString();
	}

	/**
	 * Skrive ut alle CD-er med en spesiell delstreng i tittelen
	 * 
	 * @param cda
	 * @param delstreng
	 */
	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {
		cda.sokTittel(delstreng).toString();
	}

	/**
	 * Skriver ut alle CD-er av en artist / en gruppe
	 * 
	 * @param cda
	 */
	public void skrivUtCdArtist(CDArkivADT cda) {
		// TODO Metode ikke laget enda
	}

	/**
	 * Skrive ut en enkel statistikk som inneholder antall CD-er totalt og hvor
	 * mange det er i hver sjanger
	 * 
	 * @param cda
	 */
	public void skrivUtStatistikk(CDArkivADT cda) {
		// TODO Metode ikke laget enda
	}
}
