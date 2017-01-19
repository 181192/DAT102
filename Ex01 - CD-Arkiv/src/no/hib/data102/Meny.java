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
	private Scanner tast;

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

	public int getValg() {
		return valg;
	}

	public void setValg(int valg) {
		this.valg = valg;
	}

	/**
	 * Starter menyen!
	 */
	public void start() {
		tast = new Scanner(System.in);
		hovedmeny();
		tast.close();
	}

	public void hovedmeny() {
		String meny = "\n1 - Les eksisterende arkiv fra fil" + "\n2 - Opprett nytt arkiv" + "\n3 - Avslutt"
				+ "\n\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Les eksisterende arkiv fra fil
				BrukEksisterendeArkivMeny();

				break;
			case 2:
				// Opprett nytt arkiv
				OpprettNyttArkivMeny();
				break;
			case 3: // Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 3);
	}

	public void ValgArkiv() {
		String meny = "\n1 - Legg til ny CD" + "\n2 - Slett en CD" + "\n3 - Søk på tittel"
				+ "\n4 - Søk på artist" + "\n5 - Skriv ut statistikk" + "\n6 - Tilbake til hovedmeny" + "\n\nValg: ";

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
				// Søk på tittel
				System.out.print("Søk på tittel: ");
				String delstreng = tast.next();
				tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
				break;
			case 4:
				// Søk på artist
				System.out.print("Søk på artist: ");
				String delstreng2 = tast.next();
				tekstgr.skrivUtCdArtist(cda, delstreng2);
				break;
			case 5:
				// Skriv ut statistikk
				tekstgr.skrivUtStatistikk(cda);
				break;
			case 6:
				// Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 6);
	}

	public void OpprettNyttArkivMeny() {

		System.out.print("Oppgi navn på arkiv: ");
		String navnPaaArkiv = tast.next();
		System.out.print("Hvor stort er arkivet? (heltall) ");
		int plasser = tast.nextInt();
		cda = new CDArkiv(plasser);

		ValgArkiv();
		Fil.skrivTilFil(cda, navnPaaArkiv + ".txt", false);

	}

	public void BrukEksisterendeArkivMeny() {
		System.out.print("Oppgi fil på arkiv: ");
		String filnavn = tast.next();

		cda = Fil.lesFraFil(filnavn + ".txt");

		ValgArkiv();
		Fil.skrivTilFil(cda, filnavn + ".txt", false);
	}

} // class
