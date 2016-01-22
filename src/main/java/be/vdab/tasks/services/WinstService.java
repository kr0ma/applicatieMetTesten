package be.vdab.tasks.services;

import java.math.BigDecimal;

import be.vdab.tasks.dao.KostDAO;
import be.vdab.tasks.dao.OpbrengstDAO;

public class WinstService {
	private KostDAO kostDAO;
	private OpbrengstDAO opbrengstDAO;
	
	public WinstService(OpbrengstDAO opbrengstDAO, KostDAO kostDAO){
		this.opbrengstDAO = opbrengstDAO;
		this.kostDAO = kostDAO;
	}
	
	public BigDecimal getWinst(){
		return opbrengstDAO.findTotaleOpbrengst().subtract(kostDAO.findTotaleKost());
	}
}
