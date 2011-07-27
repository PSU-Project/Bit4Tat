package com.Bit4Tat;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Bit4Tat {

	/**
	 * Bit4Tat - An open source Bitcoin trader
	 * Copyright © 2011 Josh Dorothy, Ben Harrington, Max Thayer
	 * Please see the title COPYING in this distribution for license terms.
	 * 
	 */
	static final String USER = "Bit4Tat";
	static final String PASS = "mgbit4tat";
	static final String version = "1.0";
	
	public static void main(String[] args) 
	{			
		// Welcome to Bit4Tat, the coolest evar
		SchedulerGateway simpleScheduler = new DefaultScheduler();
		
		Wallet coinPurse = new Wallet("Bit4Tat", "mgbit4tat");
		coinPurse.changeService("mtgox");
		
		//this kind of crazy talk is on the chopping block
		coinPurse.getPayGate().printCurrentProcessor();
		
		coinPurse = simpleScheduler.pollBalance(coinPurse);
		
		BitFrame frame = new BitFrame();
		frame.setTitle("Bit4Tat " + version);
		frame.setVisible(true);

	}

}

class BitFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem fileMenuItem_Exit;
	private JMenu fileMenu;
	private JMenuItem optionMenu;
	private JMenuItem helpMenu;
	private JMenuItem walletMenu;
	
	public BitFrame() {
		
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
				
		// Set up the menu bar and the menu listener.
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		MenuListener menuListener = new MenuListener();
		
		// Add the file JMenu to the menu bar.
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		// Add the "Exit" JMenuItem to the file menu.
		
		fileMenuItem_Exit = new JMenuItem("Exit");
		fileMenu.add(fileMenuItem_Exit);
		fileMenuItem_Exit.addActionListener(menuListener);		
		
		// Add "Options" as a JMenuItem since it has no sub-menu.
		
		optionMenu = new JMenuItem("Options");
		menuBar.add(optionMenu);
		optionMenu.addActionListener(menuListener);

		// Add "Help" as a JMenuItem since it has no sub-menu.		
				
		helpMenu = new JMenuItem("Help");
		menuBar.add(helpMenu);	
		helpMenu.addActionListener(menuListener);
		
		
		// Add "Wallet" as a JMenuItem since it has no sub-menu.		
		
		walletMenu = new JMenuItem("Wallet");		
		menuBar.add(walletMenu);	
		walletMenu.addActionListener(menuListener);
		
		// Add an invisible component to space the "Wallet" item to the right.
		
		// TODO: fix this!
		menuBar.add(Box.createHorizontalGlue());
		
		
		this.setJMenuBar(menuBar);
		
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
			
			String s = event.getActionCommand();
			
			System.out.println(event.getActionCommand());
			
			if (s.equals("Exit"))
				System.exit(0);
		}
		
	}

}




