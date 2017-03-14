package no.hib.dat102;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class KlientSorteringsMetoder {
	private static Integer[] tab;
	private static Random tall;
	private static int valg;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		SorteringsMetoder<Integer> s = new SorteringsMetoder<Integer>();
		tab = new Integer[100000000];
		tall = new Random();

		String meny = "\n1 - Utvalg\n" + "2 - Insetting\n" + "3 - Boble\n" + "4 - Kvikk\n" + "5 - Flette\n"
				+ "6 - Array.sort\n" + "7 - Avslutt\n" + "\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();
			switch (valg) {
			case 1:
				lagTabell();
				Instant foer1 = Instant.now();
				s.utvalgsSortering(tab);
				Instant etter1 = Instant.now();
				tiden(foer1, etter1);
				break;
			case 2:
				lagTabell();
				Instant foer2 = Instant.now();
				s.sorteringVedInsetting(tab);
				Instant etter2 = Instant.now();
				tiden(foer2, etter2);
				break;
			case 3:
				lagTabell();
				Instant foer3 = Instant.now();
				s.bobleSort(tab);
				Instant etter3 = Instant.now();
				tiden(foer3, etter3);
				break;
			case 4:
				lagTabell();
				Instant foer4 = Instant.now();
				s.kvikkSort(tab, 0, tab.length - 1);
				Instant etter4 = Instant.now();
				tiden(foer4, etter4);
				break;
			case 5:
				lagTabell();
				Instant foer5 = Instant.now();
				s.fletteSort(tab, 0, tab.length - 1);
				Instant etter5 = Instant.now();
				tiden(foer5, etter5);
				break;
			case 6:
				lagTabell();
				Instant foer6 = Instant.now();
				Arrays.sort(tab);
				Instant etter6 = Instant.now();
				tiden(foer6, etter6);
				break;
			case 7:
				// Avslutt
				break;
			}
		} while (valg != 7);

		tast.close();
	}

	public static void tiden(Instant foer, Instant etter) {
		Duration tid = Duration.between(foer, etter);

		System.out.println("Tid i millisekund: " + tid.toMillis());
	}

	public static void lagTabell() {
		for (int i = 0; i < tab.length; i++) {
			tab[i] = tall.nextInt(100);
		}
	}
}
