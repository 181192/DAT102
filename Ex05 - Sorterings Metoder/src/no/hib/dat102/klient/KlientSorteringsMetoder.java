package no.hib.dat102.klient;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import no.hib.dat102.sortering.SorteringsMetoder;

public class KlientSorteringsMetoder {
	private static Integer[] tab;
	private static Random tall;
	private static int valg;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		SorteringsMetoder<Integer> s = new SorteringsMetoder<Integer>();
		tab = new Integer[100000];
		tall = new Random();

		String meny = "\n1 - Utvalg\n" + "2 - Insetting\n" + "3 - Boble\n" + "4 - Kvikk\n" + "5 - Flette\n"
				+ "6 - Radix\n" + "7 - Array.sort\n" + "8 - Avslutt\n" + "\nValg: ";
		do {
			System.out.print(meny);
			valg = tast.nextInt();
			switch (valg) {
			case 1:
				// Utvalg
				lagTabell();
				Instant foer1 = Instant.now();
				s.utvalgsSortering(tab);
				Instant etter1 = Instant.now();
				tiden(foer1, etter1);
				break;
			case 2:
				// Insetting
				lagTabell();
				Instant foer2 = Instant.now();
				s.sorteringVedInsetting(tab);
				Instant etter2 = Instant.now();
				tiden(foer2, etter2);
				break;
			case 3:
				// Boble
				lagTabell();
				Instant foer3 = Instant.now();
				s.bobleSort(tab);
				Instant etter3 = Instant.now();
				tiden(foer3, etter3);
				break;
			case 4:
				// Kvikk
				lagTabell();
				Instant foer4 = Instant.now();
				s.kvikkSort(tab, 0, tab.length - 1);
				Instant etter4 = Instant.now();
				tiden(foer4, etter4);
				break;
			case 5:
				// Flette
				lagTabell();
				Instant foer5 = Instant.now();
				s.fletteSort(tab, 0, tab.length - 1);
				Instant etter5 = Instant.now();
				tiden(foer5, etter5);
				break;
			case 6:
				// Radix
				lagTabell();
				Instant foer6 = Instant.now();
				s.radixSort(tab, 0);
				Instant etter6 = Instant.now();
				tiden(foer6, etter6);
				break;
			case 7:
				// array.sort
				lagTabell();
				Instant foer7 = Instant.now();
				Arrays.sort(tab);
				Instant etter7 = Instant.now();
				tiden(foer7, etter7);
				break;
			case 8:
				// Avslutt
				break;
			}
		} while (valg != 8);

		tast.close();
	}

	public static void tiden(Instant foer, Instant etter) {
		Duration tid = Duration.between(foer, etter);

		System.out.println("Tid i millisekund: " + tid.toMillis());
	}

	public static void lagTabell() {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = tall.nextInt(10000);
		}
	}
	

}
