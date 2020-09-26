/*
 * Robust = chance of failure in program is less
 */
package com.nt.gc;

public class GCDemo2 {
	public static void main(String[] args) {
	     String s1 = new String("Hello");
		String s2 = new String("Java");
		s1 = new String("Doctor Who"); // s1 is reassigned to new object (here old s1 is eligible)
		// 2 - Reassigning the reference variable
		s2 = s1; // s2 reassigned to s1 (here old s2 is eligible)
	}
}