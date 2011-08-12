     /**
     * Wallet.java - A class to store wallet data such as username/password.
     * Copyright (C) 2011 Josh Dorothy, Ben Harrington, Max Thayer 
     * 
     * This program is free software: you can redistribute it and/or modify
     * it under the terms of the GNU Affero General Public License as
     * published by the Free Software Foundation, either version 3 of the
     * License, or (at your option) any later version.
     * 
     * This program is distributed in the hope that it will be useful,
     * but WITHOUT ANY WARRANTY; without even the implied warranty of
     * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     * GNU Affero General Public License for more details.
     * 
     * You should have received a copy of the GNU Affero General Public License
     * along with this program.  If not, see <http://www.gnu.org/licenses/>.
     */

package com.Bit4Tat;

import java.util.Hashtable;

public class Wallet {
	
	private static final String CHECK_BALANCE 		= "https://mtgox.com/code/getFunds.php";
	private static final String BUY_ORDER 			= "https://mtgox.com/code/buyBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String SELL_ORDER 			= "https://mtgox.com/code/sellBTC.php?name=blah&pass=blah&amount=#&price=#";
	private static final String FETCH_OPEN_ORDERS 	= "https://mtgox.com/code/getOrders.php?name=blah&pass=blah";
	private static final String CANCEL_ORDER 		= "https://mtgox.com/code/cancelOrder.php?name=blah&pass=blah&oid=#&type=#";
	private static final String SEND_BTC 			= "https://mtgox.com/code/withdraw.php?name=blah&pass=blah&group1=BTC&btca=bitcoin_address_to_send_to&amount=#";
	
	private PaymentService mtgox;
	private PaymentService tradehill;
	private Hashtable<String, PaymentService> services;
	
	// Pass wallet all the usernames and passwords for each service 
		public Wallet (Hashtable<String, String[]> h) {
			// hashtable breakdown: String = service name; String[] = [user,pass]
			services = new Hashtable<String, PaymentService>();
			// parse hashtable parameters
			if (h.containsKey("mtgox")) {
				mtgox = new PaymentProcessorForMtGox(h.get("mtgox")[0], h.get("mtgox")[1]);
				services.put("mtgox", mtgox);
			}
			if (h.containsKey("tradehill")) {
				tradehill = new PaymentProcessorForTradehill(h.get("tradehill")[0], h.get("tradehill")[1]);
				services.put("tradehill", tradehill); 
			}
			// add new services by checking whether the service key exists, then instantiating its payment processor
		}
		
		public String buy (String service, double amount, double price)
		{
			assert services.containsKey(service);
			services.get(service).buy(amount, price);
			// TODO figure out what this returns and return it
			return null; 
		}
		
		public String sell (String service, double amount, double price)
		{
			assert services.containsKey(service);
			services.get(service).sell(amount, price);
			// TODO figure out what this returns and return it
			return null; 
		}
		
		public ResponseContainer checkBalance (String service) 
		{
			assert services.containsKey(service);
			 
			return services.get(service).checkBalance();
			
		}
		
		public String getOrders (String service) 
		{
			assert services.containsKey(service);
			services.get(service).getOrders();
			// TODO figure out what this returns and return it
			return null;
		}
		
		public String cancelOrder (String service, int orderID) 
		{
			assert services.containsKey(service);
			services.get(service).cancelOrder(orderID);
			// TODO figure out what this returns and return it
			return null; 
		}
		
		public ResponseContainer checkTicker (String service)
		{
			assert services.containsKey(service);
			return services.get(service).checkTicker();
		}
}
