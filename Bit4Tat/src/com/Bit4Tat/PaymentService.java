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
	
	
}
