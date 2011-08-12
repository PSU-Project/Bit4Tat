    /**
     * 	OptionsPanel.java - A JPanel to handle program options.
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

class OptionsPanel extends BitPanel {

	private static final long serialVersionUID = 1L;	
	
	public OptionsPanel(Wallet w) {
		
		super(w);
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