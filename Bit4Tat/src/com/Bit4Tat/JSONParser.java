package com.Bit4Tat;

import java.io.IOException;
import java.util.Iterator;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

public class JSONParser {
	
	public JSONParser () {
		
	}
	
	public JSONParser (JsonObject j) {
		
	}
	
	public Ticker getTicker (JsonObject j) throws IOException {
		
		String[] tickerProperties = {"high", "low", "avg", "vol", "last", "buy", "sell"};
		Ticker t = new Ticker();
		
		//Iterator<JsonElement> iterator = array.iterator();		
				
		JsonElement high = j.get("high");
		t.setHigh(high.getAsDouble());
		
		JsonElement low = j.get("low");
		
		JsonElement avg = j.get("avg");
		JsonElement vol = j.get("vol");
		JsonElement last = j.get("last");
		JsonElement buy = j.get("buy");
		JsonElement sell = j.get("sell");

		// There is a better way to do this probably:
		// Idea - just read the JSON data in a loop into a Collection, then pass
		// that collection to the Ticker constructor?
		// The Ticker object can encapsulate all that stuff I guess?
		//
		// So a cool thing would be for the JSONParser to just have a method that
		// turns a JSON object into a Collection?  Or is that already taken care
		// of in the JsonArray?  I should read this I guess.
		
		System.out.println(high.getAsDouble());
		
		return t;
	}
	
	
}
