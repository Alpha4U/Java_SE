package com.tnb.graphics;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("Title");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UseGraphics ug = new UseGraphics();
		f.add(ug);
		f.setSize(400,250);
		f.setVisible(true);
		
	}

}
