package main;

import javax.swing.JFrame;

public class Calcio {
	
	public static void main(String[] args) {
		JFrame calcioFrame = new JFrame("Calcio");
		calcioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcioFrame.setResizable(false);
		
		CalcioPanel calcioPanel = new CalcioPanel();
		calcioFrame.add(calcioPanel);
		
		calcioFrame.pack();
		calcioFrame.setLocationRelativeTo(null);
		calcioFrame.setVisible(true);
	}
	
}
