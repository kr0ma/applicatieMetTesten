package be.vdab.tasks.dao;

import java.math.BigDecimal;

public class OpbrengstDAOStub implements OpbrengstDAO {

	@Override
	public BigDecimal findTotaleOpbrengst() {		
		return BigDecimal.valueOf(350);
	}

}
