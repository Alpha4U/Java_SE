package com.tnb.colorchooser;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawMoreStuff extends JPanel{
	//(0,0) starts from upper left
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.drawLine(10	, 25, 200, 45);
		
		g.setColor(Color.RED);
		g.drawRect(10, 55, 100, 30);
		
		g.setColor(Color.GREEN);
		g.fillOval(10, 95, 100, 30);
		
		g.setColor(Color.CYAN);
		g.fill3DRect(10, 160, 100, 50, true);
	}
}
