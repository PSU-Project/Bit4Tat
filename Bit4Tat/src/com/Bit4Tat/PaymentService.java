package com.Bit4Tat;

public abstract class PaymentService 
{
	/**
	 * Description here
	 * @param account - same line.
	 * @param amount
	 * @return
	 */
	public abstract void pay (double amount);
	/**
	 * 
	 * @param 
	 * @return
	 */
	public abstract void sell (double amount);
	/**
	 * 
	 * @param response
	 * @param amount
	 * @return
	 */
	public abstract void checkBalance (String user, String pass);
	
	public abstract void printService();
	
	//Payment Services
	public static final String MTGOX = "Mt Gox";
	public static final String OTHER = "other";
}
