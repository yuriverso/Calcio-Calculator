package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Calcio {
	
	public static void main(String[] args) {
		JFrame calcioFrame = new JFrame("Calcio");
		calcioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcioFrame.setResizable(false);
		calcioFrame.getContentPane().setBackground(Color.black);
		
		CalcioPanel calcioPanel = new CalcioPanel();
		calcioFrame.add(calcioPanel);
		
		calcioFrame.pack();
		calcioFrame.setLocationRelativeTo(null);
		calcioFrame.setVisible(true);
	}
	
}
