package com.nt.applet;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TheWindow extends JFrame{
	//in windows the body goes into window and in java panel goes into frame
	private JSlider slider;
	private DrawOval myPanel;
	
	public TheWindow(){
		super("title");
		myPanel=new DrawOval();
		myPanel.setBackground(Color.ORANGE);
		
		slider=new JSlider(SwingConstants.HORIZONTAL,0,200,10);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				myPanel.setD(slider.getValue());
			}
		});
		
		add(slider,BorderLayout.SOUTH);
		add(myPanel,BorderLayout.CENTER);
	}
	
}
