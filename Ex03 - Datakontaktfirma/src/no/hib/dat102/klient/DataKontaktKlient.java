package no.hib.dat102.klient;

import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.utsyn.Meny;

/**
 * Klient for datakontakt
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class DataKontaktKlient {
	public static void main(String[] args) {
		Datakontakt datakt = new Datakontakt();
		Meny meny = new Meny(datakt);
		meny.start();
	} // main
} // class
