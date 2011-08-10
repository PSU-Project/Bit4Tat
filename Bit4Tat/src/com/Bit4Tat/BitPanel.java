package com.Bit4Tat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
	private static final Color headerColor = new Color(240, 240, 240);
	private static final Color lightHeaderColor = new Color(250, 250, 250);
	private static final Color rolloverColor = new Color(245, 245, 255);
	
	Hashtable<String, BitPanel> panelList;
	
	public void createPanels () {
		panelList = new Hashtable<String, BitPanel>();
		panelList.put("File", new FilePanel());
		panelList.put("Options", new OptionsPanel());
		panelList.put("Help", new HelpPanel());
		panelList.put("Wallet", new WalletPanel());
	}
	
	public BitPanel getPanel(String s) {
		return panelList.get(s);
	}

	class FilePanel extends BitPanel {

		private static final long serialVersionUID = 1L;

		public FilePanel() {
			
			this.setLayout(new GridBagLayout());
			this.setBackground(Color.WHITE);
						
			BufferedImage cornerLogo = null;			
			JLabel cornerLabel = null;			

			GridBagConstraints cornerBoxConstraints = new GridBagConstraints();
			cornerBoxConstraints.gridx = 0;
			cornerBoxConstraints.gridy = 0;
			
			try {
				//String cwd = System.getProperty("user.dir");

				File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "file_small.png");
				//System.out.println(f.getPath());
				cornerLogo = ImageIO.read(f);
			} catch (IOException e) {
				System.err.println("There was a problem reading file_small.png from the disk.  Is it in the correct location?");
				e.printStackTrace();
			}
			
			if (cornerLogo != null) {
				cornerLabel = new JLabel(new ImageIcon(cornerLogo));
			}
			else {
				cornerLabel = new JLabel();
			}			
			
			this.add(cornerLabel, cornerBoxConstraints);
			
			GridBagConstraints fileBoxHeaderConstraints = new GridBagConstraints();			
			JTextField fileBoxHeader = new JTextField() {            

				private static final long serialVersionUID = 1L;

				@Override
	            public void paintComponent(Graphics g) {
	                Graphics2D graphics2d = (Graphics2D) g;
	                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                        RenderingHints.VALUE_ANTIALIAS_ON);
	                super.paintComponent(g);
	            }
			};
			
			fileBoxHeader.setText("File");
			fileBoxHeader.setHorizontalAlignment(JTextField.LEFT);
			fileBoxHeader.setFont(new Font("Verdana", Font.BOLD, 72));
			fileBoxHeader.setEditable(false);
			fileBoxHeader.setOpaque(false);
			fileBoxHeader.setFocusable(false);
			fileBoxHeader.setBorder(BorderFactory.createEmptyBorder());
			fileBoxHeaderConstraints.gridx = 1;
			fileBoxHeaderConstraints.gridy = 0;
			fileBoxHeaderConstraints.weightx = 0.5;
			fileBoxHeaderConstraints.weighty = 0;
			this.add(fileBoxHeader, fileBoxHeaderConstraints);

			JPanel fileTextPanel = new JPanel();
			GridBagConstraints fileTextPanelConstraints = new GridBagConstraints();
			fileTextPanel.setBackground(Color.WHITE);
			fileTextPanelConstraints.gridx = 0;
			fileTextPanelConstraints.gridy = 1;
			fileTextPanelConstraints.gridheight = 2;
			fileTextPanelConstraints.gridwidth = 3;
			fileTextPanelConstraints.weighty = 0.5;
			fileTextPanelConstraints.fill = GridBagConstraints.BOTH;
			this.add(fileTextPanel, fileTextPanelConstraints);						
		}		
	}
	
	class OptionsPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public OptionsPanel() {
			
			this.setLayout(new GridBagLayout());
			this.setBackground(Color.WHITE);
						
			BufferedImage cornerLogo = null;			
			JLabel cornerLabel = null;			

			GridBagConstraints cornerBoxConstraints = new GridBagConstraints();
			cornerBoxConstraints.gridx = 0;
			cornerBoxConstraints.gridy = 0;
			
			try {
				//String cwd = System.getProperty("user.dir");

				File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "options_small.png");
				//System.out.println(f.getPath());
				cornerLogo = ImageIO.read(f);
			} catch (IOException e) {
				System.err.println("There was a problem reading options_small.png from the disk.  Is it in the correct location?");
				e.printStackTrace();
			}
			
			if (cornerLogo != null) {
				cornerLabel = new JLabel(new ImageIcon(cornerLogo));
			}
			else {
				cornerLabel = new JLabel();
			}			
			
			this.add(cornerLabel, cornerBoxConstraints);
			
			GridBagConstraints optionsBoxHeaderConstraints = new GridBagConstraints();			
			JTextField optionBoxHeader = new JTextField() {            

				private static final long serialVersionUID = 1L;

				@Override
	            public void paintComponent(Graphics g) {
	                Graphics2D graphics2d = (Graphics2D) g;
	                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                        RenderingHints.VALUE_ANTIALIAS_ON);
	                super.paintComponent(g);
	            }
			};
			
			optionBoxHeader.setText("Options");
			optionBoxHeader.setHorizontalAlignment(JTextField.LEFT);
			optionBoxHeader.setFont(new Font("Verdana", Font.BOLD, 72));
			optionBoxHeader.setEditable(false);
			optionBoxHeader.setOpaque(false);
			optionBoxHeader.setFocusable(false);
			optionBoxHeader.setBorder(BorderFactory.createEmptyBorder());
			optionsBoxHeaderConstraints.gridx = 1;
			optionsBoxHeaderConstraints.gridy = 0;
			optionsBoxHeaderConstraints.weightx = 0.5;
			optionsBoxHeaderConstraints.weighty = 0;
			this.add(optionBoxHeader, optionsBoxHeaderConstraints);

			JPanel optionTextPanel = new JPanel();
			GridBagConstraints optionTextPanelConstraints = new GridBagConstraints();
			optionTextPanel.setBackground(Color.WHITE);
			optionTextPanelConstraints.gridx = 0;
			optionTextPanelConstraints.gridy = 1;
			optionTextPanelConstraints.gridheight = 2;
			optionTextPanelConstraints.gridwidth = 3;
			optionTextPanelConstraints.weighty = 0.5;
			optionTextPanelConstraints.fill = GridBagConstraints.BOTH;
			this.add(optionTextPanel, optionTextPanelConstraints);			
			
		}
	}

	class HelpPanel extends BitPanel {

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
				//System.out.println(f.getPath());
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

			JPanel helpTextPanel = new JPanel();
			GridBagConstraints helpTextPanelConstraints = new GridBagConstraints();
			helpTextPanel.setBackground(Color.WHITE);
			helpTextPanelConstraints.gridx = 0;
			helpTextPanelConstraints.gridy = 1;
			helpTextPanelConstraints.gridheight = 2;
			helpTextPanelConstraints.gridwidth = 3;
			helpTextPanelConstraints.weighty = 0.5;
			helpTextPanelConstraints.fill = GridBagConstraints.BOTH;
			this.add(helpTextPanel, helpTextPanelConstraints);
		}		
	}
	
	class WalletPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public WalletPanel() {
		
			this.setLayout(new BorderLayout());
			this.setBackground(Color.WHITE);
			
			this.add(createHeaderPanel("logo_small.png", "Wallet"), BorderLayout.NORTH);						
			this.add(createSidePanel("Exchanges", "Mt. Gox", "Tradehill"), BorderLayout.WEST);
						
			JPanel walletPanel = new JPanel();
			walletPanel.setLayout(new BoxLayout(walletPanel, BoxLayout.Y_AXIS));
			walletPanel.add(Box.createRigidArea(new Dimension(10, 0)));
			walletPanel.add(Box.createRigidArea(new Dimension(0, 10)));			
			walletPanel.setBackground(Color.WHITE);
			walletPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
			
			BufferedImage balanceLogo = null;
			
			try {
				File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + "logo_small.png");
				System.out.println(f.getPath());
				balanceLogo = ImageIO.read(f);
			} catch (IOException e) {
				System.err.println("There was a problem reading wallet_small.png from the disk.  Is it in the correct location?");
				e.printStackTrace();
			}			
						
			JLabel balanceText = new JLabel("Balance");
			balanceText.setFont(new Font("Verdana", Font.BOLD, 32));			
			walletPanel.add(balanceText);
			walletPanel.add(Box.createRigidArea(new Dimension(0, 10)));
			
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
			JLabel balance = new JLabel("   3.06");
			balance.setFont(new Font("Verdana", Font.PLAIN, 24));			
			balancePanel.add(balance);
			walletPanel.add(balancePanel);
			this.add(walletPanel);
		}
	}
		
	private JPanel createHeaderPanel(String iconFilename, String headerText) {
		
		JPanel headerPanel = new JPanel(new BorderLayout());

		//headerPanel.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.NORTH);
		
		JPanel headerTempPanel = new JPanel();
		headerTempPanel.setLayout(new BoxLayout(headerTempPanel, BoxLayout.LINE_AXIS));
		headerTempPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		headerTempPanel.setBackground(headerColor);
		headerTempPanel.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, headerColor));
		
		BufferedImage cornerLogo = null;
		JLabel cornerLabel = null;			
		
		try {
			File f = new File(System.getProperty("user.dir") + File.separator + "res" + File.separator + iconFilename);
			cornerLogo = ImageIO.read(f);
		} catch (IOException e) {
			System.err.println("There was a problem reading " + iconFilename + " from the disk.  Is it in the correct location?");
			e.printStackTrace();
		}
		
		if (cornerLogo != null) {
			cornerLabel = new JLabel(new ImageIcon(cornerLogo));
		}
		else {
			cornerLabel = new JLabel();
		}
		
		headerTempPanel.add(cornerLabel);
					
		JTextField headerTextBox = new JTextField() {

			private static final long serialVersionUID = 1L;

			@Override
            public void paintComponent(Graphics g) {
                Graphics2D graphics2d = (Graphics2D) g;
                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g);
            }
		};

		headerTextBox.setLayout(new BorderLayout());
		headerTextBox.setText(headerText);
		headerTextBox.setHorizontalAlignment(JTextField.RIGHT);
		headerTextBox.setFont(new Font("Verdana", Font.BOLD, 64));
		headerTextBox.setEditable(false);
		headerTextBox.setOpaque(false);
		headerTextBox.setFocusable(false);
		headerTextBox.setBorder(BorderFactory.createEmptyBorder());
		headerTempPanel.add(headerTextBox);
		headerTempPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		headerPanel.add(headerTempPanel, BorderLayout.CENTER);
