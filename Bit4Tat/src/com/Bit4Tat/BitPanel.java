package com.Bit4Tat;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

	protected static final long serialVersionUID = 1L;
	protected static final Color headerColor = new Color(240, 240, 240);
	protected static final Color rolloverColor = new Color(245, 245, 255);
	protected static final Color selectedColor = Color.BLUE;	
	protected JButton currentButton;
	protected SubPanel currentSubPanel;
	
	protected JPanel createHeaderPanel(String iconFilename, String headerText) {
		
		JPanel headerPanel = new JPanel(new BorderLayout());

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

		headerTextBox.setDropTarget(null);
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
	
	protected JPanel createSidePanel(BitPanel panel, SubPanel subPanel, String header, String... buttonText) {
		
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
		
		boolean setCurrent = false;
		for (String s: buttonText) {
			
			JButton button = new JButton(s);			
			button.addMouseListener(new RolloverListener(this, subPanel));			
			button.setFont(new Font("Verdana", Font.BOLD, 16));
			button.setContentAreaFilled(true);
			button.setBackground(Color.WHITE);
			button.setFocusPainted(false);
			button.setBorderPainted(false);
			
			if (setCurrent == false) {
				setCurrent = true;
				button.setForeground(selectedColor);
				panel.currentButton = button;				
			}
			
			boxList.add(button);
		}

		sidePanel.add(boxList);
		sidePanel.add(Box.createRigidArea(new Dimension(10, 0)));			

		return sidePanel;
	}
	
	class SubPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public SubPanel () {

			this.setDoubleBuffered(true);			
			this.setBackground(Color.WHITE);	
		}
		
		public SubPanel (String header) {

			this.setDoubleBuffered(true);			
			this.setBackground(Color.WHITE);
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
			JLabel headerText = new JLabel (header);
			headerText.setFont(new Font("Verdana", Font.BOLD, 16));
			this.add(Box.createRigidArea(new Dimension(10, 0)));		
			this.add(Box.createRigidArea(new Dimension(0, 10)));		
			this.add(headerText);			
		}		
		
		@Override
        public void paintComponent(Graphics g) {
            Graphics2D graphics2d = (Graphics2D) g;
            graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            super.paintComponent(g);
        }				
	}
	
	class RolloverListener extends MouseAdapter {
		
		BitPanel mainPanel;
		SubPanel subPanel;
		
		public RolloverListener (BitPanel panel, SubPanel subPanel) {
			this.mainPanel = panel;
			this.subPanel = subPanel;
		}
		
		public void mouseEntered(MouseEvent e) {
			((JButton)e.getComponent()).setBackground(rolloverColor);
			repaint();
		}
		
		public void mouseExited(MouseEvent e) {
			((JButton)e.getComponent()).setBackground(Color.WHITE);
			repaint();			
		}
		
		public void mouseClicked(MouseEvent e) {
			
			if (currentButton != null)
				currentButton.setForeground(Color.DARK_GRAY);
			
			currentButton = (JButton)e.getComponent();
			currentButton.setForeground(selectedColor);		
			
			CardLayout cl = (CardLayout)subPanel.getLayout();
			cl.show(subPanel, currentButton.getText());			
			
			subPanel.validate();
		}
	}
}


