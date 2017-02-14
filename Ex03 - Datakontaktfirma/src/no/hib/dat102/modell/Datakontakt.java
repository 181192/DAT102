package no.hib.dat102.modell;

public class Datakontakt {
	private Medlem[] medlemstabell;
	private int antallMedlemmer;

	/**
	 * Legger til et nytt medlem i medlemstabellen
	 * 
	 * @param person
	 *            Medlem som skal legges til
	 */
	public void leggTilMedlem(Medlem person) {

	}

	/**
	 * Finner indeksen til medlemmet i medlemstabellen dersom medlemmet er
	 * registrert, ellers returneres indeks lik -1.
	 * 
	 * @param medlemsnavn
	 *            Medlemsnavn
	 * @return Indeks til medlemmet, ellers -1
	 */
	public int finnMedlemsIndeks(String medlemsnavn) {
		return -1;
	}

	/**
	 * Finner ut om et medlem (identifisert med medlemsnavn) passer med et annet
	 * medlem (dersom det finnes i medlemstabellen. Dette medlemmet skal være
	 * det første som passer og ikke er "koblet". Metoden oppdaterer
	 * medlemstabellen dersom det finner en partner, og returnerer eventuell
	 * indeks til partneren i medlemstabellen (eller -1).
	 * 
	 * @param medlemsnavn
	 *            Medlemsnavn
	 * @return Indeks til partner, ellers -1.
	 */
	public int finnPartnerFor(String medlemsnavn) {
		return -1;
	}

	/**
	 * Oppdaterer medlemstabellen, slik at dette medlemmet(identifisert ved
	 * medlemsnavn) og dets partner, dersom det fins, ikke lenger er "koblet"
	 * (dvs. begge får statusindeks -1)
	 * 
	 * @param medlemsnavn Medlemsnavn
	 */
	public void tilbakestillStatusIndeks(String medlemsnavn) {

	}
}
