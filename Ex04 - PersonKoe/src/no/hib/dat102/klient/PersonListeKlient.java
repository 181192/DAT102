package no.hib.dat102.klient;

import java.util.Scanner;

import no.hib.dat102.liste.adt.OrdnetListeADT;
import no.hib.dat102.liste.kjedet.KjedetOrdnetListe;
import no.hib.dat102.liste.tabell.TabellOrdnetListe;
import no.hib.dat102.modell.Person;

public class PersonListeKlient {
	public static void main(String[] args) {
		OrdnetListeADT<Person> pKjedeListe = new KjedetOrdnetListe<Person>();
		OrdnetListeADT<Person> pTabellListe = new TabellOrdnetListe<Person>();

		Scanner tast = new Scanner(System.in);

		String valg = "";

		do {
			System.out.print("Les inn ny person? (Y/n) : ");
			valg = tast.next();

			switch (valg) {
			case "y":
				System.out.print("Oppgi fornavn: ");
				String fornavn = tast.next();
				System.out.print("Oppgi etternavn: ");
				String etternavn = tast.next();
				System.out.print("Oppgi foedselaar: ");
				String foedselaar = tast.next();

				Person p = new Person(fornavn, etternavn, Integer.parseInt(foedselaar));
				pKjedeListe.leggTil(p);
				pTabellListe.leggTil(p);
				break;
			case "n":
				// avslutt
				break;
			}

		} while (!valg.equals("n"));

		tast.close();

		System.out.println("\nPersoner i koe (KjedetListe): ");
		while (!pKjedeListe.erTom()) {
			System.out.println(pKjedeListe.fjernFoerste());
		}

		System.out.println("\nPersoner i koe (TabellListe): ");
		while (!pTabellListe.erTom()) {
			System.out.println(pTabellListe.fjernFoerste());
		}

	}
}
