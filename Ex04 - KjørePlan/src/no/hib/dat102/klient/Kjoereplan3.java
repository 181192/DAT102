package no.hib.dat102.klient;

import java.util.Scanner;

import no.hib.dat102.koe.tabell.TabellKoe;
import no.hib.dat102.modell.Jobb2;
import no.hib.dat102.modell.JobbSamling;

public class Kjoereplan3 {
	public static void main(String[] args) {
		Scanner tastatur = new Scanner(System.in);
		JobbSamling js = new JobbSamling();
		TabellKoe<Jobb2> klarKø = new TabellKoe<Jobb2>();

		Jobb2 jobb = null;
		int klokke = 0;
		int tidskrav = 0;
		int antall = 0;

		// Leser fra fil
		System.out.print("Oppgi datafil:");
		String filnavn = tastatur.nextLine();
		System.out.println("Datafil: " + filnavn);

		js.lesFraFil(filnavn);
		antall = js.hentAntall();

		System.out.println("antall " + antall);
		JobbSamling ferdige = new JobbSamling(antall);
		
		
	}
}
