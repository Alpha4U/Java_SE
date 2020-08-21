package com.nt.applet;

import java.awt.Graphics;

import javax.swing.JApplet;

public class FirstApplet extends JApplet{

	public void paint(Graphics g){
		super.paint(g);
		g.drawString("Dude... Applets are Deprecated", 25, 25);
	}

}
