    /**
     * 	HelpPanel.java - A JPanel to display help information.
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
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class HelpPanel extends BitPanel {

	private static final long serialVersionUID = 1L;	
	
	public HelpPanel(Wallet w) {

		super(w);
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