package be.vdab.dao;

import be.vdab.entities.Land;

public class LandDAOStub implements LandDAO {

	@Override
	public Land read(String landcode) {
		return new Land(landcode, 5);
	}

	public int findOppervlakteAlleALanden() {
		return 20;
	}

}
