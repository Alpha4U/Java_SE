package com.nt.applet;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawOval extends JPanel {
	private int d = 0;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(10, 10, d, d);
	}

	public void setD(int newD) {
		d = (newD >= 0 ? newD : 10);
		repaint();
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(200,200);
	}
	
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
}
