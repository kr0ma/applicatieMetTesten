package be.vdab.tasks;

public class Isbn {
	private static final long KLEINSTE_GETAL_MET_13_CIJFERS = 1000_000_000_000L;
	private static final long GROOTSTE_GETAL_MET_13_CIJFERS = 9999_999_999_999L;
	private final long nummer;

	public Isbn(long nummer) {
		if (nummer < KLEINSTE_GETAL_MET_13_CIJFERS
				|| nummer > GROOTSTE_GETAL_MET_13_CIJFERS) {
			throw new IllegalArgumentException();
		}
		long somEvenCijfers = 0;
		long somOnEvenCijfers = 0;
		long teVerwerkenCijfers = nummer / 10;
		for (int teller = 0; teller != 6; teller++) {
			somEvenCijfers += teVerwerkenCijfers % 10;
			teVerwerkenCijfers /= 10;
			somOnEvenCijfers += teVerwerkenCijfers % 10;
			teVerwerkenCijfers /= 10;
		}
		long controleGetal = somEvenCijfers * 3 + somOnEvenCijfers;
		long naastGelegenHoger10Tal = controleGetal - controleGetal % 10 + 10;
		long verschil = naastGelegenHoger10Tal - controleGetal;
		long laatsteCijfer = nummer % 10;
		if (verschil == 10) {
			if (laatsteCijfer != 0) {
				throw new IllegalArgumentException();
			}
		} else {
			if (laatsteCijfer != verschil) {
				throw new IllegalArgumentException();
			}
		}
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return String.valueOf(nummer);
	}
}
