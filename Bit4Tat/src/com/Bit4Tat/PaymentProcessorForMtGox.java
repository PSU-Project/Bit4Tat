package com.Bit4Tat;

import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

public class PaymentProcessorForMtGox extends PaymentService
{
	private static final String CHECK_BALANCE 		= "https://mtgox.com/code/getFunds.php?";
	private static final String BUY_ORDER 			= "https://mtgox.com/code/buyBTC.php?";
	private static final String SELL_ORDER 			= "https://mtgox.com/code/sellBTC.php?";
	private static final String GET_ORDERS		 	= "https://mtgox.com/code/getOrders.php?";
	private static final String CANCEL_ORDER 		= "https://mtgox.com/code/cancelOrder.php?";
	private static final String SEND_BTC 			= "https://mtgox.com/code/withdraw.php?";
	
	public PaymentProcessorForMtGox(String username, String password)
	{
		user = username;
		pass = password;
	}
	
	@Override
	public void checkBalance()
	{
		HttpsURLConnection conn = setupConnection(CHECK_BALANCE);

		try {
		// Construct data
		String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
		data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");

		/*//Diagnostics
		System.out.println("post_string:");
		System.out.println(data);
		*/

		getResponse(data, conn);
		} catch (Exception e) {
		e.printStackTrace();
		}
		conn.disconnect();
		// TODO figure out what to return
	}
	
	@Override
	public void buy(double amount, double price) 
	{
		// Uses user credentials (user, pass) to purchase an amount of bitcoins.
		// Set up connection
		HttpsURLConnection conn = setupConnection(BUY_ORDER);
		try 
		{
			// Assemble the user, pass, amount, and price to tack onto conn
			String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
			data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
			data += "&" + URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(Double.toString(amount), "UTF-8");
			data += "&" + URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(Double.toString(price), "UTF-8");
			// Pass to MtGox
			getResponse(data, conn);
		}
		// if there are errors, print a stack trace
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		// disconnect
		conn.disconnect();
		// TODO figure out what to return
	}
	
	@Override
	public void sell(double amount, double price) 
	{
		HttpsURLConnection conn = setupConnection(SELL_ORDER);
		try 
		{
			// Construct data
			String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
			data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
			data += "&" + URLEncoder.encode("amount", "UTF-8") + "=" + 
					URLEncoder.encode(new java.text.DecimalFormat("0.00").format(amount), "UTF-8");
			data += "&" + URLEncoder.encode("price", "UTF-8") + "=" + 
					URLEncoder.encode(new java.text.DecimalFormat("0.00").format(price), "UTF-8");
			getResponse(data, conn);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		conn.disconnect();
		// TODO figure out what to return
	}

	@Override
	public void cancelOrder(int orderID) 
	{
		HttpsURLConnection conn = setupConnection(CANCEL_ORDER);
		try 
		{
			// Construct data
			String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
			data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
			data += "&" + URLEncoder.encode("amount", "UTF-8") + "=" + URLEncoder.encode(Integer.toString(orderID), "UTF-8");
			getResponse(data, conn);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		conn.disconnect();
		// TODO figure out what to return
	}

	@Override
	public void getOrders() 
	{
		HttpsURLConnection conn = setupConnection(GET_ORDERS);
		try 
		{
			// Construct data
			String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
			data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
			getResponse(data, conn);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		conn.disconnect();
		// TODO figure out what to return
	}
}
