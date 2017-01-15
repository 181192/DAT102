package no.hib.data102;

import no.hib.data102.adt.CDArkivADT;

public class Fil {
	final String SKILLE = "#"; // Eventuelt ha som parameter i metodene

	/**
	 * Lese et CDArkiv fra tekstfil
	 * 
	 * @param cdarkiv
	 * @param filnavn
	 */
	public static void lesFraFil(CDArkiv cdarkiv, String filnavn) {

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
	}

} // class
