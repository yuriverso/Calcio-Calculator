package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel implements ActionListener{
	
	final int WIDTH = 250;
	final int HEIGHT = 300;
	public String previousNumberString;
	boolean equalsPressed = false;
	double number1, number2;
	String operation;
	public CalcioPanel calcioPanel;
	int sumCounter = 0;
	BufferedImage button0Image, button0PressedImage, button1Image, button1PressedImage;
	
	JButton button1, button2, button3, button4,
			button5, button6, button7, button8,
			button9, button0, buttonPoint,
			buttonPlus, buttonMinus, buttonTimes,
			buttonDivision, buttonEquals, buttonPercentage,
			buttonSqrt, buttonPow, buttonInverse,
			buttonC, buttonBackspace;
	
	ButtonsPanel(CalcioPanel calcioPanel){
		this.calcioPanel = calcioPanel;
		
		previousNumberString = calcioPanel.numberScreen.numberToDisplay;
		
		this.setBounds(20, 80, WIDTH, HEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
		loadImages();
		createFunctionalButtons();
		createNumberButtons();
		createOperationalButtons();
		
		configureButtonsArray();
		
		
	}
	
	public void loadImages() {
		try {
			button0Image = ImageIO.read(getClass().getResourceAsStream("/img/button_0.png"));
			button0PressedImage = ImageIO.read(getClass().getResourceAsStream("/img/button_0_pressed.png"));
			button1Image = ImageIO.read(getClass().getResourceAsStream("/img/1_no_click.png"));
			button1PressedImage = ImageIO.read(getClass().getResourceAsStream("/img/1_click.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createFunctionalButtons() {
		// first line of buttons
		//clear button
		buttonC = new JButton("C");
		buttonC.setBounds(5,5,50,25);
				
		//backspace button
		buttonBackspace = new JButton("<-");
		buttonBackspace.setBounds(195,5,50,25);
		
		//equals button
		buttonEquals = new JButton("=");
		buttonEquals.setBounds(185, 235, 60, 60);
	}
	
	public void createNumberButtons() {
		//third line of buttons
		// 7 to 9
		button7 = new JButton("7");
		button7.setBounds(5, 55, 50, 50);
		
		button8 = new JButton("8");
		button8.setBounds(65, 55, 60, 60);
		
		button9 = new JButton("9");
		button9.setBounds(125, 55, 60, 60);
		
		//fourth line of buttons
		//4 to 6
		button4 = new JButton("4");
		button4.setBounds(5, 115, 60, 60);
		
		button5 = new JButton("5");
		button5.setBounds(65, 115, 60, 60);
		
		button6 = new JButton("6");
		button6.setBounds(125, 115, 60, 60);
		
		//fifth line of buttons
		//1 to 3
		button1 = new JButton("1");
		button1.setBounds(5, 175, 60, 60);
		ImageIcon image1 =new ImageIcon(button1Image);
		button1.setIcon(image1);
		ImageIcon imagePressed1 = new ImageIcon(button1PressedImage);
		button1.setPressedIcon(imagePressed1);
		//button1.setIcon(image1);
		
		button2 = new JButton("2");
		button2.setBounds(65, 175, 60, 60);
		button2.setIcon(image1);
		button2.setPressedIcon(imagePressed1);
		
		button3 = new JButton("3");
		button3.setBounds(125, 175, 60, 60);
		
		//sixth line of buttons
		// 0 and comma
		button0 = new JButton("0");
		button0.setLayout(new BorderLayout());
		button0.setBounds(5, 235, 120, 60);
		
		buttonPoint = new JButton(".");
		buttonPoint.setBounds(125, 235, 60, 60);
	}
	
	public void createOperationalButtons(){
		//second line of buttons
		//percentage, square root, and power buttons
		
		
		//last column of buttons
		// minus button
		buttonMinus = new JButton("-");
		buttonMinus.setBounds(185, 115, 60, 60);
		// plus button
		buttonPlus = new JButton("+");
		buttonPlus.setBounds(185, 175, 60, 60);
		// times button
		buttonTimes = new JButton("x");
		buttonTimes.setBounds(185, 55, 60, 30);
		// division button
		buttonDivision = new JButton("/");
		buttonDivision.setBounds(185, 85, 60, 30);
		//buttonPercentage, buttonSqrt, buttonPow,buttonInverse,
		// percentage button
		buttonPercentage = new JButton("%");
		buttonPercentage.setBounds(5, 30, 60, 25);
		// square root button
		buttonSqrt = new JButton("Sqrt");
		buttonSqrt.setBounds(65, 30, 60, 25);
		// power button
		buttonPow = new JButton("Xª");
		buttonPow.setBounds(125, 30, 60, 25);
		// inverse button
		buttonInverse = new JButton("1/X");
		buttonInverse.setBounds(185, 30, 60, 25);

	}
	
	public void configureButtonsArray() {
		JButton[] buttons = {button1, button2, button3, button4,
				button5, button6, button7, button8,
				button9, button0, buttonPoint,
				buttonPlus, buttonMinus, buttonTimes,
				buttonDivision, buttonEquals, buttonPercentage,
				buttonSqrt, buttonPow, buttonInverse,
				buttonC, buttonBackspace};
		
		for(JButton b : buttons) {
			b.setFocusable(false);
			this.add(b);
			b.addActionListener(this);
			b.setOpaque(false);
			b.setBorder(null);
			b.setBackground(new Color(0,0,0,0));
			b.setContentAreaFilled(false);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			clickNumButton("1");
		}
		if (e.getSource() == button2) {
			clickNumButton("2");
		}
		if (e.getSource() == button3) {
			clickNumButton("3");
		}
		if (e.getSource() == button4) {
			clickNumButton("4");
		}
		if (e.getSource() == button5) {
			clickNumButton("5");
		}
		if (e.getSource() == button6) {
			clickNumButton("6");
		}
		if (e.getSource() == button7) {
			clickNumButton("7");
		}
		if (e.getSource() == button8) {
			clickNumButton("8");
		}
		if (e.getSource() == button9) {
			clickNumButton("9");
		}
		if (e.getSource() == button0) {
			clickNumButton("0");
		}
		if(e.getSource() == buttonPoint) {
			if(!hasPoint(calcioPanel.numberScreen.numberToDisplay)) {
				clickNumButton(".");
			}
			
			//boolean teste = hasComma("0001,2");
			//System.out.println(teste);
		}
		if (e.getSource() == buttonC) {
			if(calcioPanel.numberScreen.numberToDisplay != "0") {
				calcioPanel.numberScreen.cleanScreen();
				calcioPanel.numberScreen.numberToDisplay = "0";
				drawNumbers("0");
				previousNumberString = "0";
				number1 = 0;
				number2 = 0;
			}
		}
		if (e.getSource() == buttonBackspace) {
			if(calcioPanel.numberScreen.numberToDisplay != "0") {
				String number = calcioPanel.numberScreen.numberToDisplay;
				String number2 = "";
				for(int i = 0; i<number.length()-1; i++) {
					number2 += number.charAt(i);
				}
				calcioPanel.numberScreen.numberToDisplay = number2;
				calcioPanel.numberScreen.cleanScreen();
				drawNumbers(number2);
				if(calcioPanel.numberScreen.numberToDisplay == "") {
					calcioPanel.numberScreen.numberToDisplay = "0";
					calcioPanel.numberScreen.cleanScreen();
					drawNumbers("0");
				}
				
			}
		}
		if (e.getSource() == buttonPlus && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("+");
			
		}
		if (e.getSource() == buttonMinus && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("-");
			
		}
		
		// times
		if(e.getSource() == buttonTimes && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("x");
			
		}
		// division
		if(e.getSource() == buttonDivision && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("/");
		}
		
		// percentage
		if(e.getSource() == buttonPercentage && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("%");
		}
		
		// square root
		if(e.getSource() == buttonSqrt && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("sqrt");
			buttonEquals.doClick();
		}
		
		// power
		if(e.getSource() == buttonPow && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("pow");
		}
		
		// inverse
		if(e.getSource() == buttonInverse && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("inv");
		}
		
		if (e.getSource() == buttonEquals) {
			System.out.println(calcioPanel.numberScreen.numberToDisplay);
			equalsPressed = true;
			number1 = Double.valueOf(previousNumberString);
			if(operation != null) {
				switch (operation){
				case "+":
					if(number2 == 0 && calcioPanel.numberScreen.numberToDisplay != "") {
						number2 = Double.valueOf(calcioPanel.numberScreen.numberToDisplay);
					}
					number1+=number2;
					previousNumberString = String.valueOf(number1);
					break;
				case "-":
					if(number2 == 0 && calcioPanel.numberScreen.numberToDisplay != "") {
						number2 = Double.valueOf(calcioPanel.numberScreen.numberToDisplay);
					}
					number1-=number2;
					previousNumberString = String.valueOf(number1);
					break;
				case "x":
					if(number2 == 0 && calcioPanel.numberScreen.numberToDisplay != "") {
						number2 = Double.valueOf(calcioPanel.numberScreen.numberToDisplay);
					}
					number1*=number2;
					previousNumberString = String.valueOf(number1);
					break;
				case "/":
					if(number2 == 0 && calcioPanel.numberScreen.numberToDisplay != "") {
						number2 = Double.valueOf(calcioPanel.numberScreen.numberToDisplay);
					}
					number1/=number2;
					previousNumberString = String.valueOf(number1);
					break;
				case "%":
					if(number2 == 0 && calcioPanel.numberScreen.numberToDisplay != "") {
						number2 = Double.valueOf(calcioPanel.numberScreen.numberToDisplay);
					}
					number1 = number1/100 * number2;
					break;
				case "sqrt":
					number1 = Double.valueOf(previousNumberString);
					number1 = Math.sqrt(number1);
					previousNumberString = String.valueOf(number1);
					break;
				case "pow":
					if(number2 == 0 && calcioPanel.numberScreen.numberToDisplay != "") {
						number2 = Double.valueOf(calcioPanel.numberScreen.numberToDisplay);
					}
					number1 = Math.pow(number1, number2);
					break;
				case "inv":
					number1 = 1/number1;
					break;
			}
				String displayNumber = String.valueOf(number1);
				//calcioPanel.numberScreen.numberLabel.setText((String.format("%.10g%n", number1).replace(',', '.')));
				if(displayNumber != "NaN") {
					//displayNumber = String.format("%.2g%n", number1).replace(',', '.');
					//System.out.println(formatNumber(displayNumber));
					// to double and then to string
					//char[] chararray = displayNumber.toCharArray();
					//calcioPanel.numberScreen.numberLabel.setText(String.valueOf(displayNumber));
					calcioPanel.numberScreen.numberToDisplay = displayNumber;
					System.out.println(calcioPanel.numberScreen.numberToDisplay);
					drawNumbers(displayNumber);
				}
				
			}
			
		}
		
	}
	
	
	public void drawNumbers(String number) {
		char[] numberArray = number.toCharArray();
		for(int i = 0;i<numberArray.length;i++) {
			if(i<10) {
				calcioPanel.numberScreen.paintNumber(numberArray[i], i);
			}
			else {
				break;
			}
		}
		
		
	}
	
	// FUNCTIONS countDecimalPlaces AND formatNumber NOT BEIGN USED
	public boolean hasPoint(String number) {
		char[] numberArray = number.toCharArray();
		for(char i:numberArray) {
			if(i == '.') {
				return true;
			}
		}
		return false;
	}
	public String formatNumber(String number) {
		int loopCount = 1;
		int zeroCount = 0;
		String number2 = "";
		System.out.println(hasPoint(number));
		if(hasPoint(number)) {
			char[] numberArray = number.toCharArray();
			while(true) {
				if(numberArray[numberArray.length-loopCount] == '0') {
					zeroCount++;
				}
				else {
					break;
				}
				loopCount++;
			}
			for(int i = 0;i<numberArray.length-zeroCount;i++) {
				number2+=numberArray[i];
			}
			return number2;
		}
		return number;
	}
	public int countDecimalPlaces(String number) {
		if(hasPoint(number)) {
			char[] numberArray = number.toCharArray();
			//int pointIndex = 0;
			for(int i = 0;i<numberArray.length;i++) {
				if(numberArray[i] == '.') {
					
				}
			}
		}
		return 0;
	}
	
	public void setOperation(String op) {
		number2 = 0;
		operation = op;
		previousNumberString = calcioPanel.numberScreen.numberToDisplay;
		calcioPanel.numberScreen.numberToDisplay = "";
		calcioPanel.numberScreen.cleanScreen();
	}
	
	public void clickNumButton(String number) {
		if(!equalsPressed) {
			if(calcioPanel.numberScreen.numberToDisplay != "0") {
				calcioPanel.numberScreen.numberToDisplay += number;
				drawNumbers(calcioPanel.numberScreen.numberToDisplay);
			}else {
				calcioPanel.numberScreen.numberToDisplay = number;
				drawNumbers(calcioPanel.numberScreen.numberToDisplay);
			}
		}else if(equalsPressed) {
			calcioPanel.numberScreen.cleanScreen();
			calcioPanel.numberScreen.numberToDisplay = number;
			drawNumbers(calcioPanel.numberScreen.numberToDisplay);
		}
		equalsPressed = false;
		
	}
	
	
}

