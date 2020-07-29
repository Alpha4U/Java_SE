package com.tnb.jradio;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JradioUse extends JFrame{
	
	private JTextField tf;
	private Font pf;
	private Font bf;
	private Font itf;
	private Font bif;
	private JRadioButton pb;
	private JRadioButton bb;
	private JRadioButton itb;
	private JRadioButton bib;
	private ButtonGroup group;
	
	public JradioUse(){
		super("The App Title");
		setLayout(new FlowLayout());
		
		tf=new JTextField("IT's a Text Field OK",25);
		add(tf);
		pb=new JRadioButton("plain",true);
		add(pb);
		bb=new JRadioButton("bold",false);
		add(bb);
		itb=new JRadioButton("italic",false);
		add(itb);
		bib=new JRadioButton("bold and italic",false);
		add(bib);
		
		group = new ButtonGroup();
		group.add(pb);
		group.add(bb);
		group.add(bib);
		group.add(itb);
		
		pf=new Font("verdana",Font.PLAIN,14);
		bf=new Font("verdana",Font.BOLD,14);
		itf=new Font("verdana",Font.ITALIC,14);
		bif=new Font("verdana",Font.BOLD+Font.ITALIC,14);
		
		tf.setFont(pf);
		
		//wait for event to happen, pass object to constructor
		pb.addItemListener(new HandlerClass(pf));
		bb.addItemListener(new HandlerClass(bf));
		itb.addItemListener(new HandlerClass(itf));
		bib.addItemListener(new HandlerClass(bif));
		
	}
	
	public class HandlerClass implements ItemListener{
		private Font font;
		
		//the font object get variable font
		public HandlerClass(Font f) {
			font =f;
		}

		//sets the font to the font object that was passed in
		@Override
		public void itemStateChanged(ItemEvent event) {
			tf.setFont(font);
		}
		
	}
	
}
