package com.nt.gc;

public class GCDemo4 {
	public static void main(String[] args) {
	    // 3 - Objects created inside a method
		String s3 = m1(); // here only s3 is pointing to same s1 object
		System.out.println(s3);
	}

	private static String m1() {
		String s1 = new String("Hello");
		String s2 = new String("Java");
		// after m1() execution 1 object (s2) eligible for GC
		// here s1 and s2 both pointing to object
		return s1;
	}
}