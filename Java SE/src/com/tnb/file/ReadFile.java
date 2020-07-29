package com.tnb.file;

import java.io.File;
import java.io.WriteAbortedException;
import java.util.Scanner;

public class ReadFile {
	private Scanner sc;

	public void openFile() {
		try {
			sc = new Scanner(new File("bucky.txt"));
		} catch (Exception e) {
			System.out.println("Could Not Open File");
		}
	}
	//ctrl+shift+f = alignment
	public void readFile() {
		while (sc.hasNext()) {
			String a = sc.next();
			String b = sc.next();
			String c = sc.next();
			
			System.out.printf("%s %s %s\n",a,b,c);
		}
	}
	 
	public void closeFile(){
		sc.close();
	}

}
