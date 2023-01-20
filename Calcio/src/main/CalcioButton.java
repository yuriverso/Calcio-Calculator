package main;

import javax.swing.JButton;


// a extension of the JButton class with all the needed configurations
public class CalcioButton extends JButton{
	
	ButtonsPanel panel;
	String text;
	
	CalcioButton(ButtonsPanel panel, String text){
		this.panel = panel;
		this.text = text;
		
		this.setBorder(null);
		this.setFocusable(false);
		this.setOpaque(false);
		this.setText(null);
		this.setContentAreaFilled(false);
		
		panel.add(this);
		this.addActionListener(panel);
	}
	

}
