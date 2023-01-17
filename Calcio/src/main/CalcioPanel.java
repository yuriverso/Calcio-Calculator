package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalcioPanel extends JPanel implements ActionListener{
	
	final int WIDTH = 290;
	final int HEIGHT = 460;
	ButtonsPanel buttonsPanel;
	NumberScreen numberScreen;
	JLabel testLabel;
	BufferedImage backgroundImage;
	JButton xButton;
	
	CalcioPanel(){
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//this.setBackground(Color.gray);
		//this.setBackground(Color.decode("#EFF2F9"));
		this.setLayout(null);
		this.setOpaque(true);
		
		xButton = new JButton("X");
		xButton.setBounds(260,0,30,30);
		xButton.setBackground(new Color(0,0,0,0));
		xButton.setOpaque(false);
		xButton.addActionListener(this);
		
		numberScreen = new NumberScreen(this);
		buttonsPanel = new ButtonsPanel(this);
		this.add(xButton);
		this.add(numberScreen);
		this.add(buttonsPanel);
		
	}
	
	public void paintComponent(Graphics g) {
		//buttonsPanel.button7.setBackground(new Color(0,0,0,0));
		super.paintComponent(g);
		try {
			backgroundImage = ImageIO.read(getClass().getResourceAsStream("/img/background_teste.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}g.drawImage(backgroundImage, 0, 0, this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == xButton) {
			System.out.println("clickando");
			System.exit(0);
		}
		
	}
	
}
