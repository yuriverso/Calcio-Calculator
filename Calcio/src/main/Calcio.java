package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Calcio{
	
	public static void main(String[] args) {
		JFrame calcioFrame = new JFrame("Calcio");
		calcioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcioFrame.setResizable(false);
		calcioFrame.setUndecorated(true);
		
		CalcioPanel calcioPanel = new CalcioPanel(calcioFrame);
		calcioFrame.add(calcioPanel);
	
		calcioFrame.pack();
		calcioFrame.setLocationRelativeTo(null);
		calcioFrame.setVisible(true);
		
		DragListener dragL = new DragListener();
		calcioFrame.addMouseListener(dragL);
		calcioFrame.addMouseMotionListener(dragL);

	}
	
}
