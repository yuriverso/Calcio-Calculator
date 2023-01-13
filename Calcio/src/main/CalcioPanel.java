package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalcioPanel extends JPanel {
	
	final int WIDTH = 290;
	final int HEIGHT = 460;
	ButtonsPanel buttonsPanel;
	NumberScreen numberScreen;
	JLabel testLabel;
	BufferedImage backgroundImage;
	
	CalcioPanel(){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//this.setBackground(Color.gray);
		this.setBackground(Color.decode("#EFF2F9"));
		this.setLayout(null);
		this.setOpaque(true);
		
		numberScreen = new NumberScreen(this);

		buttonsPanel = new ButtonsPanel(this);
		this.add(numberScreen);
		this.add(buttonsPanel);
	}
	
	public void paintComponent(Graphics g) {
		//buttonsPanel.button7.setBackground(new Color(0,0,0,0));
		super.paintComponent(g);
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream("/img/calcio_background.jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}//g.drawImage(backgroundImage, 0, 0, this);
		
	}
	
}
