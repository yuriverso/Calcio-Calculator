package main;

import java.awt.Color;

import javax.swing.JButton;

public class CalcioButton extends JButton{
	
	ButtonsPanel panel;
	
	CalcioButton(ButtonsPanel panel, String text){
		this.panel = panel;
		
		this.setFocusable(false);
		this.setOpaque(false);
		this.setBorder(null);
		this.setBackground(new Color(0,0,0,0));
		this.setText(text);
		
		panel.add(this);
		this.addActionListener(panel);
	}
	

}
