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

	/**
	 * Hent metode
	 *
	 * @return tekstgr
	 */
	public Tekstgrensesnitt getTekstgr() {
		return tekstgr;
	}

	/**
	 * Sett metode
	 *
	 * @param tekstgr
	 *            setter tekstgr
	 */
	public void setTekstgr(Tekstgrensesnitt tekstgr) {
		this.tekstgr = tekstgr;
	}

	/**
	 * Hent metode
	 *
	 * @return cda
	 */
	public CDArkivADT getCda() {
		return cda;
	}

	/**
	 * Sett metode
	 *
	 * @param cda
	 *            setter cda
	 */
	public void setCda(CDArkivADT cda) {
		this.cda = cda;
	}

	/**
	 * Hent metode
	 *
	 * @return valg
	 */
	public int getValg() {
		return valg;
	}

	/**
	 * Sett metode
	 *
	 * @param valg
	 *            setter valg
	 */
	public void setValg(int valg) {
		this.valg = valg;
	}

	/**
	 * Hent metode
	 *
	 * @return tast
	 */
	public Scanner getTast() {
		return tast;
	}

	/**
	 * Sett metode
	 *
	 * @param tast
	 *            setter tast
	 */
	public void setTast(Scanner tast) {
		this.tast = tast;
	}

	/**
	 * Starter menyen!
	 */
	public void start() {
		tast = new Scanner(System.in);
		hovedmeny();
		tast.close();
	} // metode

	/**
	 * Hovedmeny for � lese eller opprette eksisterende arkiv
	 * 
	 */
	public void hovedmeny() {
		String meny = "\n1 - Les eksisterende arkiv fra fil" + "\n2 - Opprett nytt arkiv" + "\n3 - Avslutt"
				+ "\n\nValg: ";

		do {
			System.out.print(meny);
			valg = tast.nextInt();

			switch (valg) {
			case 1:
				// Les eksisterende arkiv fra fil
				System.out.print("Oppgi fil p� arkiv: ");
				String filnavn = tast.next();
				cda = Fil.lesFraFil(filnavn + ".txt");
				ValgArkiv();
				Fil.skrivTilFil(cda, filnavn + ".txt", false);
				break;
			case 2:
				// Opprett nytt arkiv
				System.out.print("Oppgi navn p� arkiv: ");
				String navnPaaArkiv = tast.next();
				ValgArkiv();
				Fil.skrivTilFil(cda, navnPaaArkiv + ".txt", false);
				break;
			case 3: // Avslutt
				break;
			default:
				System.out.println("Ukjent menyvalg");
			}
		} while (valg != 3);
	} // metode

	/**
	 * Undermeny for felles valg i menyen
	 * 
	 */
	public void ValgArkiv() {
		String meny = "\n1 - Legg til ny CD" + "\n2 - Slett en CD" + "\n3 - S�k p� tittel" + "\n4 - S�k p� artist"
				+ "\n5 - Skriv ut statistikk" + "\n6 - Tilbake til hovedmeny" + "\n\nValg: ";

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
				// S�k p� tittel
				System.out.print("S�k p� tittel: ");
				String delstreng = tast.next();
				tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
				break;
			case 4:
				// S�k p� artist
				System.out.print("S�k p� artist: ");
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
	} // metode
} // class
