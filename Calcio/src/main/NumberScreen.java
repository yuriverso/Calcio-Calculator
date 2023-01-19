package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class NumberScreen extends JPanel{
	
	final int WIDTH = 250;
	final int HEIGHT = 50;
	
	final int displayLength = 10;
	String numberToDisplay;
	public CalcioPanel calcioPanel;
	public JLabel displayLabel;
	
	NumberScreen(CalcioPanel calcioPanel){
		this.calcioPanel = calcioPanel;
		this.setBounds(40, 70, WIDTH, HEIGHT);
		this.setBackground(Color.red);
		this.setOpaque(false);
		this.setLayout(null);
		
		numberToDisplay = "0";
		setDisplayLabel();	
	}	
	
	public void setDisplayLabel() {
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/arialr.ttf"));
			displayLabel = new JLabel(numberToDisplay);
			displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			displayLabel.setBounds(5, 5, 200, 45);
			displayLabel.setForeground(Color.PINK);
			//displayLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			displayLabel.setFont(font.deriveFont(Font.BOLD, 40f));
            add(displayLabel);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
	}
	
}
