package no.hib.dat102.klient;

import no.hib.dat102.modell.Rekursjon;

public class RekursjonKlient {
	public static void main(String[] args) {
		// Krav: tall > 0
		System.out.print("Oppgave 1 snu tall: \t");
		int tall = 2343244;
		Rekursjon.snuTall(tall);
		
		System.out.print("\nOppgave 2 snu tabell: \t");
		int[] tab = {1, 2, 3, 4, 5, 6, 7, 8 };
		Rekursjon.snuTabell(tab);
		for (int m : tab) {
			System.out.print(m);
		}
		
		System.out.print("\nOppgave 3 kvad opp: \t" + Rekursjon.sumKvadOpp(3, 3));
		
		System.out.print("\nOppgave 4 kvad ned: \t" + Rekursjon.sumKvadNed(2, 2));
	}
}
