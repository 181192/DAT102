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
		
		return false;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hentAntall() {
		// TODO Auto-generated method stub
		return 0;
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
