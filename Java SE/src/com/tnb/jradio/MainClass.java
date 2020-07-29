package com.tnb.jradio;

import javax.swing.JFrame;

public class MainClass {

	public static void main(String[] args) {
		JradioUse goObj = new JradioUse();
		goObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		goObj.setSize(500,200);
		goObj.setVisible(true);
	}

}
