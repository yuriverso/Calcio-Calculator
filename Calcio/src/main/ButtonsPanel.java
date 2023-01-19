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
	
	CalcioPainter calcioPainter;
	
	CalcioButton button1, button2, button3, button4,
				 button5, button6, button7, button8,
				 button9, button0, buttonComma,
				 buttonPlus, buttonMinus, buttonTimes,
				 buttonDivision, buttonEquals, buttonPercentage,
				 buttonSqrt, buttonPow, buttonInverse,
				 buttonC, buttonBackspace, buttonMark,
				 buttonWhite, buttonBlack, buttonBlue,
				 buttonPurple, buttonYellow;
	
	ButtonsPanel(CalcioPanel calcioPanel){
		this.calcioPanel = calcioPanel;
		calcioPainter = new CalcioPainter(calcioPanel, this);
		
		
		previousNumberString = calcioPanel.numberScreen.numberToDisplay;
		markNumberString = "0";
		
		this.setBounds(20, 110, WIDTH, HEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBorder(null);
		
		createColorButtons();
		createFunctionalButtons();
		createNumberButtons();
		createOperationalButtons();
		calcioPainter.paintButtons();
		
	}
	
	
	public void createFunctionalButtons() {
		// first line of buttons
		//clear button
		buttonC = new CalcioButton(this, "C");
		buttonC.setBounds(15,70,55,55);
		//ImageIcon imageC =new ImageIcon(buttonCImage);
		//buttonC.setIcon(imageC);
		//ImageIcon imagePressed1 = new ImageIcon(button1PressedImage);
		//button1.setPressedIcon(imagePressed1);
		//button1.setIcon(image1);
				
		//backspace button
		buttonBackspace = new CalcioButton(this, "<-");
		buttonBackspace.setBounds(125, 70, 55, 55);

		
		//equals button
		buttonEquals = new CalcioButton(this, "=");
		buttonEquals.setBounds(180, 290, 55, 55);
		
		//mark button
		buttonMark = new CalcioButton(this, "M");
		buttonMark.setBounds(70,70,55,55);

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

		
		buttonComma = new CalcioButton(this, ".");
		buttonComma.setBounds(125, 290, 55, 55);
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

		
		//buttonPercentage, buttonSqrt, buttonPow,buttonInverse,
		// percentage button
		buttonPercentage = new CalcioButton(this, "%");
		buttonPercentage.setBounds(20, 35, 46, 31);

		
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
		buttonWhite = new CalcioButton(this, "white");
		buttonWhite.setBounds(18,18,9,9);
		//black button
		buttonBlack = new CalcioButton(this, "black");
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
				button9, button0, buttonComma};
		
		CalcioButton[] opButtons = {buttonPlus, buttonMinus, buttonTimes,
				buttonDivision, buttonPercentage, buttonSqrt,
				buttonPow, buttonInverse};
		
		CalcioButton[] colorButtons = {buttonWhite, buttonBlack, buttonBlue,
				 buttonPurple, buttonYellow};
		
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
		
		for(CalcioButton b : colorButtons) {
			if(e.getSource() == b) {
				System.out.println(b.text);
				calcioPainter.loadImages(b.text);
				calcioPainter.paintBg();
				calcioPainter.paintButtons();
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
				calcioPanel.numberScreen.numberToDisplay = "0";
				calcioPanel.numberScreen.displayLabel.setText(calcioPanel.numberScreen.numberToDisplay);
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
				calcioPanel.numberScreen.displayLabel.setText(calcioPanel.numberScreen.numberToDisplay);
				markNumberString = "0";
			}
			
		}
		if (e.getSource() == buttonBackspace) {
			if(calcioPanel.numberScreen.numberToDisplay != "0") {
				String number = calcioPanel.numberScreen.numberToDisplay;
				String number2 = "";
				for(int i = 0; i<number.length()-1; i++) {
					if(i<calcioPanel.numberScreen.displayLength-1) {
						number2 += number.charAt(i);
					}
					
				}
				calcioPanel.numberScreen.numberToDisplay = number2;
				calcioPanel.numberScreen.displayLabel.setText(calcioPanel.numberScreen.numberToDisplay);
				if(calcioPanel.numberScreen.numberToDisplay == "") {
					calcioPanel.numberScreen.numberToDisplay = "0";
					calcioPanel.numberScreen.displayLabel.setText(calcioPanel.numberScreen.numberToDisplay);
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
					calcioPanel.numberScreen.displayLabel.setText(prepareNumber(displayNumber));
					
				}
				
			}
			
			
			
		}
		
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
		}
		
	}
	
	public void clickNumButton(String number) {
		if(!equalsPressed) {
			if(calcioPanel.numberScreen.numberToDisplay != "0" 
					&& calcioPanel.numberScreen.numberToDisplay.toCharArray().length < 10) {
				calcioPanel.numberScreen.numberToDisplay += number;
				calcioPanel.numberScreen.displayLabel.setText(prepareNumber(calcioPanel.numberScreen.numberToDisplay));
			}else if(calcioPanel.numberScreen.numberToDisplay.toCharArray().length < 10){
				if(number == ".") {
					calcioPanel.numberScreen.numberToDisplay += number;
					calcioPanel.numberScreen.displayLabel.setText(prepareNumber(calcioPanel.numberScreen.numberToDisplay));
					
				}

				else {
					calcioPanel.numberScreen.numberToDisplay = number;
					calcioPanel.numberScreen.displayLabel.setText(prepareNumber(calcioPanel.numberScreen.numberToDisplay));
				}
				
			}
		}else if(equalsPressed) {
			calcioPanel.numberScreen.numberToDisplay = number;
			calcioPanel.numberScreen.displayLabel.setText(prepareNumber(calcioPanel.numberScreen.numberToDisplay));
		}
		equalsPressed = false;
		
	}
	
	public String formatNumber(String number) {
		char[] numberArray = number.toCharArray();
		String number2 = "";
		if(numberArray.length > 9) {
			for(int i = 0; i < 10; i++) {
				number2 += numberArray[i];
			}
			return number2;
		}else {
			return number;
		}
	}
	
	public String prepareNumber(String number) {
		
		number = number.replace(".", ",");
		String integerPart = "";
		String decimalPart = "";
		String preparedNumber = "";
		char[] numberArray = {};
		int tCount = 0;
		
		
		if(number.contains(",") && number.charAt(number.length()-1) != ',') {
			integerPart = number.split(",")[0];
			decimalPart = number.split(",")[1];
		}else if(number.contains(",") && number.charAt(number.length()-1) == ',' && number.length() > 1) {
			integerPart = number.split(",")[0];
			decimalPart = ",";
		}else if(!number.contains(",")) {
			integerPart = number;
		}else if(number.contains(",") && number.length() == 1) {
			return "0,";
		}
		numberArray = integerPart.toCharArray();
		
		for(int i = 0; i < numberArray.length; i++) {
			if(tCount == 3) {
				preparedNumber += ".";
				tCount = 0;
			}
			preparedNumber += numberArray[(numberArray.length-1)-i];
			tCount ++;
			
		}
		numberArray = preparedNumber.toCharArray();
		preparedNumber = "";
		for(int i = 0;i < numberArray.length; i++) {
			preparedNumber += numberArray[(numberArray.length-1)-i];
		}
		if(decimalPart != "" && decimalPart != ",") {
			preparedNumber = preparedNumber+","+decimalPart;
			return formatNumber(preparedNumber);
		}else {
			preparedNumber += decimalPart;
			return formatNumber(preparedNumber);
		}
		
		
	}
	
	
}

