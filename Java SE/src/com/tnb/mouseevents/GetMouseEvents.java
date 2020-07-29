package com.tnb.mouseevents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GetMouseEvents extends JFrame{
	private JPanel mousepanel;
	private JLabel statusbar;
	
	public GetMouseEvents(){
		super("Mouse Movement App");
		setLayout(new FlowLayout());
		
		mousepanel = new JPanel();
		mousepanel.setBackground(Color.WHITE);
		add(mousepanel,BorderLayout.CENTER);
		statusbar = new JLabel("default");
		add(statusbar,BorderLayout.SOUTH);
		
		HandlerClass handler = new HandlerClass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		
	}
	
	private class HandlerClass implements MouseListener,MouseMotionListener{
		public void mouseClicked(MouseEvent event){
			statusbar.setText(String.format("Clicked at %d,%d", event.getX(),event.getY()));
		}
		public void mousePressed(MouseEvent event){
			statusbar.setText("You Pressed down the mouse");
		}
		public  void mouseReleased(MouseEvent event){
			statusbar.setText("You Released the Button");
		}
		public void mouseEntered(MouseEvent event){
			statusbar.setText("You Entered the area");
			mousepanel.setBackground(Color.RED);
		}
		public void mouseExited(MouseEvent event){
			statusbar.setText("the mouse has left the window");
			mousepanel.setBackground(Color.WHITE);
		}
		public void mouseDragged(MouseEvent event){
			statusbar.setText("you are dragging the mouse");
		}
		public void mouseMoved(MouseEvent event){
			statusbar.setText("you moved the mouse");
		}
	}
}
