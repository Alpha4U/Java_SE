package com.tnb.adapterclasses;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class UseAdapterClass extends JFrame{
	private String details;
	private JLabel statusbar;
	
	public UseAdapterClass(){
		super("Adapter Class App");
		
		statusbar = new JLabel("this is default");
		add(statusbar,BorderLayout.SOUTH);
		addMouseListener(new MouseClass());
		
	}
	
	private class MouseClass extends MouseAdapter{
		public void mouseClicked(MouseEvent event){
			details=String.format("You Clicked %d", event.getClickCount());
			if(event.isMetaDown()){
				details+="with the right mouse button";
			}else if(event.isAltDown()){
				details+="with the scroll button";
			}else{
				details+="with the left mouse down";
			}
			
			statusbar.setText(details);
		}
	}
	
}
