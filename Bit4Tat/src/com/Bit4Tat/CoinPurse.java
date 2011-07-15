package com.Bit4Tat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class CoinPurse {
	
	private static final String CHECK_BALANCE 		= "https://mtgox.com/code/getFunds.php?";
	private static final String BUY_ORDER 			= "https://mtgox.com/code/buyBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String SELL_ORDER 			= "https://mtgox.com/code/sellBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String FETCH_OPEN_ORDERS 	= "https://mtgox.com/code/getOrders.php?name=blah&pass=blah";
	private static final String CANCEL_ORDER 		= "https://mtgox.com/code/cancelOrder.php?name=blah&pass=blah&oid=#&type=#";
	private static final String SEND_BTC 			= "https://mtgox.com/code/withdraw.php?name=blah&pass=blah&group1=BTC&btca=bitcoin_address_to_send_to&amount=#";
	
	
	
	
		public CoinPurse ()
		{
			
		}
		
		public void CheckBalance (String name, String pass)
		{
		StringBuffer returnString = new StringBuffer();
		try {
		   // Construct data
		String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
		   data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");

		   System.out.println("post_string:");
		System.out.println(data);
		   
		   // Send data
		   URL url = new URL(CHECK_BALANCE);
		   URLConnection conn = url.openConnection();
		   conn.setDoOutput(true);
		   OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		   wr.write(data);
		   wr.flush();

		   // Get the response
		   BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		   String line;
		   while ((line = rd.readLine()) != null) {
		       // Process line...
		    System.out.println(line);
		    returnString.append(line);
		   }
		   wr.close();
		   rd.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		System.out.println(returnString.length());
		System.out.println("End of check balance Function!");
		}
}
