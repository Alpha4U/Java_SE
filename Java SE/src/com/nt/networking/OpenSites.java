package com.nt.networking;

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class OpenSites extends JApplet{
	private HashMap<String,URL> websiteInfo;
	private ArrayList<String> titles;
	private JList mainList;
	
	//init
	public void init(){
		websiteInfo = new HashMap<String,URL>();
		titles=new ArrayList<String>();
		
		grabHtmlInfo();
		add(new JLabel("what websites you want to visit "),BorderLayout.NORTH);
		mainList = new JList(titles.toArray());
		
		mainList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Object object = mainList.getSelectedValue();
				URL newDocument = websiteInfo.get(object);
				AppletContext browser = getAppletContext();
				browser.showDocument(newDocument);
			}
		});
		add(new JScrollPane(mainList),BorderLayout.CENTER);
	}

	private void grabHtmlInfo() {
		String title;
		String address;
		URL url;
		int counter =0;
		title=getParameter("title : "+titles);
		
		while(title !=null){
			address=getParameter("address : "+counter);
			try{
				url=new URL(address);
				websiteInfo.put(title, url);
				titles.add(title);
			}catch(MalformedURLException urlException){
				urlException.printStackTrace();
			}
			++counter;
			title=getParameter("title : "+counter);
		}
	}	
}
