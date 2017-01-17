package no.hib.data102;

import java.util.Scanner;

import no.hib.data102.adt.CDArkivADT;

/**
 * Klasse for meny
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Meny {

	private Tekstgrensesnitt tekstgr;
	private CDArkivADT cda;
	private int valg;

	public Meny(CDArkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public Tekstgrensesnitt getTekstgr() {
		return tekstgr;
	}

	public void setTekstgr(Tekstgrensesnitt tekstgr) {
		this.tekstgr = tekstgr;
	}

	public CDArkivADT getCda() {
		return cda;
	}

	public void setCda(CDArkivADT cda) {
		this.cda = cda;
	}

	/**
	 * Starter menyen!
	 */
	public void start() {

		Scanner tast = new Scanner(System.in);
		hovedmeny(tast);

	}

	public void hovedmeny(Scanner tast) {
		String meny = "\n1 - Les eksisterende arkiv fra fil" + "\n2 - Opprett nytt arkiv" + "\n3 - Avslutt"
				+ "\n\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Les eksisterende arkiv fra fil
				BrukEksisterendeArkivMeny(tast);

				break;
			case 2:
				// Opprett nytt arkiv
				OpprettNyttArkivMeny(tast);
				break;
			case 3: // Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 3);
	}

	public void ValgArkiv(Scanner tast) {
		String meny = "\n1 - Legg til ny CD" + "\n2 - Slett en CD" + "\n3 - Vis en CD" + "\n4 - Søk på tittel"
				+ "\n5 - Søk på artist" + "\n6 - Skriv ut statistikk" + "\n7 - Tilbake til hovedmeny" + "\n\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Legg til ny CD
				CD nyCd = tekstgr.lesCd();
				cda.leggTilCd(nyCd);
				break;
			case 2:
				// Slett en CD
				System.out.print("Oppgi CD-nummer: ");
				int cdNr = tast.nextInt();
				cda.slettCd(cdNr);
				break;
			case 3:
				// Vis en CD
				System.out.print("Oppgi CD-nummer");
				// vent med denne...
				break;
			case 4:
				// Søk på tittel
				System.out.print("Søk på tittel: ");
				String delstreng = tast.next();
				tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
				break;
			case 5:
				// Søk på artist
				System.out.print("Søk på artist: ");
				String delstreng2 = tast.next();
				tekstgr.skrivUtCdArtist(cda, delstreng2);
				break;
			case 6:
				// Skriv ut statistikk
				tekstgr.skrivUtStatistikk(cda);
				break;
			case 7:
				// Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 7);
	}

	public void OpprettNyttArkivMeny(Scanner tast) {

		System.out.print("Oppgi navn på arkiv: ");
		String navnPaaArkiv = tast.next();
		System.out.print("Hvor stort er arkivet? (heltall) ");
		int plasser = tast.nextInt();
		cda = new CDArkiv(plasser);
		
		ValgArkiv(tast);
		Fil.skrivTilFil(cda, navnPaaArkiv + ".txt", false);

	}

	public void BrukEksisterendeArkivMeny(Scanner tast) {
		System.out.print("Oppgi fil på arkiv: ");
		String filnavn = tast.next();
		Fil.lesFraFil(filnavn + ".txt");

		ValgArkiv(tast);
		Fil.skrivTilFil(cda, filnavn + ".txt", false);
	}

} // class
