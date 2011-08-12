package com.Bit4Tat;

import java.io.BufferedReader;

public abstract class ResponseContainer 
{	
	//For check balance
	public abstract String getBitCoins();
	public abstract String getUSDS();
	
	public abstract Double getHigh();
	public abstract Double getLow();
	public abstract Double getAvg();
	public abstract Double getVwap();
	public abstract Double getVol();
	public abstract Double getLast();
	public abstract Double getBuy();
	public abstract Double getSell();
	
	public abstract void parseCheckBalance(BufferedReader rd);
	public abstract void parseTicker(BufferedReader rd);
}
