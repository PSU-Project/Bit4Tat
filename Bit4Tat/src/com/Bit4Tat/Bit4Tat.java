package com.Bit4Tat;

public class Bit4Tat {

	/**
	 * Bit4Tat - An open source Bitcoin trader
	 * Copyright © 2011 Josh Dorothy, Ben Harrington, Max Thayer
	 * Please see the title COPYING in this distribution for license terms.
	 * 
	 */
	static final String USER = "Bit4Tat";
	static final String PASS = "mgbit4tat";
	
	public static void main(String[] args) 
	{
		// Welcome to Bit4Tat, the coolest evar
		
		CoinPurse cp = new CoinPurse(USER, PASS);
		cp.checkBalance();	
	}

}
