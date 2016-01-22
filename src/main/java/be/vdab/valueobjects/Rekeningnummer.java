package be.vdab.valueobjects;

import java.util.regex.Pattern;

public class Rekeningnummer {
	private static final Pattern REG_EXPR = Pattern
			.compile("^\\d{3}-\\d{7}-\\d{2}$");
	private String nummer;

	public Rekeningnummer(String nummer) {
		if (!REG_EXPR.matcher(nummer).matches()) {
			throw new IllegalArgumentException();
		}
		long eerste10Cijfers = Long.parseLong(nummer.substring(0, 3)
				+ nummer.substring(4, 11));
		long laatste2Cijfers = Long.parseLong(nummer.substring(12, 14));
		if (eerste10Cijfers % 97L != laatste2Cijfers) {
			throw new IllegalArgumentException();
		}
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return nummer;
	}
}
