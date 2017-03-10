package no.hib.dat102;

public class FibbonacciRekursjon {
	public static void main(String[] args) {
		int n = 50;
		float start = System.currentTimeMillis();

		System.out.println("Fibbonacci tallet " + n + " er " + fibbonacci(n));

		float slutt = System.currentTimeMillis();

		System.out.println("Tid brukt: " + (slutt - start));
	}

	public static int fibbonacci(int n) {
		int svar;
		if (n > 2) {
			svar = fibbonacci(n - 1) + fibbonacci(n - 2);
		} else {
			if (n == 0) {
				svar = 0;
			} else {
				svar = 1;
			}
		}
		return svar;
	}
}
