package com.tnb.layouts;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UseLayouts extends JFrame{
	private JButton lb;
	private JButton cb;
	private JButton rb;
	private FlowLayout layout;
	private Container container;	
	
	public UseLayouts(){
		super("The Layout App");
		layout=new FlowLayout();	
		container = getContentPane();
		setLayout(layout);
		
		//left stuff in here
		lb=new JButton("left");
		add(lb);
		lb.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.LEFT);
						layout.layoutContainer(container);
					}
				}
		);
	
		//center stuff in here
		cb=new JButton("center");
		add(cb);
		cb.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.CENTER);
						layout.layoutContainer(container);
					}
				}
		);
	
		//left right in here
		rb=new JButton("right");
		add(rb);
		rb.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.RIGHT);
						layout.layoutContainer(container);
					}
				}
		);
	
	}
	
}
