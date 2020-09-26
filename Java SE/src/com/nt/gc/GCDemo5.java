package com.nt.gc;

public class GCDemo5 {
	public static void main(String[] args) {
		m1();
		// after m1() execution 2 objects are eligible for GC 
		// because of no reference
	}

	private static String m1() {
		String s1 = new String("Hello");
		String s2 = new String("Java");
		// here s1 and s2 both pointing to object
		return s1;
	}
}