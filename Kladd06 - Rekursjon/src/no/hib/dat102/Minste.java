package no.hib.dat102;

public class Minste {
	public static void main(String[] args) {
		int[] tab = { 3242, -222, 332, 11, 43, 54, 4345, 0 };
		System.out.println("minste rek : " + finneMinste(tab));

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
		return finneMinsteRek(tab, siste);
	}

	private static int finneMinsteRek(int[] tab, int siste) {
		if (siste == 0) {
			return tab[siste];
		}
		int minste = finneMinsteRek(tab, (siste - 1));

		if (tab[siste] < minste) {
			return tab[siste];
		} else {
			return minste;
		}
	}
	
	public static int finneMinste2(int[] tab) {
		int siste = tab.length - 1;
		return finnMinste2Rek(tab, siste);
	}
	
	private static int finnMinste2Rek(int[] tab, int siste) {
		
		int minste = 0;
		return minste;
	}
}
