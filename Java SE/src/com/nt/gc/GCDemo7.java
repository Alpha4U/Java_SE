package com.nt.gc;

public class GCDemo7 {
	// 4 - Island Of Isolation
	GCDemo7 o;
	public static void main(String[] args) {
		GCDemo7 o1 = new GCDemo7();
		GCDemo7 o2 = new GCDemo7();
		GCDemo7 o3 = new GCDemo7();
		// by this no obj eligible for garbage collection
		o1.o = o2;
		o2.o = o3;
		o3.o = o1;
		// no objects are eligible for GC
		System.out.println(o1.o);
		System.out.println(o2.o);
		System.out.println(o3.o);
		o1 = null;
		o2 = null;
		// still no objects are eligible for GC
		// because o3.o still pointing to o1 and so on
		o3 = null;
		// now all three objects are eligible for GC
		// all internal references between objects become invalid if there is no external reference 
		// Example - Titanic Sinking Example
	}
}