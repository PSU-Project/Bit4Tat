     /**
     * ResponseMtGox.java - A class to contain the parsed JSON response
     * from Mt. Gox.
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

import java.io.BufferedReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ResponseMtGox extends ResponseContainer 
{
	CheckBalance balance;
	CheckTicker ticker;
	
	public class CheckBalance
	{
		@SerializedName("usds")
		public String usds;

		@SerializedName("btcs")
		public String btcs;
	}
	
	public class TickerList
	{
		String name;
		Double value;
	}
	
	public class CheckTicker
	{
		// Example ticker json response string
		// {"ticker":{"high":10.4959,"low":8.45099,"avg":9.595957131,"vwap":9.485441665,"vol":56999,"last":9.3502,"buy":9.3502,"sell":9.35761}}
		
		@SerializedName("ticker")
		public List<TickerList> list;
		
		/*
		@SerializedName("high")
		public Double high;
		
		@SerializedName("low")
		public Double low;
		
		@SerializedName("avg")
		public Double avg;
		
		@SerializedName("vwap")
		public Double vwap;
		
		@SerializedName("vol")
		public Double vol;
		
		@SerializedName("last")
		public Double last;
		
		@SerializedName("buy")
		public Double buy;
		
		@SerializedName("sell")
		public Double sell;
		*/
	}
	
	public ResponseMtGox()
	{
		balance = null;
		ticker = null;
	}
	
	@Override
	public void parseCheckBalance(BufferedReader rd) 
	{
        Gson gson = new Gson();
		CheckBalance parseObj = new CheckBalance();
		//System.out.println("In the CheckBalance Gson parser");
        parseObj = gson.fromJson(rd, CheckBalance.class);
        balance = parseObj;
	}
	
	@Override
	public void parseTicker(BufferedReader rd)
	{
		Gson gson = new Gson();
		CheckTicker parseObj = new CheckTicker();
		//System.out.println("In the Ticker Gson parser");
        parseObj = gson.fromJson(rd, CheckTicker.class);
        ticker = parseObj;
        //System.out.println(ticker.list.get(1));
	}

	@Override
	public Double getAvg() 
	{
		return ticker.list.get(0).value;
	}

	@Override
	public String getBitCoins() 
	{
		return balance.btcs;
	}

	@Override
	public Double getBuy() 
	{
		return ticker.list.get(0).value;
	}

	@Override
	public Double getHigh() 
	{
		return ticker.list.get(0).value;
	}

	@Override
	public Double getLast() 
	{
		return ticker.list.get(0).value;
	}

	@Override
	public Double getLow() 
	{
		return ticker.list.get(0).value;
	}

	@Override
	public Double getSell() 
	{
		return ticker.list.get(0).value;
	}

	@Override
	public String getUSDS() 
	{
		return balance.usds;
	}

	@Override
	public Double getVol() 
	{
		return ticker.list.get(0).value;
	}

	@Override
	public Double getVwap() 
	{
		// TODO Auto-generated method stub
		return ticker.list.get(0).value;
	}

}
