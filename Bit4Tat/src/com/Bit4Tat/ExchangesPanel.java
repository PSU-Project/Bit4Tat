    /**
     * 	ExchangesPanel.java - A JPanel to display exchange information.
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
import javax.swing.JLabel;
import javax.swing.JPanel;

class ExchangesPanel extends BitPanel {

	private static final long serialVersionUID = 1L;	
	
	public ExchangesPanel(Wallet w) {
		
		super(w);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.add(createHeaderPanel("exchanges_small.png", "Exchanges"), BorderLayout.NORTH);												

		SubPanel subPanel = new SubPanel();
		subPanel.setLayout(new CardLayout());
		subPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
		
		/**
		 * MT. GOX TICKER PANEL
		 */
		
		SubPanel mtGoxPanel = new SubPanel ("Mt. Gox Ticker");
		mtGoxPanel.add(new JLabel(" "));		
		mtGoxPanel.add(new JLabel(" "));
		
		// Add the ticker components here:
		// {"ticker":{"high":10.4959,"low":8.45099,"avg":9.595957131,"vwap":9.485441665,"vol":56999,"last":9.3502,"buy":9.3502,"sell":9.35761}}
		//ResponseContainer info = w.checkTicker("mtgox");
	
		
		mtGoxPanel.add(new HeaderLabel("High"));
		mtGoxPanel.add(new JLabel(" "));
		mtGoxPanel.add(new JLabel(""));
		mtGoxPanel.add(new JLabel(" "));		
		mtGoxPanel.add(new HeaderLabel("Average"));
		mtGoxPanel.add(new JLabel(" "));		
		mtGoxPanel.add(new JLabel(""));
		mtGoxPanel.add(new JLabel(" "));
		mtGoxPanel.add(new HeaderLabel("Volume"));
		mtGoxPanel.add(new JLabel(" "));		
		mtGoxPanel.add(new JLabel(""));
		mtGoxPanel.add(new JLabel(" "));
		mtGoxPanel.add(new HeaderLabel("Last"));
		mtGoxPanel.add(new JLabel(" "));		
		mtGoxPanel.add(new JLabel(""));
		mtGoxPanel.add(new JLabel(" "));
		mtGoxPanel.add(new HeaderLabel("Buy"));
		mtGoxPanel.add(new JLabel(" "));		
		mtGoxPanel.add(new JLabel(""));
		mtGoxPanel.add(new JLabel(" "));
		mtGoxPanel.add(new HeaderLabel("Sell"));
		mtGoxPanel.add(new JLabel(" "));		
		mtGoxPanel.add(new JLabel(""));

		subPanel.add("Mt. Gox", mtGoxPanel);

		/**
		 * TRADEHILL TICKER PANEL
		 */		
		
		SubPanel tradehillPanel = new SubPanel ("Tradehill");					
		subPanel.add("Tradehill", tradehillPanel);
		
		JPanel sidePanel = createSidePanel(this, subPanel, "Exchanges", "Mt. Gox", "Tradehill");
		
		this.add(sidePanel, BorderLayout.WEST);
		this.add(subPanel);
		currentSubPanel = mtGoxPanel;
	}	
}
