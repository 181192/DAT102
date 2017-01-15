package no.hib.dat102;

import java.util.Scanner;

public class Vare {
	/**
	 * @author Kristoffer-Andre Kalliainen
	 * @version V.0.1.0
	 */
	private int varenummer;
	private String varenavn;
	private double pris;

	public Vare() {
		this(0, "", 0.0);
	}

	/**
	 * 
	 * @param varenummer
	 */
	public Vare(int varenummer) {
		this(varenummer, "", 0.0);
	}

	/**
	 * 
	 * @param varenummer
	 * @param varenavn
	 * @param pris
	 */
	public Vare(int varenummer, String varenavn, double pris) {
		this.varenummer = varenummer;
		this.varenavn = varenavn;
		this.pris = pris;
	}

	public void setVarenummer(int varenummer) {
		this.varenummer = varenummer;
	}

	public int getVarenummer() {
		return varenummer;
	}

	public void setVarenavn(String varenavn) {
		this.varenavn = varenavn;
	}

	public String getVarenavn() {
		return varenavn;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public double getPris() {
		return pris;
	}
	
	/**
	 * 
	 * @param varenummer
	 */
	public void lesVare(int varenummer) {
		Scanner tast = new Scanner(System.in);

		System.out.print("Oppgi navn på vare: ");
		varenavn = tast.nextLine();

		System.out.print("Oppgi pris: ");
		pris = tast.nextDouble();

		while (pris < 0) {
			System.out.println("Negativ input, prøv igjen. ");
			pris = tast.nextDouble();
		}
	}
}
