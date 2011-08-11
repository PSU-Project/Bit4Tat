package com.Bit4Tat;

import java.io.BufferedReader;

public abstract class ResponseContainer 
{	
	public abstract String getResponse();
	public abstract void parseCheckBalance(BufferedReader rd);
}
