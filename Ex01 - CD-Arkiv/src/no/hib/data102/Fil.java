package no.hib.data102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hib.data102.adt.CDArkivADT;

/**
 * Klasse for lesing og skriving til fil
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Fil {
	private static final String SKILLE = "#"; // Eventuelt ha som parameter i metodene

	/**
	 * Lese et CDArkiv fra tekstfil
	 * 
	 * @param filnavn
	 */
	public static CDArkivADT lesFraFil(String filnavn) {

		CDArkivADT cda = null;

		try {
			// // 1 - FileReader
			FileReader ansFil = new FileReader(filnavn);

			// 2 - BufferedReader
			BufferedReader innfil = new BufferedReader(ansFil);

			// 3 - Leser den første posten som er antall info-poster
			String linje = innfil.readLine();
			int n = Integer.parseInt(linje);

			// Oppretter CDarkiv
			cda = new CDArkiv(n);

			// 4 - Les postene, en hel post om gangen
			for (int i = 0; i < n; i++) {
				String post = innfil.readLine();
				String[] felt = post.split(SKILLE);
				int cdNr = Integer.parseInt(felt[0]);
				String artist = felt[1];
				String tittel = felt[2];
				int lanseringsaar = Integer.parseInt(felt[3]);
				int sjanger = Integer.parseInt(felt[4]);
				Sjanger sj = Sjanger.finnSjanger(sjanger);

				String plateselskap = felt[5];
				// ...
				CD cd = new CD(cdNr, artist, tittel, lanseringsaar, sj, plateselskap);

				cda.leggTilCd(cd);
			}

			/*
			 * 4 - Lukk filen
			 */
			innfil.close();

		} catch (FileNotFoundException unntak) {
			/*
			 * Arver fra IOException må stå først hvis ikke vil unntaket for
			 * IOException skygge
			 */
			System.out.println("Finner ikke filen " + filnavn);
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Feil ved lesing av fil: " + e);
			System.exit(2);
		}

		return cda;
	}

	/**
	 * Lagre et CDArkiv til tekstfil
	 * 
	 * @param cdarkiv
	 *            CD-Arkivet
	 * @param filnavn
	 * @param utvid
	 */
	public static void skrivTilFil(CDArkivADT cdarkiv, String filnavn, boolean utvid) {
		// Kan sløyfe siste paramenter...
		int antall = cdarkiv.hentAntall();
		try {
			FileWriter cdaFil = new FileWriter(filnavn, utvid);

			PrintWriter utfil = new PrintWriter(cdaFil);

			utfil.println(antall);
			for (int i = 0; i < antall; i++) {
				utfil.print(cdarkiv.hentCDTabell()[i].getCdNr());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getArtist());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getTittel());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getLanseringsaar());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getSjanger());
				utfil.print(SKILLE);
				utfil.print(cdarkiv.hentCDTabell()[i].getPlateselskap());
				utfil.println();
			}

			utfil.close();

		} catch (IOException e) {
			System.err.println("Feil! : " + e);
			System.exit(1);
		}
	}
} // class
