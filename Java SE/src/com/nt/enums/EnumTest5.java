package com.nt.enums;

public class EnumTest5 {
	public static void main(String[] args) {
		Beer4 b = Beer4.RC;
		System.out.println("Hello");
		// Beer4 b1 = new Beer4();
	}
}

enum Beer4{
	BW,RC,KO,SO,VK; // these all are nothing but static objects only
	Beer4(){
		System.out.println("Beer4 - Constructor");
	}
}