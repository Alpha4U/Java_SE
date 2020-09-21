package com.nt.assertions;

public class AssertionsTest4 {
	public static void main(String[] args) {
		int x = 10;
		assert(x==10):++x; // if first arg is true, second won't be executed
		System.out.println(x); // 10
	}
}
