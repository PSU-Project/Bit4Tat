package com.Bit4Tat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public abstract class PaymentService 
{
	protected static String user;
	protected static String pass;
	protected static String service;
	/**
	 * Description here
	 * @param account - same line.
	 * @param amount
	 * @return
	 */
	public abstract void buy (double amount, double price);
	/**
	 * 
	 * @param 
	 * @return
	 */
	public abstract void sell (double amount, double price);
	/**
	 * 
	 * @param response
	 * @param amount
	 * @return
	 */
	public abstract void checkBalance ();
	
	public abstract void getOrders ();
	
	public abstract void cancelOrder (int orderID);
	
	public String getService() 
	{
		return service;
	}
	
	public String getUser()
	{
		return user;
	}
	
	// Read and return website responses
	String getResponse (String data, HttpsURLConnection conn) 
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnString.toString();
	}
	
	// Something or other. Ben, Josh: What does this do? --Max
	static class DefaultTrustManager implements X509TrustManager
	{
		@Override
		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
	
	
		@Override
		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
	
		@Override
		public X509Certificate[] getAcceptedIssuers() {return null;}
	}
	
	// Sets up a connection to a URL
	HttpsURLConnection setupConnection(String urlString)
	{
		SSLContext ctx = null;

		try {
			ctx = SSLContext.getInstance("TLS");
		} catch (NoSuchAlgorithmException e1) {
		e1.printStackTrace();
		}
		try {
			ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());
		} catch (KeyManagementException e) {
		e.printStackTrace();
		}
		SSLContext.setDefault(ctx);


		URL url = null;

		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}
		HttpsURLConnection conn = null;

		try {
			conn = (HttpsURLConnection) url.openConnection();
		} catch (IOException e1) {
		e1.printStackTrace();
		}
		conn.setDoOutput(true);

		conn.setDoInput(true);

		conn.setHostnameVerifier(new HostnameVerifier() 
		{
			@Override
			public boolean verify(String arg0, SSLSession arg1) 
			{
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
}
