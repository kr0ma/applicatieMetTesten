package be.vdab.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import be.vdab.dao.LandDAO;
import be.vdab.entities.Land;

public class LandServiceTest {

	private LandDAO landDAO;
	private LandService landService;

	@Before
	public void before() {
		landDAO = mock(LandDAO.class);
		when(landDAO.findOppervlakteAlleALanden()).thenReturn(20);
		when(landDAO.read("B")).thenReturn(new Land("B", 5));		
		when(landDAO.read("NL")).thenReturn(new Land("NL", 6));
		when(landDAO.read("")).thenThrow(new IllegalArgumentException());
		landService = new LandService(landDAO);
	}

	@Test
	public void findVerhoudingOppervlakteLandTovOppervlakteAlleLanden() {
		assertEquals(0, BigDecimal.valueOf(0.25).compareTo(landService.findVerhoudingOppervlakteLandTovOppervlakteAlleLanden("B")));
		verify(landDAO).findOppervlakteAlleALanden();
		verify(landDAO).read("B");
	}

}
