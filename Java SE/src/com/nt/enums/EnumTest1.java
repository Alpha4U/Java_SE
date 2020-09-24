package com.nt.enums;

public class EnumTest1 {
	public static void main(String[] args) {
		// Enum = to represent group of names constants = 1.5v
		// enum objective is to define our own data types
		// enumerated data type 
		// can't take enums inside methods
		Beer b = Beer.RC;
		System.out.println(b); // RC = because toString() is implemented as it is
		// with switch emun is also allowed
	}
}

enum Beer{
	KF,KO,RC,FO,BW; // ; = optional
	// public static final Beer RC = new Beer();
}

enum Month{
	JAN,FEB,MAR,APR;
}

