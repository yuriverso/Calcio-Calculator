package main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


// class responsible for painting the buttons and background
public class CalcioPainter {
	
	CalcioPanel cPanel;
	ButtonsPanel bPanel;
	
	JLabel calcioIconLabel;
	
	// declaring all images to be loaded
	BufferedImage nullImage, null2Image, backgroundImage, zeroImage, zeroClickedImage,
				  oneImage, oneClickedImage, twoImage, twoClickedImage, threeImage,
				  threeClickedImage, fourImage, fourClickedImage, fiveImage, fiveClickedImage,
				  sixImage, sixClickedImage, sevenImage, sevenClickedImage, eightImage, 
				  eightClickedImage, nineImage, nineClickedImage, commaImage, commaClickedImage,
				  plusImage, plusClickedImage, minusImage, minusClickedImage, timesImage, 
				  timesClickedImage, divisionImage, divisionClickedImage, equalsImage, 
				  equalsClickedImage, cImage, cClickedImage, markImage, markClickedImage, 
				  backspaceImage, backspaceClickedImage, percentageClickedImage, sqrtClickedImage,
				  powClickedImage, invClickedImage, closeClickedImage, minimizeClickedImage;
	
	// declaring all icons to be created with the loaded images
	ImageIcon nullIcon, null2Icon, backgroundIcon, zeroIcon, zeroClickedIcon, oneIcon,
			  oneClickedIcon, twoIcon, twoClickedIcon, threeIcon, threeClickedIcon, fourIcon,
			  fourClickedIcon, fiveIcon, fiveClickedIcon, sixIcon, sixClickedIcon, sevenIcon,
			  sevenClickedIcon, eightIcon, eightClickedIcon, nineIcon, nineClickedIcon, commaIcon,
			  commaClickedIcon, plusIcon, plusClickedIcon, minusIcon, minusClickedIcon, timesIcon,
			  timesClickedIcon, divisionIcon, divisionClickedIcon, equalsIcon, equalsClickedIcon,
			  cIcon, cClickedIcon, markIcon, markClickedIcon, backspaceIcon, backspaceClickedIcon,
			  percentageClickedIcon, sqrtClickedIcon, powClickedIcon, invClickedIcon, closeClickedIcon,
			  minimizeClickedIcon;
	
	CalcioPainter(CalcioPanel cPanel, ButtonsPanel bPanel){
		this.cPanel = cPanel;
		this.bPanel = bPanel;
		loadImages("black");
	}
	
	// method to paint background
	public void paintBg() {
		backgroundIcon = new ImageIcon(backgroundImage);
		cPanel.backgroundLabel.setIcon(backgroundIcon);
	}
	
