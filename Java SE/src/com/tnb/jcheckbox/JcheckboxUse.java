package com.tnb.jcheckbox;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JcheckboxUse extends JFrame{
	private JTextField tf1;
	private JCheckBox boldBox;
	private JCheckBox italicBox;
	
	public JcheckboxUse(){
		super("The App Title");
		setLayout(new FlowLayout());
		
		tf1=new JTextField("Enter Text Here");
		tf1.setFont(new Font("Verdana",Font.PLAIN,14));
		add(tf1);
		
		boldBox = new JCheckBox("bold");
		add(boldBox);
		
		italicBox = new JCheckBox("italic");
		add(italicBox);
		
		HandlerClass handler = new HandlerClass();
		boldBox.addItemListener(handler);
		italicBox.addItemListener(handler);
	}
	
	//this class is inside so that it can see what's already developed in the class
	private class HandlerClass implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			
			Font font = null;
			if(boldBox.isSelected() && italicBox.isSelected()){
				font = new Font("verdana",Font.BOLD+Font.ITALIC,14);
			}else if(boldBox.isSelected()){
				font = new Font("verdana",Font.BOLD,14);
			}else if(italicBox.isSelected()){
				font = new Font("verdana",Font.ITALIC,14);
			}else{
				font = new Font("verdana",Font.PLAIN, 14);
			}
			tf1.setFont(font);
			
		}
	}
}
