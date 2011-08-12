     /**
     * ResponseContainer.java - An abstract class for holding parsed JSON
     * information.
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

public abstract class ResponseContainer 
{	
	//For check balance
	public abstract String getBitCoins();
	public abstract String getUSDS();
	
	public abstract Double getHigh();
	public abstract Double getLow();
	public abstract Double getAvg();
	public abstract Double getVwap();
	public abstract Double getVol();
	public abstract Double getLast();
	public abstract Double getBuy();
	public abstract Double getSell();
	
	public abstract void parseCheckBalance(BufferedReader rd);
	public abstract void parseTicker(BufferedReader rd);
}
