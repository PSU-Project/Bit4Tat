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
	 * Buys the amount of currency for the price given
	 * @param amount - 
	 * @param price - 
	 * @return void
	 */
	public abstract void buy (double amount, double price);
	/**
	 * Sells the amount of currency for the price given
	 * @param amount -
	 * @param price -
	 * @return
	 */
	public abstract void sell (double amount, double price);
	/**
	 * Buys the amount of currency for the price given
	 * @return Response container child matching the service used.
	 */
	public abstract ResponseContainer checkBalance ();
	/**
	 * Buys the amount of currency for the price given
	 * @return Response container child matching the service used.
	 */
	public abstract ResponseContainer checkTicker ();
	/**
	 * Gets the Orders completed
	 * @return void
	 * 	 */
	public abstract void getOrders ();
	/**
	 * Cancel Order
	 * @param OrderID number
	 * @return void
	 */
	public abstract void cancelOrder (int orderID);
	
	public String getService() 
	{
		return service;
	}
	
	public String getUser()
	{
		return user;
	}
}
