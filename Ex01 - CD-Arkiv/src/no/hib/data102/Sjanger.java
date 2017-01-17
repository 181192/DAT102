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
	 * Konstruktør for sjanger
	 * 
	 * @param n
	 *            Sjanger nummer
	 */
	private Sjanger(int n) {
		nr = n;
	}

	/**
	 * Søker og henter sjanger med nummer som input
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
	 * Søker og henter sjanger med string som input
	 * 
	 * @param navn
	 *            Navn på sjanger
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
