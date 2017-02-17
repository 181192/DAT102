package no.hib.dat102.modell;

import java.util.Iterator;

import no.hib.dat102.mengde.adt.MengdeADT;
import no.hib.dat102.mengde.kjedet.KjedetMengde;

/**
 * Representasjona av ett medlem
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Medlem {
	private String navn;
	private int statusIndeks;
	private MengdeADT<Hobby> hobbyer;

	public Medlem() {
		this("", -1);
	}

	public Medlem(String navn, int statusIndeks) {
		this.navn = navn;
		this.statusIndeks = statusIndeks;
		this.hobbyer = new KjedetMengde<Hobby>();
	}
	
	public Medlem(String navn, int statusIndeks, MengdeADT<Hobby> hobbyer) {
		this.navn = navn;
		this.statusIndeks = statusIndeks;
		this.hobbyer = new KjedetMengde<Hobby>();
	}

	/**
	 * @return the navn
	 */
	public String getNavn() {
		return navn;
	}

	/**
	 * @param navn
	 *            the navn to set
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * @return the hobbyer
	 */
	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	/**
	 * @param hobbyer
	 *            the hobbyer to set
	 */
	public void setHobbyer(MengdeADT<Hobby> hobbyer) {
		this.hobbyer = hobbyer;
	}

	/**
	 * @return the statusIndeks
	 */
	public int getStatusIndeks() {
		return statusIndeks;
	}

	/**
	 * @param statusIndeks
	 *            the statusIndeks to set
	 */
	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	/**
	 * Skriver ut data om ett medlem
	 */
	public void skrivUt() {
		Iterator<Hobby> teller = hobbyer.oppramser();

		System.out.println("Navn: " + navn);
		while (teller.hasNext()) {
			System.out.println(teller.next().toString());
		}
		System.out.println("Status: " + statusIndeks);
	}

	/**
	 * Avgj�r om to medlemmer passer til hverandre, alts� kan danne et par. To
	 * medlemmer passer til hverandre dersom de har n�yaktig samme hobbyer.
	 * 
	 * @param medlem2
	 *            Medlem som skal sammenlignes med
	 * @return true visst medlemmene passer hverandre
	 */
	public boolean passerTil(Medlem medlem2) {
		return hobbyer.erLik(medlem2.getHobbyer());
	}

}
