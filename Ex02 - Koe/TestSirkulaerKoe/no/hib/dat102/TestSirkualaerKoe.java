package no.hib.dat102;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat102.adt.KoeADT;

public class TestSirkualaerKoe {
	protected static final int SIZE = 100;

	private KoeADT<Character> koe;

	private Character c0 = 'A';
	private Character c1 = 'B';
	private Character c2 = 'C';
	private Character c3 = 'D';

	/**
	 * Henter en ny koe for hver test
	 */
	@Before
	public final void setup() {
		koe = new SirkulaerKoe<Character>(SIZE);
	}

	/**
	 * Test på at en ny koe er tom
	 */
	@Test
	public final void NyKoeErTom() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test på inn og ut av køen
	 */
	@Test
	public final void InnOgUtKoe() {
		koe.innKoe(c0);
		koe.innKoe(c1);
		koe.innKoe(c2);
		koe.innKoe(c3);
		try {
			assertEquals(c0, koe.utKoe());
			assertEquals(c1, koe.utKoe());
			assertEquals(c2, koe.utKoe());
			assertEquals(c3, koe.utKoe());

		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på inn og ut av kø med duplikater
	 */
	@Test
	public final void InnOgUtKoeDuplikat() {
		koe.innKoe(c1);
		koe.innKoe(c1);
		koe.innKoe(c1);
		koe.innKoe(c3);
		try {
			assertEquals(c1, koe.utKoe());
			assertEquals(c1, koe.utKoe());
			assertEquals(c1, koe.utKoe());
			assertEquals(c3, koe.utKoe());

		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing på foerste
	 */
	@Test
	public final void InnUtInnInnUtForste() {
		try {
			koe.innKoe(c0);
			koe.utKoe();
			koe.innKoe(c0);
			koe.innKoe(c2);
			koe.utKoe();
			assertEquals(c2, koe.foerste());
		} catch (EmptyCollectionException e) {
			fail("Forste feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på at en koe med elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(c0);
		koe.innKoe(c1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test på at en koe med null elementer er tom.
	 */
	@Test
	public final void InnUtErTom() {
		try {
			koe.innKoe(c3);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("InnUtErTom feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på størrelsen
	 */
	@Test
	public final void storrelse() {
		koe.innKoe(c0);
		koe.innKoe(c1);
		koe.innKoe(c2);
		assertEquals(3, koe.antall());
	}

	/**
	 * Forsoeker å ta ut av koeen av en tom koe, skal gi "underflow exeption"
	 * 
	 * @throws EmptyCollectionException Expected exception
	 */
	@Test(expected = EmptyCollectionException.class)
	public final void UtKoeFraTomKoeUnderflowed() throws EmptyCollectionException {
		koe.utKoe();
	}
	
	/**
	 * Tester utvid() metoden (standardkonstruktøren oppretter en tabell med 100 plasser)
	 */
	@Test
	public final void utvidUtvider() {
		for(int i = 0; i < 110; i++) {
			koe.innKoe(c0);
		}
		assertEquals(110, koe.antall());
	}
}
