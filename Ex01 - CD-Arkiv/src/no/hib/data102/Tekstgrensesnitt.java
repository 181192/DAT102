package no.hib.data102;

import java.util.Scanner;

import no.hib.data102.adt.CDArkivADT;

/**
 * Klasse for tekstgrensesnitt
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Tekstgrensesnitt {
	private Scanner tast;

	/**
	 * Lese opplysningene om en CD fra tastatur
	 * 
	 * @return
	 */
	public CD lesCd() {
		tast = new Scanner(System.in);

		System.out.print("Oppgi CD-Nummer: ");
		int cdNr = tast.nextInt();

		System.out.print("Oppgi artist/gruppe: ");
		String artist = tast.next();

		System.out.print("Oppgi tittel: ");
		String tittel = tast.next();

		System.out.print("Oppgi laseringsår: ");
		int lanseringsaar = tast.nextInt();

		System.out.print("Oppgi sjanger: ");
		Sjanger sjanger = Sjanger.finnSjanger(tast.next());

		System.out.print("Oppgi plateselskap: ");
		String plateselskap = tast.next();

		CD nycd = new CD(cdNr, artist, tittel, lanseringsaar, sjanger, plateselskap);
		
		return nycd;
	}

	/**
	 * Vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	 * 
	 * @param cd
	 */
	public void visCD(CD cd) {
		System.out.println(cd.toString());
	}

	/**
	 * Skrive ut alle CD-er med en spesiell delstreng i tittelen
	 * 
	 * @param cda
	 * @param delstreng
	 */
	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) {
		CD[] cdsamling = cda.sokTittel(delstreng);

		for (int i = 0; i < cda.hentAntall(); i++) {
			if (cdsamling[i] != null) {
				System.out.println(cdsamling[i].getTittel());
			}
		}
	}

	/**
	 * Skriver ut alle CD-er av en artist / en gruppe
	 * 
	 * @param cda
	 */
	public void skrivUtCdArtist(CDArkivADT cda, String delstreng) {
		CD[] cdsamling = cda.sokArtist(delstreng);

		System.out.println("\nFinner artister på " + delstreng + " : ");
		for (int i = 0; i < cda.hentAntall(); i++) {
			if (cdsamling[i] != null) {
				System.out.println(cdsamling[i].toString());
			}
		}
	}

	/**
	 * Skrive ut en enkel statistikk som inneholder antall CD-er totalt og hvor
	 * mange det er i hver sjanger
	 * 
	 * @param cda
	 *            CDArkiv
	 */
	public void skrivUtStatistikk(CDArkivADT cda) {
		System.out.println("Antall CD'er i arkivet: " + cda.hentAntall());
		for(Sjanger s : Sjanger.values()) {
			System.out.println("Antall CD'er med sjangeren "+s.name()+": " + cda.hentAntall(Sjanger.finnSjanger(s.name())));
		}
	}
} // class
