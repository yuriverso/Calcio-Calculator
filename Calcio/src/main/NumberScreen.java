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
import javax.swing.border.Border;

public class NumberScreen extends JPanel{
	
	final int WIDTH = 250;
	final int HEIGHT = 50;

	String numberToDisplay;
	public CalcioPanel calcioPanel;
	
	int[] coordArray = {0,25,50,75,100,125,150,175,200,225,250};
	
	public JLabel label0, label1, label2, label3,
	label4, label5, label6, label7, label8, label9, label10;
	
	public JLabel[] labelArray = {label0, label1, label2, label3,
			label4, label5, label6, label7, label8, label9, label10}; 
	
	BufferedImage oneImage, twoImage, threeImage,
		fourImage, fiveImage, sixImage, sevenImage,
		eightImage, nineImage, zeroImage, pointImage;
	
	ImageIcon oneIcon, twoIcon, threeIcon, fourIcon,
		fiveIcon, sixIcon, sevenIcon, eightIcon, nineIcon,
		zeroIcon, pointIcon;
	
	NumberScreen(CalcioPanel calcioPanel){
		this.calcioPanel = calcioPanel;
		this.setBounds(20, 20, WIDTH, HEIGHT);
		this.setBackground(new Color(0,0,0,0));
		this.setOpaque(false);
		this.setLayout(null);
		
		loadImages();
		createNumericLabels();
		paintNumber('0',0);
		
		numberToDisplay = "0";
		
	}	

	
	public void paintNumber(char num, int pos) {
		switch(num) {
		case '0':
			labelArray[pos].setIcon(zeroIcon);
			break;
		case '1':
			labelArray[pos].setIcon(oneIcon);
			break;
		case '2':
			labelArray[pos].setIcon(twoIcon);
			break;
		case '3':
			labelArray[pos].setIcon(threeIcon);
			break;
		case '4':
			labelArray[pos].setIcon(fourIcon);
			break;
		case '5':
			labelArray[pos].setIcon(fiveIcon);
			break;
		case '6':
			labelArray[pos].setIcon(sixIcon);
			break;
		case '7':
			labelArray[pos].setIcon(sevenIcon);
			break;
		case '8':
			labelArray[pos].setIcon(eightIcon);
			break;
		case '9':
			labelArray[pos].setIcon(nineIcon);
			break;
		case '.':
			labelArray[pos].setIcon(pointIcon);
			break;
		}
	}
	
	public void loadImages() {
		
		try {
			
			oneImage = ImageIO.read(getClass().getResourceAsStream("/img/one.png"));
			oneIcon = new ImageIcon(oneImage);
			
			twoImage = ImageIO.read(getClass().getResourceAsStream("/img/two.png"));
			twoIcon = new ImageIcon(twoImage);
			
			threeImage = ImageIO.read(getClass().getResourceAsStream("/img/three.png"));
			threeIcon = new ImageIcon(threeImage);
			
			fourImage = ImageIO.read(getClass().getResourceAsStream("/img/four.png"));
			fourIcon = new ImageIcon(fourImage);
			
			fiveImage = ImageIO.read(getClass().getResourceAsStream("/img/five.png"));
			fiveIcon = new ImageIcon(fiveImage);
			
			sixImage = ImageIO.read(getClass().getResourceAsStream("/img/six.png"));
			sixIcon = new ImageIcon(sixImage);
			
			sevenImage = ImageIO.read(getClass().getResourceAsStream("/img/seven.png"));
			sevenIcon = new ImageIcon(sevenImage);
			
			eightImage = ImageIO.read(getClass().getResourceAsStream("/img/eight.png"));
			eightIcon = new ImageIcon(eightImage);
			
			nineImage = ImageIO.read(getClass().getResourceAsStream("/img/nine.png"));
			nineIcon = new ImageIcon(nineImage);
			
			zeroImage = ImageIO.read(getClass().getResourceAsStream("/img/zero.png"));
			zeroIcon = new ImageIcon(zeroImage);
			
			pointImage = ImageIO.read(getClass().getResourceAsStream("/img/point.png"));
			pointIcon = new ImageIcon(pointImage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createNumericLabels() {
		for(int i = 0; i<labelArray.length;i++) {
			labelArray[i] = new JLabel();
			labelArray[i].setBounds(coordArray[i],0,25,40);
			labelArray[i].setOpaque(true);
			this.add(labelArray[i]);
			
		}
		
	}
	public void cleanScreen() {
		for(int i = 0; i<labelArray.length;i++) {
			labelArray[i].setIcon(null);
			
		}
	}
	
}
