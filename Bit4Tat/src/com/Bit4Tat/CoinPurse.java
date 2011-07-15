package com.Bit4Tat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.URLStreamHandlerFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Properties;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CoinPurse {
	
	private static final String CHECK_BALANCE 		= "https://mtgox.com/code/getFunds.php";
	private static final String BUY_ORDER 			= "https://mtgox.com/code/buyBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String SELL_ORDER 			= "https://mtgox.com/code/sellBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String FETCH_OPEN_ORDERS 	= "https://mtgox.com/code/getOrders.php?name=blah&pass=blah";
	private static final String CANCEL_ORDER 		= "https://mtgox.com/code/cancelOrder.php?name=blah&pass=blah&oid=#&type=#";
	private static final String SEND_BTC 			= "https://mtgox.com/code/withdraw.php?name=blah&pass=blah&group1=BTC&btca=bitcoin_address_to_send_to&amount=#";
	
	private String user;
	private String pass;
	
	
		public CoinPurse ()
		{
			user = null;
			pass = null;
		}
		
		public CoinPurse (String user, String pass)
		{
			this.user = user;
			this.pass = pass;
		}
		
		public void setUser (String user)
		{
			this.user = user;
		}
		
		public void setPass (String pass)
		{
			this.pass = pass;
		}
		
		public void checkBalance ()
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
		}
		
		public void buy (double amount, double price)
		{
			HttpsURLConnection conn = setupConnection(CHECK_BALANCE);
			try {
				// Construct data
				String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
				data += "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
				
				// TODO more stuff
				
				
				/*//Diagnostics
				System.out.println("post_string:");
				System.out.println(data);
		   		*/
				
				getResponse(data, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        conn.disconnect();
		}
		
		private static class DefaultTrustManager implements X509TrustManager 
		{

	        @Override
	        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        @Override
	        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

	        @Override
	        public X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }
	    }
		
		private HttpsURLConnection setupConnection(String urlString)
		{
			SSLContext ctx = null;
			try {
				ctx = SSLContext.getInstance("TLS");
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
				ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        SSLContext.setDefault(ctx);

	        URL url = null;
			try {
				url = new URL(urlString);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        HttpsURLConnection conn = null;
			try {
				conn = (HttpsURLConnection) url.openConnection();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			conn.setDoOutput(true);
			conn.setDoInput(true);
	        conn.setHostnameVerifier(new HostnameVerifier() {
	            @Override
	            public boolean verify(String arg0, SSLSession arg1) {
	                return true;
	            }
	        });
	        
	        /*
	        try {
				System.out.println(conn.getResponseCode());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
	        return conn;
		}
		
		private String getResponse(String data, HttpsURLConnection conn)
		{
			StringBuffer returnString = new StringBuffer();
			try {
				// open up the output stream of the connection 
				DataOutputStream wr = new DataOutputStream( conn.getOutputStream() );
				int queryLength = data.length();
				wr.writeBytes( data);
			
				//OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
				//wr.write(data);
				//wr.flush();
					   
				// Get the response
				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line;
				while ((line = rd.readLine()) != null) 
				{
					// Process line...
					System.out.println(line);
					returnString.append(line);
				}
				wr.close();
				rd.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return returnString.toString();
		}
}
