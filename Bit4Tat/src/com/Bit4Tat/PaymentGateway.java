package com.Bit4Tat;

public class PaymentGateway 
{
	public PaymentService service;
	private String _payArguments;
	
	private static String SERVICE_ALREADY_SELECTED = "Service Already Selected";
	
	public PaymentGateway()
	{
		service = new PaymentProcessorForMtGox();
		setPayArguments(null);
	}
	
	public void useMtGox()
	{
		
		if (service instanceof PaymentProcessorForMtGox)
		{
			System.out.println(PaymentGateway.SERVICE_ALREADY_SELECTED);
			return;
		}
		else
		{
			//service = new PaymentProcessorForPayFlowPro();
		}
		
	}
	
	public void useOther()
	{
		/*
		if (service instanceof PaymentProcessorForOther)
		{
			System.out.println(PaymentGateway.SERVICE_ALREADY_SELECTED);
			return;
		}
		else
		{
			//service = new PaymentProcessorForOther();
		}
		*/
	}

	public void setPayArguments(String payArguments) 
	{
		this._payArguments = payArguments;
	}

	public String getPayArguments() 
	{
		return _payArguments;
	}
	
	public void printCurrentProcessor()
	{
		service.printService();
	}
}
