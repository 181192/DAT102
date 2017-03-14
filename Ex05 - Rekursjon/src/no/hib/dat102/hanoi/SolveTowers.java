package no.hib.dat102.hanoi;

import java.util.Scanner;

public class SolveTowers {

	/**
	 * Lager ett TowersOfHanoi spill og løser det
	 * @param args
	 */
	public static void main (String[] args ) {
		Scanner tast = new Scanner(System.in);
		System.out.print("Tast inn antall ringer: ");
		int antall = tast.nextInt();
		TowersOfHanoi towers = new TowersOfHanoi(antall);
		towers.solve();
		tast.close();
	}
}