//		headerPanel.add(Box.createRigidArea(new Dimension(0, 10)), BorderLayout.SOUTH);

		return headerTempPanel;
	}
	
	private JPanel createSidePanel(String header, String... boxes) {
		
		JPanel sidePanel = new JPanel();
		
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.add(Box.createRigidArea(new Dimension(0, 10)));			
		sidePanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.DARK_GRAY));			
		
		JButton headerBox = new JButton(" " + header + " ");
		headerBox.setFont(new Font("Verdana", Font.BOLD, 24));
		headerBox.setContentAreaFilled(false);
		headerBox.setOpaque(false);
		headerBox.setFocusable(false);
		headerBox.setBackground(Color.WHITE);
		headerBox.setBorder(BorderFactory.createEmptyBorder());
		
		sidePanel.add(headerBox, JButton.CENTER);
		sidePanel.add(Box.createRigidArea(new Dimension(0, 20)));
					
		JPanel boxList = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
            public void paintComponent(Graphics g) {
                Graphics2D graphics2d = (Graphics2D) g;
                graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g);
            }				
		};
		boxList.setBackground(Color.WHITE);
		boxList.setBorder(BorderFactory.createEmptyBorder());
		boxList.setLayout(new BoxLayout(boxList, BoxLayout.Y_AXIS));		
		
		for (String s: boxes) {

			JButton button = new JButton(s);
			button.addMouseListener(new RolloverListener());			
			button.setFont(new Font("Verdana", Font.BOLD, 16));
			button.setContentAreaFilled(true);
			button.setBackground(Color.WHITE);
			button.setFocusPainted(false);
			button.setBorderPainted(false);
			boxList.add(button);
		}

		sidePanel.add(boxList);
		sidePanel.add(Box.createRigidArea(new Dimension(10, 0)));			

		return sidePanel;
	}
	
	class RolloverListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			((JButton)e.getComponent()).setBackground(rolloverColor);
			repaint();
		}
		
		public void mouseExited(MouseEvent e) {
			((JButton)e.getComponent()).setBackground(Color.WHITE);
			repaint();			
		}
		
		public void mouseClicked(MouseEvent e) {

		}
	}
}






