     /**
     * ResponseTradeHill.java - A class to contain the parsed JSON response
     * from Tradehill.
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

public class ResponseTradeHill extends ResponseContainer 
{
	public JsonContainer info;
	
	public ResponseTradeHill()
	{
		this.info = info;
	}

	@Override
	public void parseCheckBalance(BufferedReader rd) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getAvg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBitCoins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getBuy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getHigh() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getLow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getSell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUSDS() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getVol() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getVwap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void parseTicker(BufferedReader rd) {
		// TODO Auto-generated method stub
		
	}
	
}
