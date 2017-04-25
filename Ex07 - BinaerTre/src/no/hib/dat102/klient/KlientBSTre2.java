package no.hib.dat102.klient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import no.hib.dat102.bst.adt.BSTreADT;
import no.hib.dat102.bst.kjedet.KjedetBSTre;

public class KlientBSTre2 {
	private static List<BSTreADT<Integer>> tab;
	private static final int ANTALL_NODER = 1024;
	private static final int ANTALL_TRE = 100;
	private static Random tilfeldig;

	public static void main(String[] args) {

		tilfeldig = new Random();
		tab = new ArrayList<>(ANTALL_TRE);
		int sum = 0;
		int hoyde = 0;
		int minste = ANTALL_NODER;
		int storste = 0;
		for (int i = 0; i < ANTALL_TRE; i++) {
			tab.add(new KjedetBSTre<Integer>());
			for (int j = 0; j < ANTALL_NODER; j++) {
				Integer element = new Integer(tilfeldig.nextInt(100));
				tab.get(i).leggTil(element);
			}
			hoyde = tab.get(i).finnHoyde() - 1;
			sum += hoyde;

			if (hoyde < minste) {
				minste = hoyde;
			}
			if (hoyde > storste) {
				storste = hoyde;
			}
		}

		System.out.println("Antall noder: " + tab.get(0).antall());

		System.out
				.println("\nMinimal teoretisk høyde: " + Math.round(((Math.log(ANTALL_NODER + 1) / Math.log(2)) - 1)));

		System.out.println("\nMaksimal teoretisk høyde: " + (ANTALL_NODER - 1));

		System.out.println("\nSnitt høyde: " + (sum / ANTALL_TRE));

		System.out.println("Minste høyde: " + minste);

		System.out.println("Høyeste høyde: " + storste);
	}
}
