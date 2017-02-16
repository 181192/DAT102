package no.hib.dat102.utsyn;

import java.util.Scanner;

import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.modell.Medlem;

/**
 * Meny klasse
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Meny {
	private Tekstgrensesnitt tekstgr;
	private Datakontakt datakt;
	private int valg;
	private Scanner tast;

	public Meny(Datakontakt arkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.datakt = arkiv;
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
				System.out.println("Ikke implimentert enda! ");
				break;
			case 2:
				// Opprett nytt arkiv
				underMeny();
				break;
			case 3: // Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 3);
	}

	public void underMeny() {
		String meny = "\n1 - Legg til nytt medlem" //
				+ "\n2 - Finn medlem" //
				+ "\n3 - Finn partner" //
				+ "\n4 - Skriv ut alle hobbyer til medlem" //
				+ "\n5 - Skriv ut par med hobbyer" //
				+ "\n6 - Tilbake til hovedmeny" //
				+ "\n\nValg: "; //

		String medlemsnavn = "";
		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Legg til nytt medlem
				Medlem nyttMedlem = tekstgr.lesMedlem();
				datakt.leggTilMedlem(nyttMedlem);
				break;
			case 2:
				// Finn medlem
				System.out.println("Oppgi navn på medlem: ");
				medlemsnavn = tast.next();
				System.out.println("Medlems indeks: " + datakt.finnMedlemsIndeks(medlemsnavn));
				break;
			case 3:
				// Finn partner
				System.out.println("Oppgi navn på medlem: ");
				medlemsnavn = tast.next();
				datakt.finnPartnerFor(medlemsnavn);
				break;
			case 4:
				// Skriv ut alle hobbyer til medlem
				System.out.println("Oppgi navn på medlem: ");
				medlemsnavn = tast.next();
//				tekstgr.skrivHobbyListe(medlem);
				break;
			case 5:
				// Skriv ut par med hobbyer
				tekstgr.skrivParListe(datakt);
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
