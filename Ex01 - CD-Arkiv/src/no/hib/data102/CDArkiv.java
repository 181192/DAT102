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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean slettCd(int cdNr) {
		// TODO Auto-generated method stub
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
}
