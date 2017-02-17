package no.hib.dat102.klient;

import no.hib.dat102.mengde.kjedet.KjedetMengde;
import no.hib.dat102.modell.Datakontakt;
import no.hib.dat102.modell.Hobby;
import no.hib.dat102.modell.Medlem;
import no.hib.dat102.utsyn.Tekstgrensesnitt;

public class DatakontaktKlient2 {
	public static void main(String[] args) {
		Datakontakt datakt = new Datakontakt();
		Tekstgrensesnitt tekstgr = new Tekstgrensesnitt();
		KjedetMengde<Hobby> hobbyerM1 = new KjedetMengde<Hobby>();
		KjedetMengde<Hobby> hobbyerM2 = new KjedetMengde<Hobby>();
		KjedetMengde<Hobby> hobbyerM3 = new KjedetMengde<Hobby>();

		// Hobbyer
		Hobby h1 = new Hobby("Ski");
		Hobby h2 = new Hobby("Musikk");
		Hobby h3 = new Hobby("Løping");
		Hobby h4 = new Hobby("Fisking");
		Hobby h5 = new Hobby("Klatring");

		// Legger til hobbyer i mengder
		hobbyerM1.leggTil(h1);
		hobbyerM1.leggTil(h2);
		hobbyerM1.leggTil(h3);

		hobbyerM2.leggTil(h1);
		hobbyerM2.leggTil(h2);
		hobbyerM2.leggTil(h3);

		hobbyerM3.leggTil(h3);
		hobbyerM3.leggTil(h4);
		hobbyerM3.leggTil(h5);

		// Legger til medlemmer
		Medlem m1 = new Medlem("Ole", -1);
		Medlem m2 = new Medlem("Kari", -1);
		Medlem m3 = new Medlem("Nils", -1);
		m1.setHobbyer(hobbyerM1);
		m2.setHobbyer(hobbyerM2);
		m3.setHobbyer(hobbyerM3);
		
		datakt.leggTilMedlem(m1);
		datakt.leggTilMedlem(m2);
		datakt.leggTilMedlem(m3);
		
		System.out.println("Medlemmer: ");
		for (int i = 0; i < datakt.getAntallMedlemmer(); i++) {
			System.out.println(datakt.getMedlemstabell()[i].getNavn() + "\t" + datakt.getMedlemstabell()[i].getStatusIndeks());
		}
		System.out.println();
		// finn medlem
		String medlem = "Ole";
		System.out.println("Medlem " + medlem + " har indeks : \t" + datakt.finnMedlemsIndeks("Ole"));
		
		// finn partner
		String partner = "Kari";
		System.out.println("Partner for " + partner + " har indeks : \t" + datakt.finnPartnerFor("Kari"));
		System.out.println();
		
		// skriv ut hobby til medlem
		for (int m = 0; m < datakt.getAntallMedlemmer(); m++) {
		System.out.print("Alle hobbyene til " + datakt.getMedlemstabell()[m].getNavn() + "\t: ");
		tekstgr.skrivHobbyListe(datakt.getMedlemstabell()[m]);
		}
		System.out.println();
		
		// skriv ut par med hobbyer
		System.out.println("Par med hobbyer: ");
		tekstgr.skrivParListe(datakt);
		System.out.println();
		
		System.out.println("Medlemmer: ");
		for (int k = 0; k < datakt.getAntallMedlemmer(); k++) {
			System.out.println(datakt.getMedlemstabell()[k].getNavn() + "\t" + datakt.getMedlemstabell()[k].getStatusIndeks());
		}
		System.out.println();
		
		datakt.tilbakestillStatusIndeks("Ole");
		datakt.tilbakestillStatusIndeks("Kari");
		datakt.tilbakestillStatusIndeks("Nils");
		
		System.out.println("Resetter statusindeks: ");
		for (int j = 0; j < datakt.getAntallMedlemmer(); j++) {
			System.out.println(datakt.getMedlemstabell()[j].getNavn() + "\t" + datakt.getMedlemstabell()[j].getStatusIndeks());
		}
		System.out.println();

	}
}
