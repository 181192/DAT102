package no.hib.dat102.modell;

public class Rekursjon {
	
	public static void snuTall(int tall) {
		System.out.print(tall % 10);
		
		if ((tall / 10) != 0) {
			snuTall(tall/10);
		}
	}
	
	public static void snuTabell(int[] tab) {
		int foerste = 0;
		int siste = tab.length - 1;
		snuTabellRek(tab, foerste, siste);
	
	}
	
	private static void snuTabellRek(int[] tab, int m, int n) {
		if (m < n) {
			int temp = tab[m];
			tab[m] = tab[n];
			tab[n] = temp;
			snuTabellRek(tab, (m + 1), (n - 1));
		}
		
	}
	
	public static int sumKvadOpp(int m, int n) {
		int svar;
		if (m < n) {
			svar = m * (m + sumKvadOpp((m + 1), n));
		} else {
			svar = n * n;
		}
		return svar;
	}
	
	public static int sumKvadNed(int m, int n) {
		int svar;
		if (m < n) {
			svar = n * (n + sumKvadNed(m, (n - 1)));
		} else {
			svar = m * m;
		}
		return svar;
	}
}
