package com.Bit4Tat;

public abstract class SchedulerGateway 
{
	/**
	 * Description here
	 */
	public abstract void doWork();
	
	/**
	 * Description here
	 * @param null
	 * @param null
	 * @return
	 */
	public abstract void conditionalBuy(Wallet w, Object trigger, int action, double amount, Object expires);
	
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
	public abstract Wallet pollBalance(Wallet cred);
	
	/**
	 * Print the currently used Scheduler
	 * @return
	 */
	public abstract void printScheduler();
	
}
