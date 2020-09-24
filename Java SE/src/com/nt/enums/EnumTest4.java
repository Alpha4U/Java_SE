package com.nt.enums;

public class EnumTest4 {
	public static void main(String[] args) {
		Beer5 b = Beer5.RC;
		System.out.println("Hello");
		// Beer4 b1 = new Beer4();
	}
}

enum Beer5{
	BW(50),RC(60),KO(70),SO(80),VK; // these all are nothing but static objects only
	Beer5(int num){
		System.out.println("Beer4(int) - Constructor");
	}
	
	Beer5(){
		System.out.println("Beer5.Beer5()");
	}
}