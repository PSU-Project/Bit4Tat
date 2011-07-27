package com.Bit4Tat;

public abstract class PaymentService 
{
	/**
	 * Description here
	 * @param account - same line.
	 * @param amount
	 * @return
	 */
	public abstract void buy (Wallet w, double amount, double price);
	/**
	 * 
	 * @param 
	 * @return
	 */
	public abstract void sell (Wallet w, double amount, double price);
	/**
	 * 
	 * @param response
	 * @param amount
	 * @return
	 */
	public abstract void checkBalance (Wallet w);
	
	public abstract void printService();
	
	//Payment Services
	public static final String MTGOX = "Mt Gox";
	public static final String TRADEHILL = "Tradehill";
	public static final String OTHER = "other";
}
