package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class CalcioPanel extends JPanel {
	
	final int WIDTH = 290;
	final int HEIGHT = 400;
	ButtonsPanel buttonsPanel;
	NumberScreen numberScreen;
	
	CalcioPanel(){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setLayout(null);
		
		numberScreen = new NumberScreen(this);
		buttonsPanel = new ButtonsPanel(this);
		this.add(numberScreen);
		this.add(buttonsPanel);
	}
	
}
