package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberScreen extends JPanel{
	
	final int WIDTH = 250;
	final int HEIGHT = 50;
	
	public JLabel numberLabel;
	public CalcioPanel calcioPanel;
	Font abigailFont;
	
	NumberScreen(CalcioPanel calcioPanel){
		this.calcioPanel = calcioPanel;
		this.setBounds(20, 20, WIDTH, HEIGHT);
		this.setBackground(new Color(0,0,0,0));
		this.setOpaque(false);
		this.setLayout(null);
		
		numberLabel = new JLabel();
		numberLabel.setBounds(5,0,250,50);
		numberLabel.setText("0");
		//Font labelFont = numberLabel.getFont();
		//numberLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 30));
		numberLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		
		
		this.add(numberLabel);
		
		
	}	
	
}
