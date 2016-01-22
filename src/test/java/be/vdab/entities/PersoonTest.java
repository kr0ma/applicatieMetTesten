package be.vdab.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class PersoonTest {

	private Persoon persoon;
	private Set<String> voornamen;
	
	@Before
	public void before(){
		voornamen = new LinkedHashSet<>();	
	}
	
	// minstens 1 voornaam
	@Test(expected = IllegalArgumentException.class)
	public void eenPersoonMoetMinstens1VoornaamHebbenBijCreëren(){
		persoon = new Persoon(voornamen);
	}	
	
	@Test
	public void eenPersoonMet1voornaamIsOK() {	
		voornamen.add("naam1");
		persoon = new Persoon(voornamen);
		assertFalse(persoon.getVoornamen().isEmpty()); 
	}
	
	@Test
	public void naCreërenPersoonMoetDelistOpgevraagdKunnenWordenEnMoetDezeVolgensEqualsDezelfdeZijnAlsInConstructor() {	
		voornamen.add("naam1");
		persoon = new Persoon(voornamen);
		assertEquals(voornamen, persoon.getVoornamen()); 
	}
	
	// geen 2 keer zelfde voornaam
	@Test
	public void naEenZelfdeVoornaamToevoegenIsGrootteVanVoornamenNogGelijk() {
		voornamen.add("naam1");
		persoon = new Persoon(voornamen);
		int aantal = persoon.getVoornamen().size();
		persoon.addVoornaam("naam1");
		assertEquals(aantal, persoon.getVoornamen().size());
	}
	
	@Test
	public void eenPersoonMagGeenDubbeleVoornaamHebbenBijCreëren() {
		voornamen.add("naam1");
		voornamen.add("naam1");
		persoon = new Persoon(voornamen);
		assertEquals(1, persoon.getVoornamen().size());
	}
	
	// minstens 1 teken in voornaam
	@Test(expected = IllegalArgumentException.class)
	public void eenVoornaamMoetMinstens1tekenBevatten() {
		voornamen.add("naam1");
		persoon = new Persoon(voornamen);
		persoon.addVoornaam("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eenVoornaamMoetMinstens1tekenBevattenBijCreëren() {
		voornamen.add("naam1");
		voornamen.add("");
		persoon = new Persoon(voornamen);
	}
	
	// tostring method
	@Test
	public void toStringMethodMoetAlleVoornamenTerugGevenGescheidenDoorSpatie(){
		/*
		voornamen.add("naam1");
		voornamen.add("naam2");
		voornamen.add("naam3");
		persoon = new Persoon(voornamen);
		StringBuilder string = new StringBuilder();
		for (String entry:voornamen){
			string.append(entry).append(" ");
		}
		assertEquals(string.toString(), persoon.toString());*/
		
		voornamen.add("Hans");
		voornamen.add("Cyriel");
		persoon = new Persoon(voornamen);
		assertEquals("Hans Cyriel", persoon.toString());
	}
	
	// null waarden
	@Test(expected = NullPointerException.class)
	public void eenPersoonCreërenMetParameterNullIsVerkeerd() {		
		persoon = new Persoon(null);
	}	
	
	@Test(expected = NullPointerException.class)
	public void eenPersoonCreërenMetParameterListWaarNullWaardeInZitIsVerkeerd() {		
		voornamen.add(null);
		persoon = new Persoon(voornamen);		
	}
	
	@Test(expected = NullPointerException.class)
	public void eenVoornaamToevoegenMetNullWaardeIsVerkeerd() {		
		voornamen.add("naam1");
		persoon = new Persoon(voornamen);
		persoon.addVoornaam(null);
	}
	
}
