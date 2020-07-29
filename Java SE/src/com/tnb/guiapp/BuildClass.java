package com.tnb.guiapp;
	
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BuildClass extends JFrame{

	private JLabel item1;
	
	public BuildClass(){
		super("The Application Title");
		setLayout(new FlowLayout());
		
		item1 = new JLabel("This is a Sentence");
		item1.setToolTipText("Show on Hover tooltip");
		add(item1);		
	}
}