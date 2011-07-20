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

public class Wallet {
	
	private static final String CHECK_BALANCE 		= "https://mtgox.com/code/getFunds.php";
	private static final String BUY_ORDER 			= "https://mtgox.com/code/buyBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String SELL_ORDER 			= "https://mtgox.com/code/sellBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String FETCH_OPEN_ORDERS 	= "https://mtgox.com/code/getOrders.php?name=blah&pass=blah";
	private static final String CANCEL_ORDER 		= "https://mtgox.com/code/cancelOrder.php?name=blah&pass=blah&oid=#&type=#";
	private static final String SEND_BTC 			= "https://mtgox.com/code/withdraw.php?name=blah&pass=blah&group1=BTC&btca=bitcoin_address_to_send_to&amount=#";
	
	private PaymentGateway payGate;
	private String _user;
	private String _pass;
	
	private static final String[] SERVICES = {"mtgox", "other"};
	
	
		public Wallet (String user, String pass)
		{
			setPayGate(new PaymentGateway());
			setUser(user);
			setPass(pass);
			
		}
		
		public void buy (double amount, double price)
		{
			
		}
		
		public void changeService (String service)
		{
			if (service == SERVICES[0])
			{
				payGate.useMtGox();
			}
		}

		public void setPayGate(PaymentGateway payGate) 
		{
			this.payGate = payGate;
		}

		public PaymentGateway getPayGate() 
		{
			return payGate;
		}

		public void setUser(String _user) {
			this._user = _user;
		}

		public String getUser() {
			return _user;
		}

		public void setPass(String _pass) {
			this._pass = _pass;
		}

		public String getPass() {
			return _pass;
		}
}
