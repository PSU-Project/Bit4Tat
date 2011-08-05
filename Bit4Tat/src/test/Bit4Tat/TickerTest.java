package test.Bit4Tat;

import java.io.IOException;
import com.Bit4Tat.*;
import org.junit.Test;
import com.google.gson.JsonObject;
import static org.junit.Assert.assertTrue;

public class TickerTest {	
	
	@Test
	public void testTickerObjectCreation() {
		JSONParser j = new JSONParser();
		JsonObject json = new JsonObject();
		json.addProperty("high", new Double(14.63988));
		
		Ticker t = null;
		try {
			t = j.getTicker(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
