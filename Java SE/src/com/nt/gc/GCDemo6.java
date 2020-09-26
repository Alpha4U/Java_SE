package com.nt.gc;

public class GCDemo6 {
	static String s ;
	public static void main(String[] args) {
		m1();
		// after m1() execution 1 object is eligible for GC 
		// because of no reference
	}

	private static void m1() {
		s = new String("Hello");
		String s1 = new String("Manya");
	}
}