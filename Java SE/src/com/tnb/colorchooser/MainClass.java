package com.tnb.colorchooser;

import java.awt.Color;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawMoreStuff dms = new DrawMoreStuff();	
		dms.setBackground(Color.WHITE);
		f.add(dms);
		f.setSize(500, 270);
		f.setVisible(true);
	}

}
