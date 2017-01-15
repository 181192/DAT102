package no.hib.dat102;

import java.util.Scanner;

public class KlientButikk {
	private static Butikk butikk = null;
	private static int valg;
	private static int valg2;
	private static int varenr;

	/**
	 * 
	 * @param tast
	 */
	public static void opprettButikk(Scanner tast) {
		System.out.print("Tast inn navn på butikk: ");
		String navn = tast.next();
		System.out.print("Tast inn antall lagerplasser: ");
		int lagerplasser = tast.nextInt();
		butikk = new Butikk(navn, lagerplasser);
	}

	public static void lesInnFil(Scanner tast) {
		System.out.println("Ikke implimentert");

	}

	public static void leggeTilVarer(Scanner tast) {
		if (butikk.erLedigPlass()) {
			System.out.print("Tast inn varenummer: ");
			varenr = tast.nextInt();
			butikk.leggInnNyVare(varenr);
		} else {
			System.out.println("Ikke plass til flere varer");
		}
	}

	public static void LesingAvVarer(Scanner tast) {
		if (butikk != null) {
			System.out.print(
					"1 - Legg til ny vare" + "\n2 - Les inn fil" + "\n3 - Avslutt lesing av varer" + "\nValg : ");
			do {
				valg2 = tast.nextInt();
				switch (valg2) {
				case 1:
					leggeTilVarer(tast);
					break;
				case 2:
					lesInnFil(tast);
					break;
				case 3:
					// Avslutt
					break;
				default:
					System.out.println("Ukjent meny valg");
				}
			} while (valg2 != 3);
		} else {
			System.out.println("Opprett butikk først!");
		}
	}

	public static void grossInnkjøp(Scanner tast) {
		if (butikk != null) {
			System.out.print("Tast inn varenummer: ");
			varenr = tast.nextInt();
			System.out.print("Tast inn antall: ");
			int tall = tast.nextInt();
			butikk.grossInnkjøp(varenr, tall);
		} else {
			System.out.println("Opprett butikk først!");
		}
	}

	public static void totalVerdi(Scanner tast) {
		if (butikk != null) {
			butikk.salgVerdi();
		} else {
			System.out.println("Opprett butikk først!");
		}
	}

	public static void slettVare(Scanner tast) {
		if (butikk != null) {
			System.out.print("Tast inn varenummer for å slette: ");
			varenr = tast.nextInt();
			butikk.slettVare(varenr);
		} else {
			System.out.println("Opprett butikk først!");
		}
	}

	public static void detaljSalg(Scanner tast) {
		if (butikk != null) {
			System.out.print("Tast inn varenummer: ");
			varenr = tast.nextInt();
			butikk.detaljSalg(varenr);
		} else {
			System.out.println("Opprett butikk først!");
		}
	}

	public static void main(String[] args) {

		Scanner tast = new Scanner(System.in);
		String meny = "\n1 - Opprett butikk" + "\n2 - Lese varer fra fil eller legge inn varer" + "\n3 - Gross Innkjøp"
				+ "\n4 - Totalverdi av alle varer i butikk" + "\n5 - Slett en vare" + "\n6 - Detalj salg"
				+ "\n7 - Avslutt" + "\n\nValg : ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Opprett butikk
				opprettButikk(tast);
				break;
			case 2:
				// Lese fra fil eller legge inn varer
				LesingAvVarer(tast);
				break;
			case 3:
				// Gross Innkjøp
				grossInnkjøp(tast);
				break;
			case 4:
				// Totalverdi av alle varer i butikk
				totalVerdi(tast);
				break;
			case 5:
				// Slett en vare
				slettVare(tast);
				break;
			case 6:
				// Detalj salg
				detaljSalg(tast);
				break;
			case 7:
				// avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 7);
		tast.close();
	} // main
} // class
