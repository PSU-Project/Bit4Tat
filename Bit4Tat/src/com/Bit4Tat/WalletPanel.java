    /**
     * 	WalletPanel.java - A JPanel to display wallet information.
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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WalletPanel extends BitPanel {

	private static final long serialVersionUID = 1L;
	
	public WalletPanel(Wallet w) {
		super(w);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.add(createHeaderPanel("logo_small.png", "Wallet"), BorderLayout.NORTH);						

					
		SubPanel subPanel = new SubPanel();
		subPanel.setLayout(new CardLayout());
		subPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
		
		SubPanel mtGoxPanel = new SubPanel ("Mt. Gox");
		mtGoxPanel.setLayout(new BoxLayout(mtGoxPanel, BoxLayout.Y_AXIS));
		mtGoxPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		mtGoxPanel.add(Box.createRigidArea(new Dimension(0, 10)));			
		mtGoxPanel.setBackground(Color.WHITE);
		
		BufferedImage balanceLogo = null;
		
		try {
			File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "logo_small.png");
			balanceLogo = ImageIO.read(f);
		} catch (IOException e) {
			System.err.println("There was a problem reading wallet_small.png from the disk.  Is it in the correct location?");
			e.printStackTrace();
		}			
					
		JLabel balanceText = new JLabel("Balance");
		balanceText.setFont(new Font("Verdana", Font.BOLD, 24));			
		mtGoxPanel.add(balanceText);
		mtGoxPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JLabel walletLabel = null;
		if (balanceLogo != null) {
			ImageIcon icon = new ImageIcon(balanceLogo);				
			double scale = 0.25;
			icon.setImage(icon.getImage().getScaledInstance(
					(int)(scale * icon.getIconHeight()),
					(int)(scale * icon.getIconWidth()),
					Image.SCALE_SMOOTH));
			walletLabel = new JLabel(icon);
		}
		else {
			walletLabel = new JLabel();
		}						

		JPanel balancePanel = new JPanel();
		balancePanel.setBackground(Color.WHITE);
		balancePanel.setLayout(new BoxLayout(balancePanel, BoxLayout.X_AXIS));
		balancePanel.add(walletLabel);	
		
		// TODO: Ben - this is where to set the balance.  Replace the dummy
		// text with the appropriate call to your JSON whatever.
		
		
		JLabel balance = new JLabel(w.checkBalance("mtgox").getBitCoins());
		//JLabel balance = new JLabel("1 million dollars!");
		
		balance.setFont(new Font("Verdana", Font.PLAIN, 24));			
		balancePanel.add(balance);
		mtGoxPanel.add(balancePanel);
		subPanel.add("Mt. Gox", mtGoxPanel);	
		
		SubPanel tradehillPanel = new SubPanel ("Tradehill");
		subPanel.add("Tradehill", tradehillPanel);
		
		JPanel sidePanel = createSidePanel(this, subPanel, "Exchanges", "Mt. Gox", "Tradehill");
		
		this.add(sidePanel, BorderLayout.WEST);
		this.add(subPanel);
		currentSubPanel = mtGoxPanel;
	}	
}

