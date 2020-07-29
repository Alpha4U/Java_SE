package com.tnb.guieventapp;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		
		BuildClass bcObj = new BuildClass();
		bcObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bcObj.setSize(300, 100);
		bcObj.setVisible(true);

	}

}
