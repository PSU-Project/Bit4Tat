package com.Bit4Tat;

public class Bit4Tat {

	/**
	 * Bit4Tat - An open source Bitcoin trader
	 * Copyright © 2011 Josh Dorothy, Ben Harrington, Max Thayer
	 * Please see the title COPYING in this distribution for license terms.
	 * 
	 */
	
	public static void main(String[] args) 
	{
		// Welcome to Bit4Tat, the coolest evar
		SchedulerGateway simpleScheduler = new DefaultScheduler();
		
		Wallet coinPurse = new Wallet("Bit4Tat", "mgbit4tat");
		coinPurse.changeService("mtgox");
		
		//this kind of crazy talk is on the chopping block
		coinPurse.getPayGate().printCurrentProcessor();
		
		simpleScheduler.pollBalance(coinPurse);

	}

}
