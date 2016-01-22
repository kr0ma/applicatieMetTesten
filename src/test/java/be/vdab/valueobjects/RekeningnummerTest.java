package be.vdab.valueobjects;

import static org.junit.Assert.*;

import org.junit.Test;

public class RekeningnummerTest {

	@Test
	public void nummerMet12CijfersMetCorrectControleIsOK() {
		new Rekeningnummer("063-1547564-61");
		// dit nummer mag geen exception veroorzaken
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummerMet12CijfersMetVerkeerdeControleIsVerkeerd() {
		new Rekeningnummer("063-1547564-62");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummerMet12CijfersZonderStreepjesMetCorrectControleIsVerkeerd() {
		new Rekeningnummer("063154756461");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummerMet13CijfersIsVerkeerd() {
		new Rekeningnummer("063-1547564-623");
	}

	@Test(expected = IllegalArgumentException.class)
	public void nummerMet11CijfersIsVerkeerd() {
		new Rekeningnummer("063-1547564-6");
	}

	@Test(expected = IllegalArgumentException.class)
	public void leegNummerIsVerkeerd() {
		new Rekeningnummer("");
	}

	@Test(expected = NullPointerException.class)
	public void nummerMetNullIsVerkeerd() {
		new Rekeningnummer(null);
	}

	@Test
	public void toStringMoetHetNummerTeruggeven() {
		String nummer = "063-1547564-61";
		assertEquals(nummer, new Rekeningnummer(nummer).toString());
	}
}
