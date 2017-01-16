package no.hib.data102;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hib.data102.adt.CDArkivADT;

public class Fil {
	static final String SKILLE = "#"; // Eventuelt ha som parameter i metodene
	static final String CDARKIV_FIL = "cdarkiv.txt";
	static int antall;

	/**
	 * Lese et CDArkiv fra tekstfil
	 * 
	 * @param cdarkiv
	 * @param filnavn
	 */
	public static void lesFraFil(CDArkiv cdarkiv, String filnavn) {
		// TODO Metode ikke laget enda 
		
		
	}

	// Alternativt :
	public static CDArkivADT lesFraFil(String filnavn) {
		CDArkiv cda = null;
		int n = 0;
		cda = new CDArkiv(n);

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
		// TODO Metode ikke laget enda
		antall = cdarkiv.hentAntall();
		try {
			FileWriter cdaFil = new FileWriter(CDARKIV_FIL, false);
			
			PrintWriter utfil = new PrintWriter(cdaFil);
			
			utfil.println(antall);
			
			utfil.print(cdarkiv.hentCDTabell().);
			
			utfil.close();
			
		} catch (IOException e) {
			System.err.println("Feil! : " + e);
			System.exit(1);
		}
		
	}

} // class
