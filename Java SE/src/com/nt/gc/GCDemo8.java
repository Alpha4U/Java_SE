package com.nt.gc;

public class GCDemo8 {
	public static void main(String[] args) {
		// 2 ways to call GC
		// 1 - Using System class (System.gc() = we can request JVM)
		// 2 - Using Runtime class
		// Runtime singleton class
		Runtime r = Runtime.getRuntime();
		System.out.println(r.totalMemory()); // heap memory size (no of bytes of total memory )
		System.out.println(r.freeMemory()); // free heap memory
		r.gc();
	}
}