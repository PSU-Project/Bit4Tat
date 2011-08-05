package test.Bit4Tat;

import java.util.Date;

import org.junit.Test;
import com.Bit4Tat.DefaultScheduler;
import com.Bit4Tat.Wallet;
import static org.junit.Assert.assertTrue;
import com.Bit4Tat.*;

public class SchedulerTest {	
	
	@Test
	public void testSchedulerConditionalBuy () {
		
		DefaultScheduler scheduler = new DefaultScheduler();
		Wallet w = new Wallet("Bit4Tat", "mgbit4tat");
		w.changeService("mtgox");	
		
		scheduler.conditionalBuy(w, new Date(), 1, 0, null);
		
	}
}
