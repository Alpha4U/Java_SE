package com.tnb.jcombobox;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JcomboUse extends JFrame{
	private JComboBox box;
	private JLabel picture;
	
	private static String[] filename ={"/1.png","/2.png"};
	private Icon[] pics={new ImageIcon(getClass().getResource(filename[0])),new ImageIcon(getClass().getResource(filename[1]))};
	
	public JcomboUse(){
		super("The App Title");
		setLayout(new FlowLayout());
		
		box=new JComboBox(filename);	
		//instead of HandlerClass we can make use of Anonymous inner class
		box.addItemListener(
				
				//anonymous inner class
				new ItemListener() {	
					@Override
					public void itemStateChanged(ItemEvent event) {
						if(event.getStateChange()==ItemEvent.SELECTED){
							picture.setIcon(pics[box.getSelectedIndex()]);
						}
					}
				}
				
		);
		add(box);
		picture=new JLabel(pics[0]);
		add(picture);
	} 
}
