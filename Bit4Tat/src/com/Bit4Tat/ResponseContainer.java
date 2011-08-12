package com.Bit4Tat;

import java.io.BufferedReader;

public abstract class ResponseContainer 
{	
	//Items returned for check balance
	public abstract String getBitCoins();
	public abstract String getUSDS();
	
	//Items returned for Ticker
	public abstract Double getHigh();
	public abstract Double getLow();
	public abstract Double getAvg();
	public abstract Double getVwap();
	public abstract Double getVol();
	public abstract Double getLast();
	public abstract Double getBuy();
	public abstract Double getSell();
	
	// Extract the json fromt the charged buffer reader
	public abstract void parseCheckBalance(BufferedReader rd);
	public abstract void parseTicker(BufferedReader rd);
}
