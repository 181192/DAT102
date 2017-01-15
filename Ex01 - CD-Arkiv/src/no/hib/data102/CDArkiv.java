package no.hib.data102;

import no.hib.data102.adt.CDArkivADT;

public class CDArkiv implements CDArkivADT {

	private CD[] cdTabell;
	private int antall;

	public CDArkiv() {
		cdTabell = null;
		antall = 0;
	}

	public CDArkiv(int maksAntall) {
		cdTabell = new CD[maksAntall];
		this.antall = 0;
	}

	@Override
	public CD[] hentCDTabell() {
		return cdTabell;
	}

	/**
	 * Hjelpe metode for å utvide kapasiteten til CDArkiv tabellen.
	 */
	private void utvidKapasitet() {
		CD[] hjelpetabell = new CD[(int) (1.1 * cdTabell.length)];
		for (int i = 0; i < cdTabell.length; i++) {
			hjelpetabell[i] = cdTabell[i];
		}
		cdTabell = hjelpetabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		if (antall == cdTabell.length) {
			utvidKapasitet();
		}
		cdTabell[antall] = nyCd;
		antall++;

	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean tilstand = false;
		int posisjon = sokCdNr(cdNr);
		if (posisjon != -1) {
			cdTabell[posisjon] = cdTabell[antall - 1];
			cdTabell[antall - 1] = null;
			antall--;
			tilstand = true;
		} else {
			System.out.println("CD'en finnes ikke i arkivet!");
		}
		return tilstand;
	}

	/**
	 * Søker etter CD i tabellen ved hjelp av CD-Nr
	 * 
	 * @param cdNr
	 *            = Nummeret til CD'en (int)
	 * @return -1 dersom CD'en ikke finnes, ellers posisjonen CD'en ligger i
	 *         tabellen.
	 */
	public int sokCdNr(int cdNr) {
		int posisjon = -1;
		int i = 0;
		boolean funnet = false;

		while (!funnet && i < antall) {
			if (cdTabell[i].getCDnr() == cdNr) {
				posisjon = i;
				funnet = true;
			}
			i++;
		}
		return posisjon;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] resultatTittel = new CD[antall];
		int i = 0;
		boolean funnet = false;
		
		while (!funnet && i < antall) {
			if (cdTabell[i].getTittel().contains(delstreng)) {
				resultatTittel[i] = cdTabell[i];
				funnet = true;
			}
		}
		return resultatTittel;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] resultatArtist = new CD[antall];
		int i = 0;
		boolean funnet = false;
		
		while (!funnet && i < antall) {
			if (cdTabell[i].getArtist().contains(delstreng)) {
				resultatArtist[i] = cdTabell[i];
				funnet = true;
			}
		}
		return resultatArtist;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int antallCDISjanger = 0;
		for (int i = 0; i < antall; i++) {
			if (cdTabell[i].getSjanger() == sjanger) {
				antallCDISjanger++;
			}
		}
		return antallCDISjanger;
	}

	/**
	 * Ved hjelp av å trimme tabellen, vil eventuelle null-referanser alltid
	 * være på slutten av tabellen. Alle referanser som referer til objekter vil
	 * komme sammenhengenede etter hverandre. Forusatt da at tabellen ikke er
	 * blitt tom.
	 * 
	 * @param tab
	 *            Tabell av CD-er
	 * @param n
	 *            N er antall elementer
	 * @return En ny full tabell
	 */
	@SuppressWarnings("unused") // slett linje når metode taes i bruk
	private CD[] trimTab(CD[] tab, int n) {
		CD[] cdtab2 = new CD[n];
		int i = 0;
		while (i < n) {
			cdtab2[i] = tab[i];
			i++;
		} // while
		return cdtab2;
	}
}
