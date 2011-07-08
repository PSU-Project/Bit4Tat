package com.Bit4Tat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.stream.JsonReader;

public class JSONParser {
	
	public JSONParser () {
		
	}
	
	public void readTicker (InputStream in) throws IOException {
		JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
		
		reader.beginArray();
		while (reader.hasNext()) {
			
		}
	}
}
