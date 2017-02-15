package no.hib.dat102.utsyn;

import java.util.Scanner;

import no.hib.dat102.modell.Datakontakt;

/**
 * Meny klasse
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Meny {
	private Tekstgrensesnitt tekstgr;
	private Datakontakt arkiv;
	private int valg;
	private Scanner tast;

	public Meny(Datakontakt arkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.arkiv = arkiv;
	}

	public void start() {
		tast = new Scanner(System.in);
		hovedMeny();
		tast.close();
	}

	public void hovedMeny() {
		String meny = "\n1 - Les eksisterende arkiv fra fil" + "\n2 - Opprett nytt arkiv" + "\n3 - Avslutt"
				+ "\n\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Les eksisterende arkiv fra fil

				break;
			case 2:
				// Opprett nytt arkiv

				break;
			case 3: // Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 3);
	}

	public void underMeny() {
		String meny = "\n1 - Legg til nytt medlem" + "\n2 - Slett ett medlem" + "\n3 - Finn partner"
				+ "\n4 - Skriv ut alle hobbyer til medlem" + "\n5 - Skriv ut par med hobbyer"
				+ "\n6 - Tilbake til hovedmeny" + "\n\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Legg til nytt medlem
				break;
			case 2:
				// Slett ett medlem
				break;
			case 3:
				// Finn partner
				break;
			case 4:
				// Skriv ut alle hobbyer til medlem
				break;
			case 5:
				// Skriv ut par med hobbyer
				break;
			case 6:
				// Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 6);
	}
}