	// method to paint buttons
	public void paintButtons() {
		nullIcon = new ImageIcon(nullImage);
		null2Icon = new ImageIcon(null2Image);
		
		// CLOSE AND MINIMIZE ICONS
		closeClickedIcon = new ImageIcon(closeClickedImage);
		cPanel.xButton.setIcon(null2Icon);
		cPanel.xButton.setPressedIcon(closeClickedIcon);
		
		minimizeClickedIcon = new ImageIcon(minimizeClickedImage);
		cPanel._Button.setIcon(null2Icon);
		cPanel._Button.setPressedIcon(minimizeClickedIcon);
		
		
		// NUMERIC ICONS
		zeroIcon = new ImageIcon(zeroImage);
		zeroClickedIcon = new ImageIcon(zeroClickedImage);
		bPanel.button0.setIcon(zeroIcon);
		bPanel.button0.setPressedIcon(zeroClickedIcon);
		
		oneIcon = new ImageIcon(oneImage);
		oneClickedIcon = new ImageIcon(oneClickedImage);
		bPanel.button1.setIcon(oneIcon);
		bPanel.button1.setPressedIcon(oneClickedIcon);
		
		twoIcon = new ImageIcon(twoImage);
		twoClickedIcon = new ImageIcon(twoClickedImage);
		bPanel.button2.setIcon(twoIcon);
		bPanel.button2.setPressedIcon(twoClickedIcon);
		
		threeIcon = new ImageIcon(threeImage);
		threeClickedIcon = new ImageIcon(threeClickedImage);
		bPanel.button3.setIcon(threeIcon);
		bPanel.button3.setPressedIcon(threeClickedIcon);
		
		fourIcon = new ImageIcon(fourImage);
		fourClickedIcon = new ImageIcon(fourClickedImage);
		bPanel.button4.setIcon(fourIcon);
		bPanel.button4.setPressedIcon(fourClickedIcon);
		
		fiveIcon = new ImageIcon(fiveImage);
		fiveClickedIcon = new ImageIcon(fiveClickedImage);
		bPanel.button5.setIcon(fiveIcon);
		bPanel.button5.setPressedIcon(fiveClickedIcon);
		
		sixIcon = new ImageIcon(sixImage);
		sixClickedIcon = new ImageIcon(sixClickedImage);
		bPanel.button6.setIcon(sixIcon);
		bPanel.button6.setPressedIcon(sixClickedIcon);
		
		sevenIcon = new ImageIcon(sevenImage);
		sevenClickedIcon = new ImageIcon(sevenClickedImage);
		bPanel.button7.setIcon(sevenIcon);
		bPanel.button7.setPressedIcon(sevenClickedIcon);
		
		eightIcon = new ImageIcon(eightImage);
		eightClickedIcon = new ImageIcon(eightClickedImage);
		bPanel.button8.setIcon(eightIcon);
		bPanel.button8.setPressedIcon(eightClickedIcon);
		
		nineIcon = new ImageIcon(nineImage);
		nineClickedIcon = new ImageIcon(nineClickedImage);
		bPanel.button9.setIcon(nineIcon);
		bPanel.button9.setPressedIcon(nineClickedIcon);
		
		commaIcon = new ImageIcon(commaImage);
		commaClickedIcon = new ImageIcon(commaClickedImage);
		bPanel.buttonComma.setIcon(commaIcon);
		bPanel.buttonComma.setPressedIcon(commaClickedIcon);
		
		
		// OPERATIONAL ICONS
		plusIcon = new ImageIcon(plusImage);
		plusClickedIcon = new ImageIcon(plusClickedImage);
		bPanel.buttonPlus.setIcon(plusIcon);
		bPanel.buttonPlus.setPressedIcon(plusClickedIcon);
		
		minusIcon = new ImageIcon(minusImage);
		minusClickedIcon = new ImageIcon(minusClickedImage);
		bPanel.buttonMinus.setIcon(minusIcon);
		bPanel.buttonMinus.setPressedIcon(minusClickedIcon);
		
		timesIcon = new ImageIcon(timesImage);
		timesClickedIcon = new ImageIcon(timesClickedImage);
		bPanel.buttonTimes.setIcon(timesIcon);
		bPanel.buttonTimes.setPressedIcon(timesClickedIcon);
		
		divisionIcon = new ImageIcon(divisionImage);
		divisionClickedIcon = new ImageIcon(divisionClickedImage);
		bPanel.buttonDivision.setIcon(divisionIcon);
		bPanel.buttonDivision.setPressedIcon(divisionClickedIcon);
		
		percentageClickedIcon = new ImageIcon(percentageClickedImage);
		bPanel.buttonPercentage.setIcon(nullIcon);
		bPanel.buttonPercentage.setPressedIcon(percentageClickedIcon);
		
		sqrtClickedIcon = new ImageIcon(sqrtClickedImage);
		bPanel.buttonSqrt.setIcon(nullIcon);
		bPanel.buttonSqrt.setPressedIcon(sqrtClickedIcon);
		
		powClickedIcon = new ImageIcon(powClickedImage);
		bPanel.buttonPow.setIcon(nullIcon);
		bPanel.buttonPow.setPressedIcon(powClickedIcon);
		
		invClickedIcon = new ImageIcon(invClickedImage);
		bPanel.buttonInverse.setIcon(nullIcon);
		bPanel.buttonInverse.setPressedIcon(invClickedIcon);
		
		
		// FUNCTIONAL ICONS
		equalsIcon = new ImageIcon(equalsImage);
		equalsClickedIcon = new ImageIcon(equalsClickedImage);
		bPanel.buttonEquals.setIcon(equalsIcon);
		bPanel.buttonEquals.setPressedIcon(equalsClickedIcon);
		
		cIcon = new ImageIcon(cImage);
		cClickedIcon = new ImageIcon(cClickedImage);
		bPanel.buttonC.setIcon(cIcon);
		bPanel.buttonC.setPressedIcon(cClickedIcon);
		
		markIcon = new ImageIcon(markImage);
		markClickedIcon = new ImageIcon(markClickedImage);
		bPanel.buttonMark.setIcon(markIcon);
		bPanel.buttonMark.setPressedIcon(markClickedIcon);
		
		backspaceIcon = new ImageIcon(backspaceImage);
		backspaceClickedIcon = new ImageIcon(backspaceClickedImage);
		bPanel.buttonBackspace.setIcon(backspaceIcon);
		bPanel.buttonBackspace.setPressedIcon(backspaceClickedIcon);
		
		
	}
	
	// method to load all the needed images
	public void loadImages(String color) {
		try {
			nullImage = ImageIO.read(getClass().getResourceAsStream("/img/null.png"));
			null2Image = ImageIO.read(getClass().getResourceAsStream("/img/null2.png"));
			backgroundImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/background.png"));
			zeroImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/zero.png"));
			zeroClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/zero_clicked.png"));
			oneImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/one.png"));
			oneClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/one_clicked.png"));
			twoImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/two.png"));
			twoClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/two_clicked.png"));
			threeImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/three.png"));
			threeClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/three_clicked.png"));
			fourImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/four.png"));
			fourClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/four_clicked.png"));	
			fiveImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/five.png"));
			fiveClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/five_clicked.png"));	
			sixImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/six.png"));
			sixClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/six_clicked.png"));	
			sevenImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/seven.png"));
			sevenClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/seven_clicked.png"));	
			eightImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/eight.png"));
			eightClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/eight_clicked.png"));	
			nineImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/nine.png"));
			nineClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/nine_clicked.png"));	
			commaImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/comma.png"));
			commaClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/comma_clicked.png"));	
			plusImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/plus.png"));
			plusClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/plus_clicked.png"));	
			minusImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/minus.png"));
			minusClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/minus_clicked.png"));	
			timesImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/times.png"));
			timesClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/times_clicked.png"));	
			divisionImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/division.png"));
			divisionClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/division_clicked.png"));	
			equalsImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/equals.png"));
			equalsClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/equals_clicked.png"));	
			cImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/c.png"));
			cClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/c_clicked.png"));	
			markImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/m.png"));
			markClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/m_clicked.png"));	
			backspaceImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/backspace.png"));
			backspaceClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/backspace_clicked.png"));	
			percentageClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/percentage_clicked.png"));
			sqrtClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/sqrt_clicked.png"));
			powClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/pow_clicked.png"));
			invClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/inverse_clicked.png"));
			closeClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/close_clicked.png"));
			minimizeClickedImage = ImageIO.read(getClass().getResourceAsStream("/img/"+color+"/minimize_clicked.png"));;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
