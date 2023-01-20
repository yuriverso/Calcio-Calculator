package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


// The main panel of the Calcio Calculator
public class CalcioPanel extends JPanel implements ActionListener, KeyListener{
	
	final int WIDTH = 290;
	final int HEIGHT = 490;
	
	JFrame frame;
	JButton xButton, _Button;
	ButtonsPanel buttonsPanel;
	NumberScreen numberScreen;
	CalcioPainter calcioPainter;
	JLabel backgroundLabel;
	
	CalcioPanel(JFrame frame){
		
		this.frame = frame;
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setLayout(null);
		setOpaque(true);
		setFocusable(true);
		
		// this label is going to receive the background image
		backgroundLabel = new JLabel();
		backgroundLabel.setText(null);
		backgroundLabel.setBounds(0, 0, WIDTH, HEIGHT);
		
		// button to close the application
		xButton = new JButton();
		xButton.setBounds(259,-2,35,34);
		xButton.setText(null);
		xButton.setBackground(new Color(0,0,0,0));
		xButton.setFocusable(false);
		xButton.setOpaque(false);
		xButton.setBorder(null);
		xButton.setContentAreaFilled(false);
		xButton.addActionListener(this);
		
		// button to minimize the application
		_Button = new JButton();
		_Button.setBounds(235,-2,35,34);
		_Button.setText(null);
		_Button.setBackground(new Color(0,0,0,0));
		_Button.setFocusable(false);
		_Button.setOpaque(false);
		_Button.setBorder(null);
		_Button.setContentAreaFilled(false);
		_Button.addActionListener(this);
		
		// instantiating the display screen, the buttons panel and the painter class
		numberScreen = new NumberScreen(this);
		buttonsPanel = new ButtonsPanel(this);
		calcioPainter = new CalcioPainter(this, buttonsPanel);
		calcioPainter.paintBg();
		add(xButton);
		add(_Button);
		add(numberScreen);
		add(buttonsPanel);
		add(backgroundLabel);
		addKeyListener(this);
	}
	
	
	
	// listening to close and minimize buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == xButton) {
			System.exit(0);
		}
		if(e.getSource() == _Button) {
			frame.setState(Frame.ICONIFIED);
		}
		
	}

	
	// listening to keyboard
	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		switch(c) {
		case '\n':
			buttonsPanel.buttonEquals.doClick();
			break;
		case '0':
			buttonsPanel.button0.doClick();
			break;
		case '1':
			buttonsPanel.button1.doClick();
			break;
		case '2':
			buttonsPanel.button2.doClick();
			break;
		case '3':
			buttonsPanel.button3.doClick();
			break;
		case '4':
			buttonsPanel.button4.doClick();
			break;
		case '5':
			buttonsPanel.button5.doClick();
			break;
		case '6':
			buttonsPanel.button6.doClick();
			break;
		case '7':
			buttonsPanel.button7.doClick();
			break;
		case '8':
			buttonsPanel.button8.doClick();
			break;
		case '9':
			buttonsPanel.button9.doClick();
			break;
		case ',':
			buttonsPanel.buttonComma.doClick();
			break;
		case '+':
			buttonsPanel.buttonPlus.doClick();
			break;
		case '-':
			buttonsPanel.buttonMinus.doClick();
			break;
		case '*':
			buttonsPanel.buttonTimes.doClick();
			break;
		case '/':
			buttonsPanel.buttonDivision.doClick();
			break;
		case '':
			buttonsPanel.buttonC.doClick();
			break;
		case '':
			buttonsPanel.buttonBackspace.doClick();
			break;

		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {		
	}


	@Override
	public void keyReleased(KeyEvent e) {
	}
	
}
