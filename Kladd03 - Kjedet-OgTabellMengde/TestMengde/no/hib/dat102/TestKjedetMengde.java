package no.hib.dat102;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.adt.MengdeADT;
import no.hib.dat102.exception.EmptyCollectionException;

public class TestKjedetMengde {
	private MengdeADT<Character> mengde;

	private Character c0 = 'A';
	private Character c1 = 'B';
	private Character c2 = 'C';
	private Character c3 = 'D';

	/**
	 * Henter ny mengde for hver test
	 */
	@Before
	public final void setup() {
		mengde = new KjedetMengde<Character>();
	}

	/**
	 * Skjekker om en ny mengde er tom, forventer true
	 */
	@Test
	public final void NyMengdeErTom() {
		assertTrue(mengde.erTom());
	}

	/**
	 * Skjekker størrelsen på mengden
	 */
	@Test
	public final void Stoerrelse() {
		mengde.leggTil(c0);
		mengde.leggTil(c1);
		mengde.leggTil(c2);
		assertEquals(3, mengde.antall());
	}

	/**
	 * Skjekker om mengden inneholder ett nytt element
	 */
	@Test
	public final void NyttElementInneholder() {
		mengde.leggTil(c0);
		assertTrue(mengde.inneholder(c0));
	}

	/**
	 * Legger til flere nye elementer, skjekker mengden innholder de.
	 */
	@Test
	public final void FlereNyeElementInneholder() {
		mengde.leggTil(c0);
		mengde.leggTil(c1);
		mengde.leggTil(c2);
		mengde.leggTil(c3);
		try {
			assertTrue(mengde.inneholder(c0));
			assertTrue(mengde.inneholder(c1));
			assertTrue(mengde.inneholder(c2));
			assertTrue(mengde.inneholder(c3));
		} catch (EmptyCollectionException e) {
			fail("UtMengde feilet uventet" + e.getMessage());
		}
	}

	/**
	 * Skjekker om mengden kan legge til duplikater, forventer feil
	 */
	@Test
	public final void NyttDubplikatInnholderElement() {
		mengde.leggTil(c0);
		mengde.leggTil(c2);
		mengde.leggTil(c2);
		mengde.leggTil(c3);
		mengde.inneholder(c2);
		assertEquals(c2, mengde.fjern(c2));
		assertFalse(mengde.inneholder(c2));
	}
}
