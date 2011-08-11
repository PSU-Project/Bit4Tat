package com.Bit4Tat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class FilePanel extends BitPanel {

	private static final long serialVersionUID = 1L;
	
	public FilePanel() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.add(createHeaderPanel("file_small.png", "File"), BorderLayout.NORTH);	
		
		SubPanel subPanel = new SubPanel();
		subPanel.setLayout(new CardLayout());
		subPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
		
		SubPanel newWalletPanel = new SubPanel ("Create a New Wallet");
		subPanel.add("New Wallet", newWalletPanel);
		
		SubPanel editWalletPanel = new SubPanel ("Edit a Wallet");
		subPanel.add("Edit Wallet", editWalletPanel);

		SubPanel loadWalletPanel = new SubPanel ("Load a Wallet");
		subPanel.add("Load Wallet", loadWalletPanel);

		SubPanel saveWalletPanel = new SubPanel ("Save a Wallet");
		subPanel.add("Save Wallet", saveWalletPanel);

		JPanel sidePanel = createSidePanel(this, subPanel, "Header", "New Wallet", "Edit Wallet", "Load Wallet", "Save Wallet");
		
		this.add(sidePanel, BorderLayout.WEST);
		this.add(subPanel);
		currentSubPanel = newWalletPanel;					
	}			
}
