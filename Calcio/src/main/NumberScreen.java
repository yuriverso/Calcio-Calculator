package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


// The panel that will display the typed and resulted numbers
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
			displayLabel.setBounds(5, 5, 194, 45);
			displayLabel.setForeground(Color.decode("#EFF2F9"));
			displayLabel.setFont(font.deriveFont(Font.BOLD, 26f));
            add(displayLabel);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
        }
	}
	
}
