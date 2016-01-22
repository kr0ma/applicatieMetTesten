package be.vdab.tasks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VeilingTest {
	private Veiling veiling;
	
	@Before
	public void Before(){
		veiling = new Veiling();
	}

	@Test
	public void hetHoogsteBodVanEenNieuweVeilingStaatOpNul() {
		assertEquals(0, veiling.getHoogsteBod());
	}

	@Test
	public void hetEersteBodVanEenVeilingIsHetHoogsteBod() {
		veiling.doeBod(100);
		assertEquals(100, veiling.getHoogsteBod());
	}

	@Test
	public void naMeerdereBiedingenIsHetHoogsteBodGelijkAanHetBedragVanDitBod() {
		veiling.doeBod(100);
		veiling.doeBod(200);
		veiling.doeBod(150);
		assertEquals(200, veiling.getHoogsteBod());
	}

}
