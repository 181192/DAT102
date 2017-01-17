package no.hib.data102;

/**
 * Enum klasse for sjangre
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public enum Sjanger {
	ROCK(0), POP(1), OPERA(2), CLASSIC(3);

	private int nr;

	/**
	 * Konstrukt�r for sjanger
	 * 
	 * @param n
	 *            Sjanger nummer
	 */
	private Sjanger(int n) {
		nr = n;
	}

	/**
	 * S�ker og henter sjanger med nummer som input
	 * 
	 * @param n
	 *            Sjanger nummer
	 * @return Sjanger
	 */
	public static Sjanger finnSjanger(int n) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.nr == n) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	} // metode

	/**
	 * S�ker og henter sjanger med string som input
	 * 
	 * @param navn
	 *            Navn p� sjanger
	 * @return Sjanger
	 */
	public static Sjanger finnSjanger(String navn) {
		Sjanger sjang = null;
		for (Sjanger sj : Sjanger.values()) {
			if (sj.toString().equals(navn.toUpperCase())) {
				sjang = sj;
				break;
			}
		}
		return sjang;
	} // metode
} // class
