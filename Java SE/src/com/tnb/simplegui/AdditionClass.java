package com.tnb.simplegui;

import javax.swing.JOptionPane;

public class AdditionClass {

	public static void main(String[] args) {
		
		String fn = JOptionPane.showInputDialog("Enter First Number : ");
		String sn = JOptionPane.showInputDialog("Enter Second Number : ");
		
		int num1 = Integer.parseInt(fn);
		int num2 = Integer.parseInt(sn);
		
		int sum = num1+num2;
		
		JOptionPane.showMessageDialog(null, "The Answer is :"+sum,"Addition Program",JOptionPane.PLAIN_MESSAGE);

	}

}
