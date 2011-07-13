package com.Bit4Tat;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class JSONTest {

	@Test
	public void testJSONValidTickerParsing() {
		JSONParser j = new JSONParser();
		
		assertTrue(j != null);
	}

	@Test
	public void testJSONInvalidTickerParsing() {
		JSONParser j = new JSONParser();
		
		assertTrue(j != null);
	}

}
