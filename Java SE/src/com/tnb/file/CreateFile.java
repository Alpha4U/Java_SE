package com.tnb.file;

import java.io.IOException;
import java.util.Formatter;

public class CreateFile {

	public static void main(String[] args) {
		//formatter used to put string into a file
		final Formatter f ;
		
		try{
			f = new Formatter("alpha.txt");
			System.out.println("File Created");
			//file will be created in workspace folder within the project
		}catch(IOException ioe){
			System.out.println("Problem in creating file");
		}

	}

}
