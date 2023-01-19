package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalcioPanel extends JPanel implements ActionListener{
	
	final int WIDTH = 290;
	final int HEIGHT = 490;
	public String bgColor = "black";
	
	JFrame frame;
	JButton xButton, _Button;
	ButtonsPanel buttonsPanel;
	NumberScreen numberScreen;
	CalcioPainter calcioPainter;
	JLabel backgroundLabel;
	JLabel testLabel;

	
	CalcioPanel(JFrame frame){
		this.frame = frame;
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//this.setBackground(Color.gray);
		//this.setBackground(Color.decode("#EFF2F9"));
		setLayout(null);
		setOpaque(true);
		//loadImages();
		backgroundLabel = new JLabel();
		backgroundLabel.setText(null);
		backgroundLabel.setBounds(0, 0, WIDTH, HEIGHT);
		//add(backgroundLabel);
		
		xButton = new JButton();
		xButton.setBounds(259,-2,35,34);
		xButton.setText(null);
		xButton.setBackground(new Color(0,0,0,0));
		xButton.setFocusable(false);
		xButton.setOpaque(false);
		xButton.setBorder(null);
		xButton.setContentAreaFilled(false);
		xButton.addActionListener(this);
		
		_Button = new JButton();
		_Button.setBounds(239,-2,35,34);
		_Button.setText(null);
		_Button.setBackground(new Color(0,0,0,0));
		_Button.setFocusable(false);
		_Button.setOpaque(false);
		_Button.setBorder(null);
		_Button.setContentAreaFilled(false);
		_Button.addActionListener(this);
		
		
		/*try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/font/arialr.ttf"));
			testLabel = new JLabel("teste 123");
			testLabel.setBounds(0, 30, 200, 40);
			testLabel.setFont(font.deriveFont(Font.BOLD, 48f));
            add(testLabel);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }*/
		
		
		
		numberScreen = new NumberScreen(this);
		buttonsPanel = new ButtonsPanel(this);
		calcioPainter = new CalcioPainter(this, buttonsPanel);
		calcioPainter.paintBg();
		add(xButton);
		add(_Button);
		add(numberScreen);
		add(buttonsPanel);
		add(backgroundLabel);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == xButton) {
			System.out.println("clickando");
			System.exit(0);
		}
		if(e.getSource() == _Button) {
			frame.setState(Frame.ICONIFIED);
		}
		
	}
	
}
