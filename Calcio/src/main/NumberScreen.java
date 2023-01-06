package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberScreen extends JPanel{
	
	final int WIDTH = 250;
	final int HEIGHT = 50;
	
	public JLabel numberLabel;
	public CalcioPanel calcioPanel;
	
	NumberScreen(CalcioPanel calcioPanel){
		this.calcioPanel = calcioPanel;
		this.setBounds(20, 10, WIDTH, HEIGHT);
		this.setBackground(Color.cyan);
		this.setLayout(null);
		
		numberLabel = new JLabel();
		numberLabel.setBounds(5,0,250,50);
		numberLabel.setText("0");
		Font labelFont = numberLabel.getFont();
		numberLabel.setFont(new Font(labelFont.getName(), Font.PLAIN, 30));
		
		this.add(numberLabel);
		
		
	}

}
