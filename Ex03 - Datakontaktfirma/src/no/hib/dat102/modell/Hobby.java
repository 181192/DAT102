package no.hib.dat102.modell;

/**
 * Klasse for representasjon av hobbyer
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class Hobby {
	private String hobbyNavn;

	/**
	 * Tom kontruktør for hobby
	 */
	public Hobby() {
		this("");
	}

	/**
	 * Konstrukør for hobby
	 * 
	 * @param hobby
	 *            Hobby
	 */
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	/**
	 * @return the hobbyNavn
	 */
	public String getHobbyNavn() {
		return hobbyNavn;
	}

	/**
	 * @param hobbyNavn
	 *            the hobbyNavn to set
	 */
	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}

	/**
	 * Returnerer hobbynavnet med "<" foran og ">" bak
	 */
	public String toString() {
		return "<" + hobbyNavn + ">";
	}

	/**
	 * Equals metode for å skjekke om to hobbyer er like
	 */
	public boolean equals(Object hobby2) {
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}
