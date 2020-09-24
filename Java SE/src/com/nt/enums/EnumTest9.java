package com.nt.enums;

public class EnumTest9 {
	public static void main(String[] args) {
		Colors c[] = Colors.values();
		
		for(Colors c1 : c) {
			c1.info();
		}
		
		// difference between enum, Enum, Enumeration
		// enum = keyword in java used to define named constants
		// Enum = class in java java.lang.Enum, direct super class of every enum
		// Enumeration = interface in java.util to get objects one by one from collection
	}
}

enum Colors{
	BLUE,RED{
		public void info() {System.out.println("Dangerous Color");} // anonymous inner classes concept
	},GREEN;
	
	public void info() {
		System.out.println("Universal Colors");
	}
}