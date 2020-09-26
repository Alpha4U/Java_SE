package com.nt.gc;

import java.util.Date;

public class GCDemo9 {
	// System.gc() = static method
	// r.gc() = instance method
	// convenient to use System.gc() 
	// recommended to use Runtime.getRuntime().gc() because of one less method call
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		System.out.println(r.totalMemory());
		System.out.println(r.freeMemory());
		for (int i = 1; i <= 10000; i++) {
			Date d = new Date(); // 10000 date obj got created
			d = null; // all 10000 obj are eligible for GC
		}
		System.out.println(r.freeMemory());
		r.gc();
		System.out.println(r.freeMemory()); // 30 - 40 - 50 - 60 - 80 etc
		System.gc();
	}
}