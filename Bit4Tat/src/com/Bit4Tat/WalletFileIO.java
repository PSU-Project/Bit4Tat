    /**
     * WalletFileIO.java - A class providing a wrapper for basic file I/O 
     * functionality.
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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class WalletFileIO {
	
	/**
	 * Constructor for the <code>BasicFileIO</code> object.
	 * 
	 * @param filename A <code>String</code> containing the filename to be
	 * read from or written to.
	 */
	
	public WalletFileIO (String filename) {
		
		this.filename = filename;
	}
	
	/**
	 * Opens the filename passed to the constructor for writing. 
	 */
	
	public void openWriter() {
		try {
			if (filename != null) {
				out = new BufferedWriter(new FileWriter(filename));
				writer = true;
			}
		} catch (IOException e) {
			System.err.println("There was a problem opening the requested file " + filename + ".");
			System.err.println("Error: " + e);
			System.exit(1);
		}		
	}

	/**
	 *  Opens the filename passed to the constructor for reading.
	 */
	
	public void openReader () {
		System.out.println(System.getProperty("user.dir"));
		try {
			if (filename != null) {
				in = new BufferedReader(new FileReader(filename));
				reader = true;
			}
		} catch (IOException e) {
			System.err.println("There was a problem opening the requested file " + filename + ".");
			System.err.println("Error: " + e);
			System.exit(1);
		}		
	}	
	
	/**
	 * Writes a <code>String</code> object to the file opened for writing,
	 * followed by a <code>String</code> delimiter character, if any.
	 * 
	 * @param token A <code>String</code> to be written to the file.
	 * @param delimiter A <code>String</code> to be written subsequent
	 * to the token.  If this value is <code>null</code>, a delimiter will
	 * not be written.
	 */
	
	public void writeToken (String token, String delimiter) {
		try {
			if (writer) {			
				out.write(token);
				if (delimiter != null)
					out.write(delimiter);
			} else {
				throw (new Exception("The writer has not yet been initialized for writing."));
			}
		} catch (IOException e) {
			System.err.println("There was a problem writing to the requested file " + out.toString() + ".");
			System.err.println("Error: " + e);
			System.exit(1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}
	
	/**
	 * Writes a <code>String</code> object to the file opened for writing,
	 * optionally followed by a newline (/n) character.
	 * 
	 * @param line A <code>String</code> to be written to the file.
	 * @param newline A <code>boolean</code> value representing whether a
	 * newline character should be written to the file.
	 */
	
	public void writeLine (String line, boolean newline) {
		try {
			if (writer) {			
				out.write(line);
				if (newline)
					writeNewLine();
			} else {
				throw (new Exception("The writer has not yet been initialized for writing."));
			}
		} catch (IOException e) {
			System.err.println("There was a problem writing to the requested file " + out.toString() + ".");
			System.err.println("Error: " + e);
			System.exit(1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
	}	
	
	/**
	 * Writes a newline character ('\n') to the file opened for writing.
	 */
	
	public void writeNewLine () {
		try {
			if (writer) {			
				out.write('\n');
			} else {
				throw (new Exception("The writer has not yet been initialized for writing."));
			}				
		} catch (IOException e) {
			System.err.println("There was a problem writing to the requested file " + out.toString() + ".");
			System.err.println("Error: " + e);
	
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}		
	}
	
	/**
	 * Returns a <code>StringTokenizer</code> object for the current file
	 * opened for reading.
	 * 
	 * @param delimiter A <code>String</code> to be written subsequent
	 * to the token.  If this value is <code>null</code>, the default
	 * delimiter will be used.
	 * @return st A <code>StringTokenizer</code> object initialized with
	 * the contents of the file opened for reading.
	 */
	
	public StringTokenizer getTokenizer (String delimiter) {
		
		String temp = "";
		String fileContents = "";
		StringTokenizer st = null;
			
		try {
			if (reader) {			
				while ((temp = in.readLine()) != null) {
	
					fileContents = fileContents + temp + " ";
				}
				if (delimiter == null)
					st = new StringTokenizer(fileContents);
				else
					st = new StringTokenizer(fileContents, delimiter);
			} else {
				throw (new Exception("The reader has not yet been initialized for reading."));				
			}
		} catch (IOException e) {
			System.err.println("There was a problem processing a string token.");
			System.err.println("Error: " + e);			
			System.exit(1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(1);
		}
		
		return st;
	}
	
	/**
	 * Closes the currently opened file for writing.
	 */

	public void closeWriter () {
		try {
			if (writer)
				out.close();
		} catch (IOException e) {
			System.err.println("There was a problem closing the requested file.");
			System.err.println("Error: " + e);
			System.exit(1);
		}
	}

	/**
	 * Closes the currently opened file for reading.
	 */

	public void closeReader () {
		try {
			if (reader)
				in.close();
		} catch (IOException e) {
			System.err.println("There was a problem closing the requested file.");
			System.err.println("Error: " + e);
			System.exit(1);		
		}
	}

	/**
	 * A <code>BufferedReader</code> object for the file to be written to.
	 */	
	
	BufferedWriter out;

	/**
	 * A <code>BufferedReader</code> object for the file to be read from.
	 */		
	
	BufferedReader in;
	
	/**
	 * A <code>boolean</code> object that is true if a file is open for
	 * writing, otherwise false.
	 */
	
	boolean	writer;

	/**
	 * A <code>boolean</code> object that is true if a file is open for
	 * reading, otherwise false.
	 */	
	
	boolean	reader;
	
	/**
	 * A <code>String</code> containing the filename to be read from or written
	 * to. 
	 */	
	
	String filename;
}