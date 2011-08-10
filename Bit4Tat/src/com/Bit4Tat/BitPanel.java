package com.Bit4Tat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BitPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Color headerColor = new Color(240, 240, 240);
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
			
			this.setLayout(new BorderLayout());
			this.setBackground(Color.WHITE);
			
			this.add(createHeaderPanel("file_small.png", "File"), BorderLayout.NORTH);						
			this.add(createSidePanel("Header", "New Wallet", "Edit Wallet", "Load Wallet", "Save Wallet"), BorderLayout.WEST);						

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			panel.add(Box.createRigidArea(new Dimension(0, 10)));			
			panel.setBackground(Color.WHITE);
			panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
			
			this.add(panel);						
		}		
	}
	
	class OptionsPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public OptionsPanel() {
			
			this.setLayout(new BorderLayout());
			this.setBackground(Color.WHITE);
			
			this.add(createHeaderPanel("options_small.png", "Options"), BorderLayout.NORTH);						
			this.add(createSidePanel("Header", "Option 1", "Option 2", "Option 3", "Option 4"), BorderLayout.WEST);						

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			panel.add(Box.createRigidArea(new Dimension(0, 10)));			
			panel.setBackground(Color.WHITE);
			panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
			
			this.add(panel);			
		}
	}

	class HelpPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public HelpPanel() {
			
			this.setLayout(new BorderLayout());
			this.setBackground(Color.WHITE);
			
			this.add(createHeaderPanel("help_small.png", "Help"), BorderLayout.NORTH);						
			this.add(createSidePanel("Help Topics", "Wallet Management", "Adding Exchanges"), BorderLayout.WEST);						

			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			panel.add(Box.createRigidArea(new Dimension(0, 10)));			
			panel.setBackground(Color.WHITE);
			panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
			
			this.add(panel);
		}		
	}
	
	class WalletPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public WalletPanel() {
		
			this.setLayout(new BorderLayout());
			this.setBackground(Color.WHITE);
			
			this.add(createHeaderPanel("logo_small.png", "Wallet"), BorderLayout.NORTH);						
			this.add(createSidePanel("Exchanges", "Mt. Gox", "Tradehill"), BorderLayout.WEST);
						
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			panel.add(Box.createRigidArea(new Dimension(10, 0)));
			panel.add(Box.createRigidArea(new Dimension(0, 10)));			
			panel.setBackground(Color.WHITE);
			panel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.DARK_GRAY));
			
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
			panel.add(balanceText);
			panel.add(Box.createRigidArea(new Dimension(0, 10)));
			
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
			JLabel balance = new JLabel("   3.06");
			
			balance.setFont(new Font("Verdana", Font.PLAIN, 24));			
			balancePanel.add(balance);
			panel.add(balancePanel);
			this.add(panel);
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






