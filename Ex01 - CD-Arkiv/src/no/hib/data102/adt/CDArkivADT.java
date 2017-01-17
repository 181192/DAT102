package no.hib.data102.adt;

import no.hib.data102.CD;
import no.hib.data102.Sjanger;

/**
 * ADT for CDArkiv
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
public interface CDArkivADT {

	/**
	 * Returnerer en tabell av CD-er
	 * 
	 * @return tabell av CD-er
	 */
	CD[] hentCDTabell();

	/**
	 * Legger til en ny CD
	 * 
	 * @param nyCd
	 *            Ny CD
	 */
	void leggTilCd(CD nyCd);

	/**
	 * Sletter en CD hvis den fins
	 * 
	 * @param cdNr
	 *            Nummer på CD-en
	 * @return True eller false
	 */
	boolean slettCd(int cdNr);

	/**
	 * Søker og henter CD-er med en gitt delstreng
	 * 
	 * @param delstreng
	 * @return CD-er med gitt delstreng
	 */
	CD[] sokTittel(String delstreng);

	/**
	 * Søker og henter artister med en gitt delstreng
	 * 
	 * @param delstreng
	 * @return En artist, gitt med delstreng
	 */
	CD[] sokArtist(String delstreng);

	/**
	 * Henter antall CD-er
	 * 
	 * @return Antall CD-er
	 */
	int hentAntall();

	/**
	 * Henter antall CD-er for en gitt sjanger
	 * 
	 * @param sjanger
	 *            Sjanger
	 * @return Antall CD-er for en gitt sjanger
	 */
	int hentAntall(Sjanger sjanger);
}
