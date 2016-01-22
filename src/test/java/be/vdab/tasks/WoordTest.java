package be.vdab.tasks;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoordTest {

	@Test
	public void lepel_is_een_palindroom(){
		assertTrue(new Woord("lepel").isPalindroom());
	}
	
	@Test
	public void vork_is_geen_palindroom(){
		assertFalse(new Woord("vork").isPalindroom());
	}
	
	@Test
	public void een_lege_string_is_een_palindroom(){
		assertTrue(new Woord("").isPalindroom());
	}

}
