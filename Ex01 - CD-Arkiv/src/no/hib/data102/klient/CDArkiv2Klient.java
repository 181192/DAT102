/**
 * 
 */
package no.hib.data102.klient;

import no.hib.data102.CDArkiv2;
import no.hib.data102.Meny;
import no.hib.data102.adt.CDArkivADT;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class CDArkiv2Klient {
	public static void main(String[] args) {
		CDArkivADT cda = new CDArkiv2();
		Meny meny = new Meny(cda);
		meny.start();
	} // main
} // class
