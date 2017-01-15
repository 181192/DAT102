package no.hib.data102;

import no.hib.data102.adt.CDArkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDArkivADT cda;

	public Meny(CDArkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public Tekstgrensesnitt getTekstgr() {
		return tekstgr;
	}

	public void setTekstgr(Tekstgrensesnitt tekstgr) {
		this.tekstgr = tekstgr;
	}

	public CDArkivADT getCda() {
		return cda;
	}

	public void setCda(CDArkivADT cda) {
		this.cda = cda;
	}

	/**
	 * Starter menyen!
	 */
	public void start() {
		// TODO Metode ikke laget enda
	}
} // class
