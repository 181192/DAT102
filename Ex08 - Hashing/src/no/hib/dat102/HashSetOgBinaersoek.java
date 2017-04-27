package no.hib.dat102;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class HashSetOgBinaersoek {
	public static void main(String[] args) {
		int antElement = 100000;
		int antVerdier = 10000;
		int tall = 376;

		Integer[] intTab = new Integer[antElement];
		HashSet<Integer> intSet = new HashSet<>();
		
		Integer[] verdier = new Integer[antVerdier];
		Random r = new Random();
		
		for (int i = 0; i < antElement; i++) {
			intTab[i] = tall;
			intSet.add(tall);
			tall = (tall + 45713) % 1000000;
		}
		
		for (int i = 0; i < antVerdier; i++) {
			verdier[i] = r.nextInt(999999);
		}
		
		Arrays.sort(intTab);
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < verdier.length - 1; i++) {
			binaerSoek(intTab, 0, intTab.length - 1, verdier[i]);
		}
		long slutt = System.currentTimeMillis();
		
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < verdier.length - 1; i++) {
			intSet.contains(verdier[i]);
		}
		long slutt2 = System.currentTimeMillis();
		
		
		System.out.println("Integer tabell: " + (slutt-start) + " ms.");
		System.out.println("HashSet : " + (slutt2-start2) + " ms.");
	}

	public static <T extends Comparable<T>> int binaerSoek(T[] data, int min, int maks, T el) {
		if (min > maks) {
			return -1;
		}
		int midtpunkt = (min + maks) / 2;
		int resultat = el.compareTo(data[midtpunkt]);
		if (resultat == 0) {
			return midtpunkt;
		}
		if (resultat < 0) {
			return binaerSoek(data, min, midtpunkt - 1, el);
		} else {
			return binaerSoek(data, midtpunkt + 1, maks, el);
		}
	}
}
