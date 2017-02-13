package no.hib.dat102.klient;

import no.hib.dat102.SpesiellKjedetStruktur;

public class SpesiellKjedetStrukturKlient {
	public static void main(String[] args) {
		SpesiellKjedetStruktur<Character> spesiell = new SpesiellKjedetStruktur<Character>();

		String streng = "Kristoffer-Andre er kjempe kul";

		System.out.println(streng);
		int lengde = streng.length();
		for (int i = 0; i < lengde; i++) {
			spesiell.leggTil(new Character(streng.charAt(i)));
		}
		System.out.println(spesiell);

		spesiell.snuKjedetStruktur();

		System.out.println(spesiell);
		System.out.println(spesiell.finnAntalLik('e'));

	}// main
}
