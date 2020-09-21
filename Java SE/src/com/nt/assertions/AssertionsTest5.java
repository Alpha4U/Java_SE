package com.nt.assertions;

public class AssertionsTest5 {
	public static void main(String[] args) {
		int x = 10;
		assert(x==10):m1(); // if first arg is true, second won't be executed
		System.out.println(x); // 10
	}
	
	public static int m1() { // can't take void here	 
		return 47;
	}
}
