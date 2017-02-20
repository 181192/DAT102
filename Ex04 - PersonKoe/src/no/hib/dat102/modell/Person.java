package no.hib.dat102.modell;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	/**
	 * Tom kontruktoer.
	 */
	public Person() {
		this("", "", 0);
	}

	/**
	 * Konstruktoer for person
	 * 
	 * @param fornavn
	 *            fornavn
	 * @param etternavn
	 *            etternavn
	 * @param foedselaar
	 *            foedselsaar
	 */
	public Person(String fornavn, String etternavn, int foedselaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselaar;
	}

	/**
	 * @return the fornavn
	 */
	public String getFornavn() {
		return fornavn;
	}

	/**
	 * @param fornavn
	 *            the fornavn to set
	 */
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	/**
	 * @return the etternavn
	 */
	public String getEtternavn() {
		return etternavn;
	}

	/**
	 * @param etternavn
	 *            the etternavn to set
	 */
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	/**
	 * @return the foedselsaar
	 */
	public int getFoedselsaar() {
		return foedselsaar;
	}

	/**
	 * @param foedselsaar
	 *            the foedselsaar to set
	 */
	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	/**
	 * Returnere data for person
	 */
	@Override
	public String toString() {
		return "fornavn: " + fornavn + ", etternavn: " + etternavn + ", foedselsaar: " + foedselsaar;
	}

	/**
	 * Sammenligner foedselsdato til person
	 * 
	 * @param denAndre Person som skal sammenlignes
	 * 
	 * @return int
	 */
	@Override
	public int compareTo(Person denAndre) {
		Person p2 = (Person) denAndre;
		int resultat = -1;
		if (this.foedselsaar == p2.foedselsaar) {
			resultat = this.etternavn.compareTo(p2.etternavn);
			if (resultat == 0) {
				resultat = this.fornavn.compareTo(p2.fornavn);
			}
		} else if (this.foedselsaar > p2.foedselsaar) {
			resultat = 1;
		}
		return resultat;
	}
}
