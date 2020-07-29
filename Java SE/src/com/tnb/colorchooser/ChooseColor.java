package com.tnb.colorchooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ChooseColor extends JFrame{
	private JButton b;
	private Color color = Color.WHITE;
	private JPanel panel;
	
	public ChooseColor(){
		super("title color app");
		panel=new JPanel();
		
		panel.setBackground(color);
		b=new JButton("Choose a Color");
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				color=JColorChooser.showDialog(null, "Pick Color", color);
				if(color==null){
					color=Color.WHITE;
				}
				panel.setBackground(color);
			}
		});
		
		add(panel,BorderLayout.CENTER);
		add(b,BorderLayout.SOUTH);
		setSize(425,150);
		setVisible(true);
	}
}
