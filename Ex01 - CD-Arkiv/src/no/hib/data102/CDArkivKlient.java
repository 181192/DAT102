package no.hib.data102;

import no.hib.data102.adt.CDArkivADT;

public class CDArkivKlient {
	public static void main(String[] args) {
		// ... meny
		
		CDArkivADT cda = new CDArkiv();
		Meny meny = new Meny(cda);
		
		
		// alternativ:
		Meny meny2 = new Meny(cda);
		meny.start();
	}
} // class