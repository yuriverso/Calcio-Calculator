package main;

import javax.swing.JFrame;


// Main Calcio class, the frame and main panel are instantiated here
public class Calcio{
	
	public static void main(String[] args) {
		// instantiating and configuring frame
		JFrame calcioFrame = new JFrame("Calcio");
		calcioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcioFrame.setResizable(false);
		calcioFrame.setUndecorated(true);
		
		// instantiating and adding main panel
		CalcioPanel calcioPanel = new CalcioPanel(calcioFrame);
		calcioFrame.add(calcioPanel);
	
		calcioFrame.pack();
		calcioFrame.setLocationRelativeTo(null);
		calcioFrame.setVisible(true);
		
		// adding dragging function to the frame
		DragListener dragL = new DragListener();
		calcioFrame.addMouseListener(dragL);
		calcioFrame.addMouseMotionListener(dragL);

	}
	
}
