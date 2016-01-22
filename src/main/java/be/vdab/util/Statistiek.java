package be.vdab.util;

import java.math.BigDecimal;

public class Statistiek {
	public static BigDecimal getGemiddelde(BigDecimal[] getallen) {
		if (getallen.length == 0) {
			throw new IllegalArgumentException();
		}
		BigDecimal totaal = BigDecimal.ZERO;
		for (BigDecimal getal : getallen) {
			totaal = totaal.add(getal);
		}
		return totaal.divide(BigDecimal.valueOf(getallen.length));
	}
}
