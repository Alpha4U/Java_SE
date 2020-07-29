package com.tnb.jlist;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JlistUse extends JFrame{
	
	private JList list;
	private static String[] colornames={"red","green","blue","yellow"};
	private static Color[] colors={Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW};
	
	public JlistUse(){
		super("The App Title");
		setLayout(new FlowLayout());
		
		list=new JList(colornames);
		list.setVisibleRowCount(4	);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		
		list.addListSelectionListener(
			new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent event) {
					getContentPane().setBackground(colors[list.getSelectedIndex()]);
				}
			}
		);
		
	}
	
}
