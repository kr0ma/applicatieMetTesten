package be.vdab.tasks;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.tasks.dao.KostDAO;
import be.vdab.tasks.dao.OpbrengstDAO;
import be.vdab.tasks.services.WinstService;

public class WinstServiceTest {
	
	private OpbrengstDAO opbrengstDAO;
	private KostDAO kostDAO;
	
	private WinstService winstService;
	
	@Before
	public void before(){
		//this.opbrengstDAO = new OpbrengstDAOStub();
		//this.kostDAO = new KostDAOStub();
		this.opbrengstDAO = mock(OpbrengstDAO.class);
		when(opbrengstDAO.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(350));
		
		
		this.kostDAO = mock(KostDAO.class);		
		when(kostDAO.findTotaleKost()).thenReturn(BigDecimal.valueOf(100));
		
		this.winstService = new WinstService(opbrengstDAO, kostDAO);
	}

	@Test
	public void WinstIsOpbrengstMinKost() {
		assertEquals(0, BigDecimal.valueOf(250).compareTo(winstService.getWinst()));
		verify(opbrengstDAO).findTotaleOpbrengst();
		verify(kostDAO).findTotaleKost();
	}	

}
