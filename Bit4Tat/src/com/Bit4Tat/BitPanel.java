package com.Bit4Tat;

import javax.swing.JPanel;
import javax.swing.JTextArea;

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
			
		}		
	}
	
	static class WalletPanel extends BitPanel {

		private static final long serialVersionUID = 1L;
		
		public WalletPanel() {
		
			JTextArea testBox = new JTextArea();
			testBox.setText("Welcome to the world of Bitcoin Wallets");
			this.add(testBox);
		}
	}
}





