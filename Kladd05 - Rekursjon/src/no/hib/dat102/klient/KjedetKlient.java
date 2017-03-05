package no.hib.dat102.klient;

import no.hib.dat102.liste.kjedet.KjedetOrdnetListe;

public class KjedetKlient {
	public static void main(String[] args) {
		KjedetOrdnetListe<String> liste = new  KjedetOrdnetListe<String>();
		String s1 = "hei";
		String s2 = "på";
		String s3 = "deg";
		String s4 = "din";
		String s5 = "raring";
		
		liste.leggTil(s1);
		liste.leggTil(s2);
		liste.leggTil(s3);
		liste.leggTil(s4);
		liste.leggTil(s5);
		
		System.out.println(liste.toString());
		System.out.println(liste.toString2());
	}
}
