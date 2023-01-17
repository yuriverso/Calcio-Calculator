package main;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class CalcioButton extends JButton{
	
	ButtonsPanel panel;
	String text;
	
	CalcioButton(ButtonsPanel panel, String text){
		this.panel = panel;
		this.text = text;
		
		Border bBorder = BorderFactory.createLineBorder(Color.black);
		this.setBorder(bBorder);
		this.setFocusable(false);
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		this.setText(text);
		this.setForeground(Color.red);
		this.setContentAreaFilled(false);
		
		panel.add(this);
		this.addActionListener(panel);
	}
	

}
