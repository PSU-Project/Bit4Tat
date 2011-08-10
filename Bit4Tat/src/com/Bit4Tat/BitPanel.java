package com.Bit4Tat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BitPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	static class FilePanel extends BitPanel {

		private static final long serialVersionUID = 1L;

		public FilePanel() {
			
		}		
	}
	
	static class OptionsPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public OptionsPanel() {
			
		}
	}

	static class HelpPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public HelpPanel() {
			
			this.setLayout(new GridBagLayout());
			this.setBackground(Color.WHITE);
						
			BufferedImage cornerLogo = null;			
			JLabel cornerLabel = null;			

			GridBagConstraints cornerBoxConstraints = new GridBagConstraints();
			cornerBoxConstraints.gridx = 0;
			cornerBoxConstraints.gridy = 0;
			
			try {
				//String cwd = System.getProperty("user.dir");

				File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "help_small.png");
				System.out.println(f.getPath());
				cornerLogo = ImageIO.read(f);
			} catch (IOException e) {
				System.err.println("There was a problem reading help_small.png from the disk.  Is it in the correct location?");
				e.printStackTrace();
			}
			
			if (cornerLogo != null) {
				cornerLabel = new JLabel(new ImageIcon(cornerLogo));
			}
			else {
				cornerLabel = new JLabel();
			}			
			
			this.add(cornerLabel, cornerBoxConstraints);
			
			GridBagConstraints helpBoxHeaderConstraints = new GridBagConstraints();			
			JTextField helpBoxHeader = new JTextField() {            

				private static final long serialVersionUID = 1L;

				@Override
	            public void paintComponent(Graphics g) {
	                Graphics2D graphics2d = (Graphics2D) g;
	                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                        RenderingHints.VALUE_ANTIALIAS_ON);
	                super.paintComponent(g);
	            }
			};
			
			helpBoxHeader.setText("Help");
			helpBoxHeader.setHorizontalAlignment(JTextField.LEFT);
			helpBoxHeader.setFont(new Font("Verdana", Font.BOLD, 72));
			helpBoxHeader.setEditable(false);
			helpBoxHeader.setOpaque(false);
			helpBoxHeader.setFocusable(false);
			helpBoxHeader.setBorder(BorderFactory.createEmptyBorder());
			helpBoxHeaderConstraints.gridx = 1;
			helpBoxHeaderConstraints.gridy = 0;
			helpBoxHeaderConstraints.weightx = 0.5;
			helpBoxHeaderConstraints.weighty = 0;
			this.add(helpBoxHeader, helpBoxHeaderConstraints);

			
		}		
	}
	
	static class WalletPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public WalletPanel() {
		
			this.setLayout(new GridBagLayout());
			this.setBackground(Color.WHITE);
			
			GridBagConstraints cornerBoxConstraints = new GridBagConstraints();
			BufferedImage cornerLogo = null;
			BufferedImage balanceLogo = null;
			JLabel cornerLabel = null;			
			
			try {
				//String cwd = System.getProperty("user.dir");

				File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "wallet_small.png");
				System.out.println(f.getPath());
				cornerLogo = ImageIO.read(f);
			} catch (IOException e) {
				System.err.println("There was a problem reading wallet_small.png from the disk.  Is it in the correct location?");
				e.printStackTrace();
			}
			
			if (cornerLogo != null) {
				cornerLabel = new JLabel(new ImageIcon(cornerLogo));
			}
			else {
				cornerLabel = new JLabel();
			}
			
