package no.hib.dat102.klient;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

import no.hib.dat102.adt.SorteringADT;
import no.hib.dat102.sortering.BobleSortering;
import no.hib.dat102.sortering.FletteSortering;
import no.hib.dat102.sortering.InnsettingSortering;
import no.hib.dat102.sortering.Kvikk2Sortering;
import no.hib.dat102.sortering.KvikkSortering;
import no.hib.dat102.sortering.UtvalgSortering;

/**
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class KlientSortering {
	private static int valg;

	public static void main(String[] args) {
		Scanner tast = new Scanner(System.in);
		String pynt = "|Algoritme\t|" + "n\t|"+ "Antall Målinger\t|" + "Målttid\t|" + "Teoretisk tid (c * f(n))|";
		String linje = "|---------------|-------|-----------------------|---------------|------------------------|";
		String meny = "\n1 - Utvalg\n" //
				+ "2 - Insetting\n" //
				+ "3 - Boble\n" //
				+ "4 - Kvikk\n" //
				+ "5 - Flette\n" //
				+ "6 - Kvikk2\n"
				+ "7 - Avslutt\n" //
				+ "\nValg: "; //
		
		do {
			System.out.print(meny);
			valg = tast.nextInt();
			switch (valg) {
			case 1:
				// Utvalg
				double c1 = 1047.93*Math.pow(10, -9);
				System.out.println(pynt);
				System.out.println(linje);
				sortering(new UtvalgSortering<Integer>(), "Utvalg", 32000, c1);
				sortering(new UtvalgSortering<Integer>(), "Utvalg", 64000, c1);
				sortering(new UtvalgSortering<Integer>(), "Utvalg", 128000,c1);
				break;
			case 2:
				// Insetting
				double c2 = 859.31*Math.pow(10, -9);
				System.out.println(pynt);
				System.out.println(linje);
				sortering(new InnsettingSortering<Integer>(), "Innset", 32000, c2);
				sortering(new InnsettingSortering<Integer>(), "Innset", 64000, c2);
				sortering(new InnsettingSortering<Integer>(), "Innset", 128000, c2);
				break;
			case 3:
				// Boble
				double c3 = 1579.79*Math.pow(10, -9);
				System.out.println(pynt);
				System.out.println(linje);
				sortering(new BobleSortering<Integer>(), "Boble", 32000, c3);
				sortering(new BobleSortering<Integer>(), "Boble", 64000, c3);
				sortering(new BobleSortering<Integer>(), "Boble", 128000, c3);
				break;
			case 4:
				// Kvikk
				double c4 = 12207.33*Math.pow(10, -9);
				System.out.println(pynt);
				System.out.println(linje);
				sortering(new KvikkSortering<Integer>(), "Kvikk", 32000, c4);
				sortering(new KvikkSortering<Integer>(), "Kvikk", 64000, c4);
				sortering(new KvikkSortering<Integer>(), "Kvikk", 128000, c4);
				break;
			case 5:
				// Flette
				double c5 = 17072.43*Math.pow(10, -9);
				System.out.println(pynt);
				System.out.println(linje);
				sortering(new FletteSortering<Integer>(), "Flette", 32000, c5);
				sortering(new FletteSortering<Integer>(), "Flette", 64000, c5);
				sortering(new FletteSortering<Integer>(), "Flette", 128000, c5);
				break;
			case 6:
				double c6 = 8435.92*Math.pow(10, -9);
				System.out.println(pynt);
				System.out.println(linje);
				sortering(new Kvikk2Sortering<Integer>(), "Kvikk2", 32000, c6);
				sortering(new Kvikk2Sortering<Integer>(), "Kvikk2", 64000, c6);
				sortering(new Kvikk2Sortering<Integer>(), "Kvikk2", 128000, c6);
				break;
			case 7:
				// Avslutt
				break;
			}
		} while (valg != 7);
		tast.close();
	}

	public static void sortering(SorteringADT<Integer> s, String type, int n, double c) {
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
		
		
		System.out.println(("|"+ type + "\t\t|" + n + "\t|" + antall + "\t\t\t|"+ (tid.toMillis() / antall) + "\t\t|" + s.funksjon(n, c)));
	}
}
