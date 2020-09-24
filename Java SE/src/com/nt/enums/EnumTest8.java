package com.nt.enums;

public class EnumTest8 {
	public static void main(String[] args) {
		Color c[] = Color.values();
		
		for(Color c1 : c) {
			c1.info();
		}
	}
}

enum Color{
	RED,GREEN,BLUE;
	
	public void info() {
		System.out.println("Universal Colors");
	}
}