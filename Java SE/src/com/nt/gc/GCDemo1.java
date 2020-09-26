/*
 * Robust = chance of failure in program is less
 */
package com.nt.gc;

public class GCDemo1 {
	public static void main(String[] args) {
	      // In C++ we have to do it manually
		  // 4 ways to make object eligible for GC
		String s1 = new String("Hello");
		String s2 = new String("Java");
		// no object eligible for GC
		// now if s1 not required
		s1 = null; //1 - Nullifying the reference variable
		// now after some time if s2 is not required
		s2 = null; // s2 is eligible for garbage collection (by this step s1 and s2 both)
	}
}