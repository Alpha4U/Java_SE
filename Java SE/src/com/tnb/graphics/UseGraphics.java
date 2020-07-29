package com.tnb.graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class UseGraphics extends JPanel{	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		//CAPITAL letters means constant in java
		g.setColor(Color.BLUE);
		g.fillRect(25, 25, 100, 30);
		
		g.setColor(new Color(190,81,215));//RGB values
		g.fillRect(25, 65, 100, 30);
		
		g.setColor(Color.RED);
		g.drawString("this is some text",25, 120);
		
	}
	
}
