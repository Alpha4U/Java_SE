package com.tnb.file;

import java.io.File;

public class MainClass {
	public static void main(String[] args) {
		//to check weather file exist or not
		File f = new File("E:\\test\\alpha.txt");
		if(f.exists()){
			System.out.println(f.getName()+" file exist");
		}else{
			System.out.println(f.getName()+" file doesn't exist");
		}
	}
}
