package com.Bit4Tat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class HelpPanel extends BitPanel {

	private static final long serialVersionUID = 1L;	
	
	public HelpPanel() {

		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.add(createHeaderPanel("help_small.png", "Help"), BorderLayout.NORTH);						
						
		SubPanel subPanel = new SubPanel();
		subPanel.setLayout(new CardLayout());
		subPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
		
		SubPanel helpManagementPanel = new SubPanel ("Wallet Management");
		subPanel.add("Wallet Management", helpManagementPanel);
		
		SubPanel helpExchangesPanel = new SubPanel ("Working With Exchanges");
		subPanel.add("Exchanges", helpExchangesPanel);

		JPanel sidePanel = createSidePanel(this, subPanel, "Topics", "Wallet Management", "Exchanges");
		
		this.add(sidePanel, BorderLayout.WEST);
		this.add(subPanel);
		currentSubPanel = helpManagementPanel;
	}			
}