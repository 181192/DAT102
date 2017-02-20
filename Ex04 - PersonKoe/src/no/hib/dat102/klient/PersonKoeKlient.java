package no.hib.dat102.klient;

import java.util.Scanner;

import no.hib.dat102.koe.adt.KoeADT;
import no.hib.dat102.koe.tabell.TabellKoe;
import no.hib.dat102.modell.Person;

public class PersonKoeKlient {
	public static void main(String[] args) {
		KoeADT<Person> pkoe = new TabellKoe<Person>();

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
				pkoe.innKoe(p);
				break;
			case "n":
				// avslutt
				break;
			}

		} while (!valg.equals("n"));

		tast.close();

		System.out.println("\nPersoner i koe: ");
		while (!pkoe.erTom()) {
			System.out.println(pkoe.utKoe());
		}

	}
}
