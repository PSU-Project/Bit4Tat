package com.Bit4Tat;

public class Wallet {
	
	private static final String CHECK_BALANCE 		= "https://mtgox.com/code/getFunds.php";
	private static final String BUY_ORDER 			= "https://mtgox.com/code/buyBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String SELL_ORDER 			= "https://mtgox.com/code/sellBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String FETCH_OPEN_ORDERS 	= "https://mtgox.com/code/getOrders.php?name=blah&pass=blah";
	private static final String CANCEL_ORDER 		= "https://mtgox.com/code/cancelOrder.php?name=blah&pass=blah&oid=#&type=#";
	private static final String SEND_BTC 			= "https://mtgox.com/code/withdraw.php?name=blah&pass=blah&group1=BTC&btca=bitcoin_address_to_send_to&amount=#";
	
	private PaymentGateway payGate;
	private String _user;
	private String _pass;
	
	private static final String[] SERVICES = {"mtgox", "other"};
	
	
		public Wallet (String user, String pass)
		{
			setPayGate(new PaymentGateway());
			setUser(user);
			setPass(pass);
			
		}
		
		public void buy (double amount, double price)
		{
			// Check the service and use the appropriate purchasing method
			if (payGate.service instanceof PaymentProcessorForMtGox)
			{
				payGate.service.buy(this, amount, price);
			}
			else
			{
				// TODO implement payment processors for other exchanges
			}
		}
		
		public void sell (double amount, double price)
		{
			payGate.useMtGox();
			payGate.service.sell(this, price, amount);
		}
		
		public void changeService (String service)
		{
			if (service == SERVICES[0])
			{
				payGate.useMtGox();
			}
		}

		public void setPayGate(PaymentGateway payGate) 
		{
			this.payGate = payGate;
		}

		public PaymentGateway getPayGate() 
		{
			return payGate;
		}

		public void setUser(String _user) {
			this._user = _user;
		}

		public String getUser() {
			return _user;
		}

		public void setPass(String _pass) {
			this._pass = _pass;
		}

		public String getPass() {
			return _pass;
		}
}
