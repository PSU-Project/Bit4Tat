package com.Bit4Tat;

import java.io.BufferedReader;

import com.google.gson.Gson;

public class ResponseMtGox extends ResponseContainer 
{
	private int usds;
	private int bitcoins;
	
	public class checkBalance
	{
		private int dollars = 99;
		private int bitcoins = 66;
		
		public void setDollars(int dollars) {
			this.dollars = dollars;
		}
		public int getDollars() {
			return dollars;
		}
		public void setBitcoins(int bitcoins) {
			this.bitcoins = bitcoins;
		}
		public int getBitcoins() {
			return bitcoins;
		}
	}
	
	public ResponseMtGox()
	{
		usds = -1;
		bitcoins = -1;
	}
	
	@Override
	public String getResponse() 
	{
		return Integer.toString(bitcoins);
	}

	@Override
	public void parseCheckBalance(BufferedReader rd) 
	{
		Gson gson = new Gson();
		checkBalance parseObj = new checkBalance();
		System.out.println("In the Gson parser");
        parseObj = gson.fromJson(rd, checkBalance.class);
        usds = parseObj.getDollars();
        bitcoins = parseObj.getBitcoins();
	}

}
