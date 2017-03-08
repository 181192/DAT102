package no.hib.dat102.klient;

import java.util.Scanner;

import no.hib.dat102.koe.tabell.TabellKoe;
import no.hib.dat102.liste.adt.OrdnetListeADT;
import no.hib.dat102.liste.tabell.TabellOrdnetListe;
import no.hib.dat102.modell.Jobb;
import no.hib.dat102.modell.JobbSamling;

public class Kjoereplan3 {
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		JobbSamling js = new JobbSamling();
		OrdnetListeADT<Jobb> klarKoeA = new TabellOrdnetListe<Jobb>();
		TabellKoe<Jobb> klarKoeB = new TabellKoe<Jobb>();

		Jobb jobb = null;
		int klokke = 0;
		int tidskrav = 0;
		int antall = 0;
		int tidssegmentA = 10;
		int tidssegmentB = 20;

		// Leser fra fil
		System.out.print("Oppgi datafil:");
		String filnavn = "data1.txt";
		System.out.println("Datafil: " + filnavn);

		js.lesFraFil(filnavn);
		antall = js.hentAntall();

		System.out.println("antall " + antall);
		JobbSamling ferdige = new JobbSamling(antall);

		while (ferdige.hentAntall() < 1) {
			do {
				jobb = js.hentAnkommenJobb(klokke);
				if (jobb != null) {
					klarKoeA.leggTil(jobb);
				}
			} while (jobb != null);
			if (klarKoeA.antall() > 0) {
				jobb = (Jobb) klarKoeA.fjernFoerste();
				tidskrav = jobb.getRestTid() - tidssegmentA;

				if (tidskrav > 0) {
					klarKoeB.innKoe(jobb);
					klokke++;
				} else {
					klokke += tidskrav;
					jobb.setFerdigTid(klokke);
					ferdige.leggTil(jobb);
				}
			}
		} // while
		ferdige.visJobber();
		tastatur.close();

	}
}
