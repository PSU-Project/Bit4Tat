package com.Bit4Tat;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TickerTest {	
	
	@Test
	public void testTickerObjectCreation() {
		JSONParser j = new JSONParser();
		Ticker t = new Ticker();
		
		assertTrue(j != null);
		assertTrue(t != null);		
	}
	
	@Test
	public void testTickerObjectValues() {
		JSONParser j = new JSONParser();
		Ticker t = new Ticker();
		
		assertTrue(j != null);
		assertTrue(t != null);
	}
}
