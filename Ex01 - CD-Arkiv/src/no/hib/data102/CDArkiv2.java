/**
 * 
 */
package no.hib.data102;

import no.hib.data102.adt.CDArkivADT;
import no.hib.data102.node.EmptyCollectionException;
import no.hib.data102.node.LinearNode;

/**
 * @author Kristoffer-Andre Kalliainen
 *
 */
public class CDArkiv2 implements CDArkivADT{
private int antall;
private LinearNode<CD> start;
	/**
	 *  Oppretter ett tomt arkiv
	 */
	public CDArkiv2() {
		antall = 0;
		start = null;
	}
	
	@Override
	public CD[] hentCDTabell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> temp = new LinearNode<CD>(nyCd);
		
		temp.setNeste(start);
		start = temp;
		antall++;
	}
	
	private LinearNode<CD> finnCd(int cdNr) {
		LinearNode<CD> p = start;
		while (p != null) {
			if (p.getElement().getCdNr() == cdNr) {
				return p;
			} else {
				p = p.getNeste();
			}
		}
		return null;
	}
	
	@Override
	public boolean slettCd(int cdNr) throws EmptyCollectionException {
		boolean tilstand = false;
		if (erTom()) {
			throw new EmptyCollectionException("CDArkiv");
		}
		// 1. m� s�ke etter node og sammenlige cdNr
		LinearNode<CD> resultat= finnCd(cdNr);
		
		// 2. Slette noden/cd'en
		if (resultat.getElement().getCdNr() == cdNr) {
			resultat = resultat.getNeste();
			antall--;
			tilstand = true;
		}
		// 3. returnerer true hvis noden blir slettet
		return tilstand;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Skjekker om arkivet er tomt
	 * @return true visst arkivet er tomt
	 */
	private boolean erTom()	{
		return (start == null);
	}

}
