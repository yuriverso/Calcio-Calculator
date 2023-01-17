package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Calcio {
	
	public static void main(String[] args) {
		JFrame calcioFrame = new JFrame("Calcio");
		calcioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcioFrame.setResizable(false);
		calcioFrame.getContentPane().setBackground(Color.black);
		calcioFrame.setLayout(new BorderLayout());
		calcioFrame.setUndecorated(true);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setPreferredSize(new Dimension(290, 50));
		titlePanel.setBackground(new Color(0,0,0,0));
		//calcioFrame.add(titlePanel, BorderLayout.NORTH);
		
		JButton xButton = new JButton("X");
		titlePanel.add(xButton, BorderLayout.LINE_END);
			
		CalcioPanel calcioPanel = new CalcioPanel();
		calcioFrame.add(calcioPanel, BorderLayout.SOUTH);
		
		calcioFrame.pack();
		calcioFrame.setLocationRelativeTo(null);
		calcioFrame.setVisible(true);
		
		DragListener dragL = new DragListener();
		calcioFrame.addMouseListener(dragL);
		calcioFrame.addMouseMotionListener(dragL);

	}
	
}
