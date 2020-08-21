//recursion = recursion is a concept in which a method calls itself

package com.tnb.recursion;

public class MainClas {
	// main
	public static void main(String[] args) {
		System.out.println(fact(5));
		System.out.println(fact(20));
		System.out.println(fact(30));
		System.out.println(fact(40));
		System.out.println(fact(70));
	}

	// fact = factorial function
	public static long fact(long n) {
		if (n <= 1)
			return 1; //base case line
		else
			return n * fact(n - 1);
	}

}