/*			testBox.setText("BITCOINS");
			testBox.setEditable(false);
			testBox.setFocusable(false);
			testBox.setOpaque(false);
			testBox.setBorder(BorderFactory.createEmptyBorder());*/
			cornerBoxConstraints.gridx = 0;
			cornerBoxConstraints.gridy = 0;
			this.add(cornerLabel, cornerBoxConstraints);
			
			GridBagConstraints walletBoxHeaderConstraints = new GridBagConstraints();			
			JTextField walletBoxHeader = new JTextField() {            

				private static final long serialVersionUID = 1L;

				@Override
	            public void paintComponent(Graphics g) {
	                Graphics2D graphics2d = (Graphics2D) g;
	                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                        RenderingHints.VALUE_ANTIALIAS_ON);
	                super.paintComponent(g);
	            }
			};

			walletBoxHeader.setText("Wallet");
			walletBoxHeader.setHorizontalAlignment(JTextField.LEFT);
			walletBoxHeader.setFont(new Font("Verdana", Font.BOLD, 72));
			walletBoxHeader.setEditable(false);
			walletBoxHeader.setOpaque(false);
			walletBoxHeader.setFocusable(false);
			walletBoxHeader.setBorder(BorderFactory.createEmptyBorder());
			//walletBoxHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.DARK_GRAY));
			walletBoxHeaderConstraints.gridx = 1;
			walletBoxHeaderConstraints.gridy = 0;
			walletBoxHeaderConstraints.weightx = 0.5;
			walletBoxHeaderConstraints.weighty = 0;
			this.add(walletBoxHeader, walletBoxHeaderConstraints);			
			
			GridBagConstraints exchangeBoxConstraints = new GridBagConstraints();
			JTextField exchangeBox = new JTextField();
			exchangeBox.setFont(new Font("Verdana", Font.BOLD, 24));
			exchangeBox.setText("Exchanges");
			exchangeBox.setEditable(false);
			exchangeBox.setOpaque(false);
			exchangeBox.setFocusable(false);
			exchangeBox.setBorder(BorderFactory.createEmptyBorder());
			//exchangeBox.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.DARK_GRAY));
			exchangeBoxConstraints.gridx = 0;
			exchangeBoxConstraints.gridy = 1;
			exchangeBoxConstraints.weighty = 0.1;
			//exchangeBoxConstraints.gridheight = 2;
			//exchangeBoxConstraints.fill = GridBagConstraints.VERTICAL;
			this.add(exchangeBox, exchangeBoxConstraints);
			
			GridBagConstraints exchangeBoxListConstraints = new GridBagConstraints();			
			JPanel exchangeBoxList = new JPanel() {
				private static final long serialVersionUID = 1L;

				@Override
	            public void paintComponent(Graphics g) {
	                Graphics2D graphics2d = (Graphics2D) g;
	                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                        RenderingHints.VALUE_ANTIALIAS_ON);
	                super.paintComponent(g);
	            }				
			};
			
			exchangeBoxList.setBackground(Color.WHITE);
			exchangeBoxList.setBorder(BorderFactory.createEmptyBorder());
			exchangeBoxListConstraints.gridx = 0;
			exchangeBoxListConstraints.gridy = 2;
			exchangeBoxListConstraints.weighty = 0.2;
			//exchangeBoxListConstraints.gridheight = 2;
			exchangeBoxListConstraints.fill = GridBagConstraints.VERTICAL;
			
			//GridBagConstraints exchangeBoxListButtonConstraints = new GridBagConstraints();			
			JButton exchangeBoxListButton = new JButton("Mt. Gox");
			exchangeBoxListButton.setFont(new Font("Verdana", Font.BOLD, 16));
			//exchangeBoxListButton.setHorizontalTextPosition(SwingConstants.LEFT);
			//exchangeBoxListButton.setOpaque(false);
			exchangeBoxListButton.setContentAreaFilled(false);
			exchangeBoxListButton.setFocusPainted(false);
			exchangeBoxListButton.setBorderPainted(false);
			exchangeBoxList.add(exchangeBoxListButton);
			this.add(exchangeBoxList, exchangeBoxListConstraints);
			
			GridBagConstraints walletPanelConstraints = new GridBagConstraints();			
			JPanel walletPanel = new JPanel();	
			walletPanel.setBackground(Color.WHITE);
			walletPanelConstraints.gridx = 1;
			walletPanelConstraints.gridy = 1;
			walletPanelConstraints.weighty = 0.0;
			walletPanelConstraints.weightx = 0.5;
			walletPanelConstraints.gridheight = 3;
			walletPanelConstraints.gridwidth = 2;
			walletPanelConstraints.fill = GridBagConstraints.BOTH;		
			
			try {
				//String cwd = System.getProperty("user.dir");

				File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "logo_small.png");
				System.out.println(f.getPath());
				balanceLogo = ImageIO.read(f);
			} catch (IOException e) {
				System.err.println("There was a problem reading wallet_small.png from the disk.  Is it in the correct location?");
				e.printStackTrace();
			}			
			
			JLabel walletLabel = null;
			if (balanceLogo != null) {
				walletLabel = new JLabel(new ImageIcon(balanceLogo));
			}
			else {
				walletLabel = new JLabel();
			}			
			//walletLabel.

			walletPanel.add(walletLabel);
			this.add(walletPanel, walletPanelConstraints);
		}
	}
}






