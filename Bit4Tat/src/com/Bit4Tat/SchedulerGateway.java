package com.Bit4Tat;

public abstract class SchedulerGateway 
{
	/**
	 * Description here
	 * @param null
	 * @param null
	 * @return
	 */
	public abstract void conditionalBuy(Wallet cred, double amount);
	
	/**
	 * Description here
	 * @param null
	 * @param null
	 * @return
	 */
	public abstract void conditionalSell(Wallet cred, double amount);
	
	/**
	 * Description here
	 * @param null
	 * @param null
	 * @return
	 */
	public abstract void pollBalance(Wallet cred);
	
	/**
	 * Print the currently used Scheduler
	 * @return
	 */
	public abstract void printScheduler();
	
}
