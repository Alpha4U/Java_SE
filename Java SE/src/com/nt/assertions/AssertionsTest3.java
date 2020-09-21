package com.nt.assertions;

public class AssertionsTest3 {
	public static void main(String[] args) {
		int x = 10;
		assert(x==10);
		System.out.println(x);
		assert(x > 10):"Here X value should be greater than 10 but it is not"; // augmented assert
		// assert(boolean):"description"; = description can be of any type, mostly String
		System.out.println("Shubham");
	}
}
