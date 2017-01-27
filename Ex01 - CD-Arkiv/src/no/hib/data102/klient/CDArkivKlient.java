package no.hib.data102.klient;

import no.hib.data102.CDArkiv;
import no.hib.data102.Meny;
import no.hib.data102.adt.CDArkivADT;

/**
 * Main metode for CDArkiv
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class CDArkivKlient {
	public static void main(String[] args) {
		CDArkivADT cda = new CDArkiv();
		Meny meny = new Meny(cda);
		meny.start();
	}
} // class
