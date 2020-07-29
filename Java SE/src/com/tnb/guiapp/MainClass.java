package com.tnb.guiapp;
import javax.swing.JFrame;

public class MainClass{
	public static void main(String[] args) {
		BuildClass conObj = new BuildClass();
		conObj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		conObj.setSize(300, 300);
		conObj.setVisible(true);
	}
}
