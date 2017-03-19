package no.hib.dat102.klient;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

import no.hib.dat102.adt.SorteringADT;
import no.hib.dat102.sortering.BobleSortering;
import no.hib.dat102.sortering.FletteSortering;
import no.hib.dat102.sortering.InnsettingSortering;
import no.hib.dat102.sortering.KvikkSortering;
import no.hib.dat102.sortering.UtvalgSortering;

public class KlientSortering {
	private static int valg;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);

		String meny = "\n1 - Utvalg\n" //
				+ "2 - Insetting\n" //
				+ "3 - Boble\n" //
				+ "4 - Kvikk\n" //
				+ "5 - Flette\n" //
				+ "6 - Radix\n" //
				+ "7 - Array.sort\n" //
				+ "8 - Avslutt\n" //
				+ "\nValg: "; //
		
		System.out.print("Oppgi antall elementer: ");
		int antall = tast.nextInt();
		do {
			System.out.print(meny);
			valg = tast.nextInt();
			switch (valg) {
			case 1:
				// Utvalg
				sortering(new UtvalgSortering<Integer>(), antall);
				break;
			case 2:
				// Insetting
				sortering(new InnsettingSortering<Integer>(), antall);
				break;
			case 3:
				// Boble
				sortering(new BobleSortering<Integer>(), antall);
				break;
			case 4:
				// Kvikk
				sortering(new KvikkSortering<Integer>(), antall);
				break;
			case 5:
				// Flette
				sortering(new FletteSortering<Integer>(), antall);
				break;
			case 6:
				// Radix

				break;
			case 7:
				// array.sort

				break;
			case 8:
				// Avslutt
				break;
			}
		} while (valg != 8);

		tast.close();
	}

	public static void sortering(SorteringADT<Integer> s, int n) {
		Random tilfeldig = new Random();
		int antall = 10;

		Integer[][] a = new Integer[antall][n];

		// sett inn tilfeldige heltall i alle rekker
		for (int i = 0; i < antall; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = tilfeldig.nextInt();
			}
		}
		Instant foer = Instant.now();
		for (int i = 0; i < antall; i++) {
			s.sorter(a[i]);
		}
		Instant etter = Instant.now();

		Duration tid = Duration.between(foer, etter);

		System.out.println("Tid i millisekund: " + tid.toMillis() / antall);
	}
}
