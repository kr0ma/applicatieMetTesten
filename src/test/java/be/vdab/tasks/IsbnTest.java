package be.vdab.tasks;

import org.junit.Test;

public class IsbnTest {

	@Test(expected = IllegalArgumentException.class)
	public void hetNummer0IsVerkeerd() {
		new Isbn(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenNegatiefNummerIsVerkeerd() {
		new Isbn(-9789027439642L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenNummerMet12CijfersIsVerkeerd() {
		new Isbn(978902743964L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenNummerMet14CijfersIsVerkeerd() {
		new Isbn(97890274396421L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenNummerMet13CijfersMetVerkeerdControleGetal2() {
		new Isbn(8789027439642L);
	}

	@Test
	public void eenNummerMet13CijfersMetCorrectControleGetal2() {
		new Isbn(9789027439642L);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eenNummerMet13CijfersMetVerkeerdControleGetal0() {
		new Isbn(7789227439640L);
	}

	@Test
	public void eenNummerMet13CijfersMetCorrectControleGetal0() {
		new Isbn(9789227439640L);
	}

}
