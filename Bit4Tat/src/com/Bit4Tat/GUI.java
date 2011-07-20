package com.Bit4Tat;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;  //notice javax

public class GUI extends JFrame implements ActionListener

{
  JLabel answer = new JLabel(""); // creates a label that text will hang out in later
  JPanel pane = new JPanel(); // creates a panel
  JButton pressme = new JButton("Press Me"); // a button labeled after the arg in its constructor

  GUI() // the frame constructor method
  {
    super("My Simple Frame"); // frame title 
    setBounds(100,100,300,300); // frame dimensions: x, y, width, height
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container con = this.getContentPane(); // inherit main frame
    con.add(pane); // add the panel to frame
    pressme.setMnemonic('P'); // associate hotkey to button
    pressme.addActionListener(this);   // register button listener. this must be called for all action listeners
    pane.add(answer); // adds answer to the pane 
    pane.add(pressme); // adds pressme to the pane
    pressme.requestFocus(); // gives "pressme" focus upon running
    setVisible(true); // display this frame
  }
  @Override
  public void actionPerformed(ActionEvent event) {
	  {
		    Object source = event.getSource();
		    if (source == pressme) // tracks the source and nature of the event. if/else then determines response.
		    {
		    	answer.setText("Button pressed!"); // writes text to the pane itself
		    	JOptionPane.showMessageDialog(null,"I hear you!","Message Dialog",
		    			JOptionPane.PLAIN_MESSAGE); setVisible(true);  // creates a dialog window, like an alert
		    }
	  }
  }
  public static void main(String args[]) {new GUI();}
}