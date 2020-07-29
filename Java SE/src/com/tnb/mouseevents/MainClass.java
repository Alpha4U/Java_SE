package com.tnb.mouseevents;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		
		GetMouseEvents goObj = new GetMouseEvents();
		goObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		goObj.setSize(300,200);
		goObj.setVisible(true);

	}

}
