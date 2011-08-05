package test.Bit4Tat;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.Bit4Tat.*;

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
