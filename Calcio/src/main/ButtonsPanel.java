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
import javax.swing.BorderFactory;
import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ButtonsPanel extends JPanel implements ActionListener{
	
	final int WIDTH = 250;
	final int HEIGHT = 350;
	public String previousNumberString;
	public String markNumberString;
	boolean equalsPressed = false;
	double number1, number2;
	String operation;
	public CalcioPanel calcioPanel;
	int sumCounter = 0;
	BufferedImage button0Image, button0PressedImage, button1Image, button1PressedImage,
				  buttonCImage, buttonPercentageImage, buttonMImage, buttonBackspaceImage, buttonDivisionImage;
	
	CalcioButton button1, button2, button3, button4,
				 button5, button6, button7, button8,
				 button9, button0, buttonPoint,
				 buttonPlus, buttonMinus, buttonTimes,
				 buttonDivision, buttonEquals, buttonPercentage,
				 buttonSqrt, buttonPow, buttonInverse,
				 buttonC, buttonBackspace, buttonMark,
				 buttonWhite, buttonBlack, buttonBlue,
				 buttonPurple, buttonYellow;
	
	ButtonsPanel(CalcioPanel calcioPanel){
		this.calcioPanel = calcioPanel;
		
		previousNumberString = calcioPanel.numberScreen.numberToDisplay;
		markNumberString = "0";
		
		this.setBounds(20, 80, WIDTH, HEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		loadImages();
		createColorButtons();
		createFunctionalButtons();
		createNumberButtons();
		createOperationalButtons();
		
	}
	
	
	public void loadImages() {
		try {
			// spaces are 20% of the image width
			button0Image = ImageIO.read(getClass().getResourceAsStream("/img/button_0.png"));
			button0PressedImage = ImageIO.read(getClass().getResourceAsStream("/img/button_0_pressed.png"));
			button1Image = ImageIO.read(getClass().getResourceAsStream("/img/1_no_click.png"));
			button1PressedImage = ImageIO.read(getClass().getResourceAsStream("/img/1_click.png"));
			buttonCImage = ImageIO.read(getClass().getResourceAsStream("/img/c_noclick3.png"));
			buttonPercentageImage = ImageIO.read(getClass().getResourceAsStream("/img/small_b_test.png"));
			buttonMImage = ImageIO.read(getClass().getResourceAsStream("/img/m_noclick.png"));
			buttonBackspaceImage = ImageIO.read(getClass().getResourceAsStream("/img/backspace_noclick.png"));
			buttonDivisionImage = ImageIO.read(getClass().getResourceAsStream("/img/div_noclick.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createFunctionalButtons() {
		// first line of buttons
		//clear button
		buttonC = new CalcioButton(this, "C");
		buttonC.setBounds(15,70,55,55);
		ImageIcon imageC =new ImageIcon(buttonCImage);
		//buttonC.setIcon(imageC);
		//ImageIcon imagePressed1 = new ImageIcon(button1PressedImage);
		//button1.setPressedIcon(imagePressed1);
		//button1.setIcon(image1);
				
		//backspace button
		buttonBackspace = new CalcioButton(this, "<-");
		buttonBackspace.setBounds(125, 70, 55, 55);
		ImageIcon imageBackspace =new ImageIcon(buttonCImage);
		//buttonBackspace.setIcon(imageBackspace);
		
		//equals button
		buttonEquals = new CalcioButton(this, "=");
		buttonEquals.setBounds(180, 290, 55, 55);
		
		//mark button
		buttonMark = new CalcioButton(this, "M");
		buttonMark.setBounds(70,70,55,55);
		ImageIcon imageM =new ImageIcon(buttonCImage);
		//buttonMark.setIcon(imageM);
	}
	
	public void createNumberButtons() {
		//third line of buttons
		// 7 to 9
		button7 = new CalcioButton(this, "7");
		button7.setBounds(15, 125, 55, 55);
		
		button8 = new CalcioButton(this, "8");
		button8.setBounds(70, 125, 55, 55);
		
		button9 = new CalcioButton(this, "9");
		button9.setBounds(125, 125, 55, 55);
		
		//fourth line of buttons
		//4 to 6
		button4 = new CalcioButton(this, "4");
		button4.setBounds(15, 180, 55, 55);
		
		button5 = new CalcioButton(this, "5");
		button5.setBounds(70, 180, 55, 55);
		
		button6 = new CalcioButton(this, "6");
		button6.setBounds(125, 180, 55, 55);
		
		//fifth line of buttons
		//1 to 3
		button1 = new CalcioButton(this, "1");
		button1.setBounds(15, 235, 55, 55); 
		//ImageIcon image1 =new ImageIcon(button1Image);
		//button1.setIcon(image1);
		//ImageIcon imagePressed1 = new ImageIcon(button1PressedImage);
		//button1.setPressedIcon(imagePressed1);
		//button1.setIcon(image1);
		
		button2 = new CalcioButton(this, "2");
		button2.setBounds(70, 235, 55, 55);
		//button2.setIcon(image1);
		//button2.setPressedIcon(imagePressed1);
		
		button3 = new CalcioButton(this, "3");
		button3.setBounds(125, 235, 55, 55);
		
		//sixth line of buttons
		// 0 and comma
		button0 = new CalcioButton(this, "0");
		button0.setLayout(new BorderLayout());
		button0.setBounds(15, 290, 110, 55);
		ImageIcon image0 =new ImageIcon(button0Image);
		//button0.setIcon(image0);
		
		buttonPoint = new CalcioButton(this, ".");
		buttonPoint.setBounds(125, 290, 55, 55);
	}
	
	public void createOperationalButtons(){
		//second line of buttons
		//percentage, square root, and power buttons
		
		
		//last column of buttons
		// minus button
		buttonMinus = new CalcioButton(this, "-");
		buttonMinus.setBounds(180, 180, 55, 55);
		// plus button
		buttonPlus = new CalcioButton(this, "+");
		buttonPlus.setBounds(180, 235, 55, 55);
		// times button
		buttonTimes = new CalcioButton(this, "x");
		buttonTimes.setBounds(180, 125, 55, 55);
		// division button
		buttonDivision = new CalcioButton(this, "/");
		buttonDivision.setBounds(180, 70, 55, 55);
		ImageIcon imageDivision =new ImageIcon(buttonDivisionImage);
		buttonDivision.setIcon(imageDivision);
		
		//buttonPercentage, buttonSqrt, buttonPow,buttonInverse,
		// percentage button
		buttonPercentage = new CalcioButton(this, "%");
		buttonPercentage.setBounds(20, 35, 46, 31);
		//ImageIcon imagePercentage =new ImageIcon(buttonPercentageImage);
		//buttonPercentage.setIcon(imagePercentage);
		
		// square root button
		buttonSqrt = new CalcioButton(this, "sqrt");
		buttonSqrt.setBounds(75, 35, 46, 31);
		// power button
		buttonPow = new CalcioButton(this, "pow");
		buttonPow.setBounds(130, 35, 46, 31);
		// inverse button
		buttonInverse = new CalcioButton(this, "inv");
		buttonInverse.setBounds(185, 35, 46, 31);
	}
	
	public void createColorButtons() {
		//the tiny color buttons
		//white button
		buttonWhite = new CalcioButton(this, null);
		buttonWhite.setBounds(18,18,9,9);
		//black button
		buttonBlack = new CalcioButton(this, null);
		buttonBlack.setBounds(33,18,9,9);
		//blue button
		buttonBlue = new CalcioButton(this, null);
		buttonBlue.setBounds(48,18,9,9);
		//purple button
		buttonPurple = new CalcioButton(this, null);
		buttonPurple.setBounds(63,18,9,9);
		//yellow button
		buttonYellow = new CalcioButton(this, null);
		buttonYellow.setBounds(78,18,9,9);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		CalcioButton[] numButtons = {button1, button2, button3,
				button4, button5, button6, button7, button8,
				button9, button0, buttonPoint};
		
		CalcioButton[] opButtons = {buttonPlus, buttonMinus, buttonTimes,
				buttonDivision, buttonPercentage, buttonSqrt,
				buttonPow, buttonInverse};
		
		// listen to number buttons
		for(CalcioButton b:numButtons) {
			if(e.getSource() == b) {
				clickNumButton(b.text);
			}
		}
		
		// listen to operational buttons
		for(CalcioButton b : opButtons) {
			if (e.getSource() == b && calcioPanel.numberScreen.numberToDisplay != "") {
				setOperation(b.text);

			}
		}

		// square root
		/*if(e.getSource() == buttonSqrt && calcioPanel.numberScreen.numberToDisplay != "") {
			setOperation("sqrt");
			buttonEquals.doClick();
		}*/
		
		// listen to functional buttons
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
		if(e.getSource() == buttonMark) {
			if(markNumberString == "0" || markNumberString == "") {
				markNumberString = calcioPanel.numberScreen.numberToDisplay;
			}else {
				calcioPanel.numberScreen.numberToDisplay = markNumberString;
				markNumberString = "0";
				calcioPanel.numberScreen.cleanScreen();
				drawNumbers(calcioPanel.numberScreen.numberToDisplay);
			}
			
		}
		if (e.getSource() == buttonBackspace) {
			if(calcioPanel.numberScreen.numberToDisplay != "0") {
				String number = calcioPanel.numberScreen.numberToDisplay;
				String number2 = "";
				for(int i = 0; i<number.length()-1; i++) {
					if(i<9) {
						number2 += number.charAt(i);
					}
					
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
		
		// equals button
		if (e.getSource() == buttonEquals) {
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
				String displayNumber = "NaN";
				if((int)number1 == number1) {
					displayNumber = String.valueOf((int)number1);
				}
				else if((int)number1 != number1){
					displayNumber = String.valueOf(number1);
				}
				
				if(displayNumber != "NaN") {
					//displayNumber = String.format("%.2g%n", number1).replace(',', '.');
					// to double and then to string
					calcioPanel.numberScreen.numberToDisplay = displayNumber;
					System.out.println(calcioPanel.numberScreen.numberToDisplay);
					calcioPanel.numberScreen.cleanScreen();
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
		if(op == "-" && calcioPanel.numberScreen.numberToDisplay == "0") {
			clickNumButton("-");
		}
		else {
			number2 = 0;
			operation = op;
			previousNumberString = calcioPanel.numberScreen.numberToDisplay;
			calcioPanel.numberScreen.numberToDisplay = "";
			calcioPanel.numberScreen.cleanScreen();
		}
		
	}
	
	public void clickNumButton(String number) {
		if(!equalsPressed) {
			if(calcioPanel.numberScreen.numberToDisplay != "0" 
					&& calcioPanel.numberScreen.numberToDisplay.toCharArray().length < 10) {
				calcioPanel.numberScreen.numberToDisplay += number;
				drawNumbers(calcioPanel.numberScreen.numberToDisplay);
			}else if(calcioPanel.numberScreen.numberToDisplay.toCharArray().length < 10){
				if(number == ".") {
					calcioPanel.numberScreen.numberToDisplay += number;
					drawNumbers(calcioPanel.numberScreen.numberToDisplay);
				}

				else {
					calcioPanel.numberScreen.numberToDisplay = number;
					drawNumbers(calcioPanel.numberScreen.numberToDisplay);
				}
				
			}
		}else if(equalsPressed) {
			calcioPanel.numberScreen.cleanScreen();
			calcioPanel.numberScreen.numberToDisplay = number;
			drawNumbers(calcioPanel.numberScreen.numberToDisplay);
		}
		equalsPressed = false;
		
	}
	
	
}

