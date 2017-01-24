package no.hib.dat102;

import java.util.Random;

public class Test {

	public static boolean harDuplikat(long tabell[], long n) {
		int teller = 0;
		for (int indeks = 0; indeks <= n - 2; indeks++) {
//			System.out.print("\nIndeks: " + indeks);
//			System.out.print(" \t,Igjen: ");
			for (int igjen = indeks + 1; igjen <= n - 1; igjen++) {
				if (tabell[indeks] == tabell[igjen]) {
					return true;
				}
				teller++;
//				System.out.print(igjen + ", ");
			}

		}
		System.out.println("\nTeller: " + teller);
		System.out.println("Tabell lengde: " + tabell.length);
		return false;
	}

	public static int randomFill() {

		Random rand = new Random();
		int randomNum = rand.nextInt();
		return randomNum;
	}

	public static void main(String[] args) {
		int antall = 100000000;
		
		long[] anArray = new long[antall];
		for (int i = 0; i < anArray.length; i++) {
			anArray[i] = randomFill();
		}
		long start = 0;
		long slutt = 0;
		
		start = System.currentTimeMillis();
		System.out.println(start);
		harDuplikat(anArray, antall);
		slutt = System.currentTimeMillis();
		System.out.println(slutt);
		
		System.out.println("Tid brukt: " + (slutt - start));
	}
}
