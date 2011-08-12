     /**
     * PaymentService.java - An abstract base class for each exchange's 
     * payment services.
     * Copyright (C) 2011 Josh Dorothy, Ben Harrington, Max Thayer 
     * 
     * This program is free software: you can redistribute it and/or modify
     * it under the terms of the GNU Affero General Public License as
     * published by the Free Software Foundation, either version 3 of the
     * License, or (at your option) any later version.
     * 
     * This program is distributed in the hope that it will be useful,
     * but WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     * GNU Affero General Public License for more details.
     * 
     * You should have received a copy of the GNU Affero General Public License
     * along with this program.  If not, see <http://www.gnu.org/licenses/>.
     */

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
	public abstract ResponseContainer checkBalance ();
	public abstract ResponseContainer checkTicker ();
	
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
