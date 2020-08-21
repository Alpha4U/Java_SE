package com.nt.browser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ReadFile extends JFrame{
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public ReadFile(){
		super("Matrix Browser");
		
		addressBar = new JTextField("Enter the URL dude");
		addressBar.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent event) {
				loadStuff(event.getActionCommand());
			}
		});
		add(addressBar,BorderLayout.NORTH);
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent event) {
				//ACTIVATED means did they clicked the lin
				if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
					loadStuff(event.getURL().toString());
				}
			}
		});
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	
	public void loadStuff(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e){
			System.out.println("Crap ... !!!");
		}
	}
	
}
