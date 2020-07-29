package com.tnb.jbutton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JbuttonUse extends JFrame{
	
	private JButton reg;
	private JButton custom;
	
	public JbuttonUse(){
		super("JApp Title");
		setLayout(new FlowLayout());
		
		reg=new JButton("Registration");
		add(reg);
		
		Icon a = new ImageIcon(getClass().getResource("/1.png"));
		Icon b = new ImageIcon(getClass().getResource("/2.png"));
		custom = new JButton("Custom",a);
		custom.setRolloverIcon(b);
		add(custom);
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler);
		custom.addActionListener(handler);
		
	}
	
	private class HandlerClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
		}
		
	}
	

}
