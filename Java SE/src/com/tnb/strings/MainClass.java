package com.tnb.strings;

public class MainClass {

	public static void main(String[] args) {
		String a="shubham";
		String b="CODES";
		String c="codes";
		
		System.out.println(a.length());
		if(a.equals("shubham")){
			System.out.println("Name is Shubham");
		}
		
		if(b.equalsIgnoreCase(c)){
			System.out.println("Shubham loves to code");
		}
	}

}
