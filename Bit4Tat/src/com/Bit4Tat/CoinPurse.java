package com.Bit4Tat;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
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
			StringBuffer post_string = new StringBuffer();
			post_string.append(CHECK_BALANCE);
			try {
				name = URLEncoder.encode(name,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			try {
				pass = URLEncoder.encode(pass,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			post_string.append("name=" + name + "&" + "pass=" + pass);
			
			URL post_url = null;
			try 
			{
				post_url = new URL(CHECK_BALANCE);
			} catch (MalformedURLException e) 
			{
				e.printStackTrace();
			}
			
		}

}
