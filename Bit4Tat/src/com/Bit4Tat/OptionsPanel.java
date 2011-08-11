package com.Bit4Tat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class OptionsPanel extends BitPanel {

	private static final long serialVersionUID = 1L;	
	
	public OptionsPanel() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.add(createHeaderPanel("options_small.png", "Options"), BorderLayout.NORTH);												

		SubPanel subPanel = new SubPanel();
		subPanel.setLayout(new CardLayout());
		subPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
		
		SubPanel firstOptionPanel = new SubPanel ("Option 1");
		subPanel.add("Option 1", firstOptionPanel);

		SubPanel secondOptionPanel = new SubPanel ("Option 2");
		subPanel.add("Option 2", secondOptionPanel);

		SubPanel thirdOptionPanel = new SubPanel ("Option 3");
		subPanel.add("Option 3", thirdOptionPanel);

		JPanel sidePanel = createSidePanel(this, subPanel, "Options", "Option 1", "Option 2", "Option 3");
		
		this.add(sidePanel, BorderLayout.WEST);
		this.add(subPanel);
		currentSubPanel = firstOptionPanel;
	}	
}