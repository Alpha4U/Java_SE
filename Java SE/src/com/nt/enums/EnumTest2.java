package com.nt.enums;

public class EnumTest2 {
	public static void main(String[] args) {
		Beer2 b = Beer2.BW;
		
		switch (b) {
		case BW:
			System.out.println("Budweiser");
			break;
		default:
			System.out.println("Others Not Recommeded");
			break;
		}
		
	}
}

enum Beer2 {
	KF,BW,RC
}
