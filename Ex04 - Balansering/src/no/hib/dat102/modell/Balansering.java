package no.hib.dat102.modell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import no.hib.dat102.stabel.kjedet.KjedetStabel;

public class Balansering {
	private KjedetStabel<ParentesInfo> stabel;
	private ParentesInfo info;
	private boolean fortsatt;

	public Balansering() {
		stabel = new KjedetStabel<ParentesInfo>();
	}

	private boolean passer(char aapent, char lukket) {
		switch (aapent) {
		case '(':
			return (lukket == ')');
		case '[':
			return (lukket == ']');
		case '{':
			return (lukket == '}');
		default:
			return false;
		}
	}

	public void foretaBalansering(String innDataStreng, int linjenr) {
		int lengde = innDataStreng.length();
		fortsatt = true;
		int posisjon = 0;

		while (posisjon < lengde && fortsatt) {
			Character parentes = innDataStreng.charAt(posisjon);
			if (parentes.equals('(') || parentes.equals('[') || parentes.equals('{')) {
				info = new ParentesInfo(linjenr, posisjon, parentes);
				stabel.push(info);
			} else if (parentes.equals(')') || parentes.equals(']') || parentes.equals('}')) {
				if (stabel.erTom()) {
					fortsatt = false;
					System.out.println("Feil på linje: " + (linjenr) + " posisjon " + posisjon);
				} else {
					info = stabel.pop();
					if (!passer(info.getVenstreparentes(), parentes)) {
						fortsatt = false;
						System.out.println("Par passer ikke på linjenr " + (linjenr));	
					}
				}
			}
			posisjon++;
		}
	

	}//

	public void lesFraFil(String filnavn) {
		FileReader tekstFilLeser = null;
		try {
			tekstFilLeser = new FileReader(filnavn);
		} catch (FileNotFoundException unntak) {
			System.out.println("Finner ikke filen!");
			System.exit(-1);
		}

		BufferedReader tekstLeser = new BufferedReader(tekstFilLeser);
		String linje = null;
		int linjenr = 0;
		try {
			linje = tekstLeser.readLine();
			while (linje != null) {
				foretaBalansering(linje, linjenr);
				linjenr++;
				linje = tekstLeser.readLine();
			} // while
			if (!stabel.erTom()) {
				info = stabel.pop();
				System.out.println("Parantes ikke lukket på linje " + (linjenr - 1) + " på posisjon " + info.getPosisjon());
				fortsatt = false;
			}
			if (fortsatt) {
				System.out.println("Filen er balansert");
			}
		}

		catch (IOException unntak) {
			System.out.println("Feil ved innlesing!");
			System.exit(-1);
		}
		try {
			tekstFilLeser.close();
		} catch (IOException unntak) {
			System.out.println("Feil ved lukking av fil!");
		}

	}// metode

}// class
