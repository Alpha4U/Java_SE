package com.nt.gc;

public class GCDemo3 {
	public static void main(String[] args) {
	    // 3 - Objects created inside a method
		m1();
	}

	private static void m1() {
		String s1 = new String("Hello");
		String s2 = new String("Java");
		System.out.println(s1);
		System.out.println(s2);
		// after m1() execution 2 obj eligible for GC
	}
}