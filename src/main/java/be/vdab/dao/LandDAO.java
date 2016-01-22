package be.vdab.dao;

import be.vdab.entities.Land;

public interface LandDAO {
	Land read(String landcode);
	int findOppervlakteAlleALanden();
}
