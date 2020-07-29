package com.tnb.file;

import java.util.Formatter;

public class WritingToFile {
	private Formatter x;
	
	public void openFile() {
		try{
			x=new Formatter("bucky.txt");
		}catch(Exception e){
			System.out.println("Error Occured");
		}
	}
	
	public void addRecords(){
		x.format("%s %s %s", "22","Shubham","Awasthi");
	}
	
	public void closeFile(){
		x.close();
	}

}
