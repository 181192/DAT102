package no.hib.dat102;

public class Minste {
	public static void main(String[] args) {
		int[] tab = { 3242, 222, -332, 11, 43, 54, 4345, 0 };
		System.out.println("minste rek : " + finneMinste(tab));
		System.out.println("minste rek2: " + finneMinste2(tab));

		// vanlig tabell for å finne minste
		int minste = tab[0];
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] < minste) {
				minste = tab[i];
			}
		}
		System.out.println("minste tallet : " + minste);

	}

	public static int finneMinste(int[] tab) {
		int siste = tab.length - 1;
		int start = 0;
		return finnMinsteRek(tab, start, siste);
	}

	private static int finnMinsteRek(int[] tab, int start, int lengde) {
		if (lengde > start) {
			return Math.min(tab[lengde], finnMinsteRek(tab, start, lengde - 1));
		} else {
			return tab[start];
		}
	}

	public static int finneMinste2(int[] tab) {
		int siste = tab.length - 1;
		int foerste = 0;
		int midten = (foerste + siste) / 2;

		return Math.min(finnMinsteRek(tab, foerste, midten), finnMinsteRek(tab, (midten + 1), siste));
	}
	
	// private static int finneMinsteRek(int[] tab, int siste) {
	// if (siste == 0) {
	// return tab[siste];
	// }
	// int minste = finneMinsteRek(tab, (siste - 1));
	//
	// if (tab[siste] < minste) {
	// return tab[siste];
	// } else {
	// return minste;
	// }
	// }

	// private static int finnMinste2Rek(int[] tab, int foerste, int siste) {
	// if (foerste == siste) {
	// return tab[foerste];
	// }
	// int midten = (foerste + siste) / 2;
	// int min1 = finnMinste2Rek(tab, foerste, midten);
	// int min2 = finnMinste2Rek(tab, (midten + 1), siste);
	// return Math.min(min1, min2);
	// }
}
