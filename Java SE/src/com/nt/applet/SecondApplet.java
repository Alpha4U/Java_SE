package com.nt.applet;

import java.awt.Graphics;

import javax.swing.JApplet;
import javax.swing.JOptionPane;

public class SecondApplet extends JApplet {
	private double sum;

	public void init() {
		String fn = JOptionPane.showInputDialog("Enter First Number");
		String sn = JOptionPane.showInputDialog("Enter Second Number");

		double n1 = Double.parseDouble(fn);
		double n2 = Double.parseDouble(sn);

		sum = n1 + n2;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("The Sum is " + sum, 25, 30);
	}
}
