package no.hib.dat102;

public class Butikk {
	private String navn;
	private int antall;
	private Vare[] varelager;
	private int[] varetelling;

	public Butikk(String navn, int maksAntall) {
		this.navn = navn;
		varelager = new Vare[maksAntall];
		varetelling = new int[maksAntall];
		this.antall = 0;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	/**
	 * 
	 * @param varenr
	 * @return
	 */
	public int finnVare(int varenr) {
		int posisjon = -1;
		int i = 0;
		boolean funnet = false;

		while (!funnet && i < antall) {
			if (varelager[i].getVarenummer() == varenr) {
				posisjon = i;
				funnet = true;
			}
			i++;
		}
		return posisjon;
	}

	public boolean erLedigPlass() {
		boolean tilstand = false;
		for (int i = 0; i < varelager.length; i++) {
			if (varelager[i] == null) {
				tilstand = true;
			}
		}
		return tilstand;
	}

	public void leggInnNyVare(int varenr) {
		if (finnVare(varenr) == -1) {
			Vare nyVare = new Vare(varenr);
			varelager[antall] = nyVare;
			nyVare.lesVare(varenr);
			varetelling[antall] = 0;
			antall++;
		} else if (erLedigPlass() == false) {
			System.out.println("Varelageret er fullt!");
		} else if (finnVare(varenr) != -1) {
			System.out.println("Varen eksisterer allerede");
		}
	}

	public void slettVare(int varenr) {
		int posisjon = finnVare(varenr);
		if (finnVare(varenr) != -1) {
			varelager[posisjon] = varelager[antall - 1];
			varelager[antall - 1] = null;
			varetelling[posisjon] = varetelling[antall - 1];
			varetelling[antall - 1] = 0;
			antall--;
		} else {
			System.out.println("Varen finnes ikke!");
		}
	}

	public void detaljSalg(int varenr) {
		int posisjon = finnVare(varenr);
		if (posisjon == -1) {
			System.out.println("Varen finnes ikke!");
		} else if (posisjon < 0) {
			System.out.println("Det er tomt for varen");
		} else if (posisjon >= 0) {
			varetelling[posisjon] = varetelling[posisjon] - 1;
			System.out
					.println("Det er " + varetelling[posisjon] + " " + varelager[posisjon].getVarenavn() + " igjen. ");
		}
	}

	public void grossInnkjøp(int varenr, int tall) {
		int posisjon = finnVare(varenr);
		if (posisjon == -1) {
			System.out.println("Varen finnes ikke!");
		} else if (posisjon < 0) {
			System.out.println("Varen er tom");
		} else if (posisjon >= 0) {
			varetelling[posisjon] += tall;
			System.out.println("Det er " + varetelling[posisjon] + " av " + varelager[posisjon].getVarenavn());
		}
	}

	public void salgVerdi() {
		double sum = 0;
		for (int i = 0; i < antall; i++) {
			double totalpris = varelager[i].getPris() * varetelling[i];
			sum += totalpris;
		}
		System.out.println("Summen av varelageret er " + sum + " kr");
	}
}
