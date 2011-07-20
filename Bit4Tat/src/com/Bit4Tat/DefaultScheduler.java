package com.Bit4Tat;

public class DefaultScheduler extends SchedulerGateway 
{
	private PaymentGateway payGate;
	
	public DefaultScheduler()
	{
		payGate = new PaymentGateway();
	}
	
	@Override
	public void pollBalance(Wallet cred) 
	{
		// TODO Auto-generated method stub
		
		cred.getPayGate().service.checkBalance(cred.getUser(), cred.getPass());
		
	}

	@Override
	public void conditionalBuy(Wallet cred, double amount) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printScheduler() 
	{
		System.out.println("Default Simple Scheduler in use.");
		
	}

	@Override
	public void conditionalSell(Wallet cred, double amount) 
	{
		// TODO Auto-generated method stub
		
	}

}
