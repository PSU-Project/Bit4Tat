    /**
     * 	Bit4Tat.java - An automated Bitcoin arbitrage program.
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Bit4Tat {

	/**
	 * Bit4Tat - An open source Bitcoin trader
	 * Copyright © 2011 Josh Dorothy, Ben Harrington, Max Thayer
	 * Please see the title COPYING in this distribution for license terms.
	 * 
	 */
	//static final String[] mtgox_userpass = {"Bit4Tat","mgbit4tat"};
	static final String[] mtgox_userpass = {"garbados","compsciisthebest!"};
	static final String[] th_userpass = {"thayer3@pdx.edu","Bit4Tatth"};
	static final String version = "1.0";
	
	static Hashtable<String, String[]> userpass;
	
	public static void main(String[] args) 
	{			
		// Welcome to Bit4Tat, the coolest evar
		SchedulerGateway simpleScheduler = new DefaultScheduler();
		
		// opens file containing username and passwords
		WalletFileIO f = new WalletFileIO("wallet.csv");
		f.openReader();
		StringTokenizer tokenizer = f.getTokenizer(",");
		// userpass file repeats "service, user, pass", so for every 3 items therein, there's a complete service.
		userpass = new Hashtable<String, String[]>();
		String service = "";
		String[] account = new String[2];
		try {
			if (tokenizer.countTokens() == 0) throw (new Exception("empty"));
			while (tokenizer.hasMoreTokens())
			{
				service = tokenizer.nextToken();
				if ((service.equals("mtgox")) && (service.equals("tradehill"))) throw (new Exception("unknown service"));
				account[0] = tokenizer.nextToken();
				account[1] = tokenizer.nextToken();
				userpass.put(service,account);
			}
		}
		catch (Exception e) {
			if (e.getMessage().equals("empty")) System.err.println("Wallet file is empty!");
			else if (e.getMessage().equals("unknown service")) {
				System.err.println("Unknown service!");
				System.err.println(service);
			}
			else {
				System.err.println(e.getMessage());
				System.err.println(e);
			}
		}
	
		Wallet coinPurse = new Wallet(userpass);
		
		//coinPurse = simpleScheduler.pollBalance(coinPurse);
		
		//coinPurse.checkBalance("mtgox");
		//coinPurse.checkBalance("tradehill");
		
		BitFrame frame = new BitFrame(coinPurse);
		frame.setTitle("Bit4Tat " + version);
		frame.setVisible(true);

	}

}

class BitFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton fileMenu;
	private JButton optionMenu;
	private JButton exchangesMenu;
	private JButton helpMenu;
	private JButton walletMenu;
	private JButton currentButton;
	private JPanel	currentPanel;
	private Container contentPane;
	private Hashtable<String, BitPanel> panelList;
	
	public BitFrame(Wallet w) {
		
		// Create the HashMap of valid BitPanels (one for each menu item).		
		
		panelList = new Hashtable<String, BitPanel>();
		panelList.put("File", new FilePanel(w));
		panelList.put("Options", new OptionsPanel(w));
		panelList.put("Exchanges", new ExchangesPanel(w));		
		panelList.put("Help", new HelpPanel(w));
		panelList.put("Wallet", new WalletPanel(w));
		
		// Set the frame dimensions.
		
		final double FRAME_HEIGHT = 600.0;
		final double FRAME_WIDTH = 800.0;
		
		setSize((int)FRAME_WIDTH, (int)FRAME_HEIGHT);				
		
		// Center the frame using the current resolution.
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		setLocation((int)((screenSize.width - FRAME_WIDTH) / 2),
					(int)((screenSize.height - FRAME_HEIGHT) / 2));		
		
		setLayout(new BorderLayout());
		pack();
	
		// TODO: Initialize the connection here?
		
		// Set the currently active panel.

		currentPanel = panelList.get("File");

		// Set up the menu bar and the menu listener.
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		MenuListener menuListener = new MenuListener();
		
		// Add "File" as a JMenuItem since it has no sub-menu.
		
		fileMenu = new JButton("File");
		fileMenu.setContentAreaFilled(false);
		fileMenu.setBorderPainted(false);
		fileMenu.setFocusPainted(false);		
		menuBar.add(fileMenu);	
		fileMenu.addActionListener(menuListener);
		currentButton = fileMenu;
		
		// Add "Options" as a JMenuItem since it has no sub-menu.
		
		optionMenu = new JButton("Options");
		optionMenu.setContentAreaFilled(false);
		optionMenu.setBorderPainted(false);
		optionMenu.setFocusPainted(false);
		menuBar.add(optionMenu);		
		optionMenu.addActionListener(menuListener);

		// Add "Exchanges" as a JMenuItem since it has no sub-menu.
		
		exchangesMenu = new JButton("Exchanges");
		exchangesMenu.setContentAreaFilled(false);
		exchangesMenu.setBorderPainted(false);
		exchangesMenu.setFocusPainted(false);
		menuBar.add(exchangesMenu);		
		exchangesMenu.addActionListener(menuListener);		
		
		// Add "Help" as a JMenuItem since it has no sub-menu.		
				
		helpMenu = new JButton("Help");
		helpMenu.setContentAreaFilled(false);
		helpMenu.setBorderPainted(false);
		helpMenu.setFocusPainted(false);
		menuBar.add(helpMenu);	
		helpMenu.addActionListener(menuListener);
		
		// Add an invisible component to space the "Wallet" item to the right.
		
		menuBar.add(Box.createHorizontalGlue());	
		
		// Add "Wallet" as a JMenuItem since it has no sub-menu.		
		
		walletMenu = new JButton("Wallet");		
		walletMenu.setContentAreaFilled(false);
		walletMenu.setBorderPainted(false);
		walletMenu.setFocusPainted(false);		
		menuBar.add(walletMenu);	
		walletMenu.addActionListener(menuListener);
		
		this.setJMenuBar(menuBar);
		
		// Add the current panel to the frame.
		
		contentPane = getContentPane();
		contentPane.add(currentPanel);
		
		// Set up a window listener to watch window events.
		
		WindowListener windowListener = new WindowListener();
		addWindowListener(windowListener);			
	}	
	
	private class WindowListener extends WindowAdapter {

		// Catch window events where the "X" is clicked on the window.

		public void windowClosing(WindowEvent event) {
			
			System.exit(0);
		}
	}	
	
	private class MenuListener implements ActionListener {

		// Catch selections from sub-menus

		public void actionPerformed (ActionEvent event) {
			
			currentButton.setContentAreaFilled(false);
			JButton clickedButton = (JButton)event.getSource();
			clickedButton.setBackground(Color.LIGHT_GRAY);
			clickedButton.setContentAreaFilled(true);
			currentButton = clickedButton;

			contentPane = getContentPane();
			contentPane.remove(currentPanel);
			currentPanel = panelList.get(event.getActionCommand());
			contentPane.add(currentPanel);
			contentPane.validate();

			repaint();
		}
	}
}




