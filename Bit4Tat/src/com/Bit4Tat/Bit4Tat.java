// TODO:
// Documentation!

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
import java.util.HashMap;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
	private JButton fileMenu;
	private JButton optionMenu;
	private JButton helpMenu;
	private JButton walletMenu;
	private JButton currentButton;
	private JPanel	currentPanel;
	private Container contentPane;
	private HashMap<String, BitPanel> panelMap;
	
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
		
		// Create the HashMap of valid BitPanels (one for each menu item).
		
		// TODO: getter/setter for BitPanel to hide implementation?
		panelMap = new HashMap<String, BitPanel>();
		panelMap.put("File", new BitPanel.FilePanel());
		panelMap.put("Options", new BitPanel.OptionsPanel());
		panelMap.put("Help", new BitPanel.HelpPanel());
		panelMap.put("Wallet", new BitPanel.WalletPanel());
		currentPanel = panelMap.get("Wallet");

		// Set up the menu bar and the menu listener.
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		MenuListener menuListener = new MenuListener();
		
		// Add the file JMenu to the menu bar.
		
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

		// Add "Help" as a JMenuItem since it has no sub-menu.		
				
		helpMenu = new JButton("Help");
		helpMenu.setContentAreaFilled(false);
		helpMenu.setBorderPainted(false);
		helpMenu.setFocusPainted(false);
		menuBar.add(helpMenu);	
		helpMenu.addActionListener(menuListener);
		
		// Add an invisible component to space the "Wallet" item to the right.
		
		// TODO: fix this!
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
		
		// TODO: what layout should each use?  I should do this above actually
		//currentPanel.setLayout()?)
		
		contentPane = getContentPane();
		System.out.println(currentPanel.toString());
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
			
			String s = event.getActionCommand();
			
			System.out.println(event.getActionCommand());
			
			currentButton.setContentAreaFilled(false);
			JButton clickedButton = (JButton)event.getSource();
			clickedButton.setBackground(Color.LIGHT_GRAY);
			clickedButton.setContentAreaFilled(true);
			currentButton = clickedButton;

			contentPane = getContentPane();
			contentPane.remove(currentPanel);
			currentPanel = panelMap.get(event.getActionCommand());
			contentPane.add(currentPanel);
			contentPane.validate();
			//System.out.println(currentPanel);
			repaint();
		}
	}
}




